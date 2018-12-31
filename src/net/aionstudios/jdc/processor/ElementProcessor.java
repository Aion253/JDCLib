package net.aionstudios.jdc.processor;

import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import net.aionstudios.jdc.content.JDCElement;
import net.aionstudios.jdc.content.JDCHeadElement;
import net.aionstudios.jdc.content.RequestVariables;
import net.aionstudios.jdc.cron.CronCompute;

public abstract class ElementProcessor {
	
	private String name;
	private ComputeSchedule computeSchedule;
	
	private CronCompute cp;
	
	private String lastCompute;
	
	public ElementProcessor(String name, ProcessorSet set, ComputeSchedule cs) {
		this.name = name;
		this.computeSchedule = cs;
		set.addElementProcessor(this);
		if(cs.getTypeInt()==2) {
			cp.enable();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public CronCompute getCronCompute() {
		return cp;
	}
	
	public ComputeSchedule getComputeSchedule() {
		return computeSchedule;
	}
	
	public String getContent(JDCHeadElement element, HttpExchange he, RequestVariables vars, Map<String, Object> pageVariables) {
		if(computeSchedule.getTypeInt()==1) {
			generateContent(element, he, vars, pageVariables);
			return element.makeString();
		}
		return lastCompute;
	}
	
	public void updateCompute() {
		JDCHeadElement e = new JDCHeadElement(null);
		generateContent(e);
		lastCompute = e.makeString();
	}
	
	public abstract void generateContent(JDCHeadElement element, HttpExchange he, RequestVariables vars, Map<String, Object> pageVariables);
	
	public abstract void generateContent(JDCHeadElement element);

}
