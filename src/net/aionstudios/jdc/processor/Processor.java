package net.aionstudios.jdc.processor;

import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import net.aionstudios.jdc.content.JDCHeadElement;
import net.aionstudios.jdc.content.RequestVariables;
import net.aionstudios.jdc.cron.CronCompute;

public abstract class Processor {
	
	private String name;
	
	public Processor(String name, ProcessorSet set) {
		this.name = name;
		set.addProcessor(this);
	}
	
	public String getName() {
		return name;
	}
	
	public void startCompute(HttpExchange he, RequestVariables vars, Map<String, Object> pageVariables) {
		compute(he, vars, pageVariables);
	}
	
	public abstract void compute(HttpExchange he, RequestVariables vars, Map<String, Object> pageVariables);
	
}
