package net.aionstudios.jdc.processor;

import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import net.aionstudios.jdc.content.JDCElement;
import net.aionstudios.jdc.content.JDCHeadElement;
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
	
	public String getContent(JDCHeadElement element, HttpExchange he, Map<String, String> post, Map<String, String> get) {
		if(computeSchedule.getTypeInt()==1) {
			generateContent(element, he, post, get);
			return element.makeString();
		}
		return lastCompute;
	}
	
	public void updateCompute() {
		JDCHeadElement e = new JDCHeadElement();
		generateContent(e);
		lastCompute = e.makeString();
	}
	
	public abstract void generateContent(JDCHeadElement element, HttpExchange he, Map<String, String> post, Map<String, String> get);
	
	public abstract void generateContent(JDCHeadElement element);

}
