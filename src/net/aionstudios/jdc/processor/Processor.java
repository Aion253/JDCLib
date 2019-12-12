package net.aionstudios.jdc.processor;

import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import net.aionstudios.jdc.content.JDCHeadElement;
import net.aionstudios.jdc.content.RequestVariables;
import net.aionstudios.jdc.cron.CronCompute;

/**
 * Runs Content Processor code without generating content.
 * Only available for live compute scenarios.
 * @author Winter Roberts
 */
public abstract class Processor {
	
	private String name;
	
	/**
	 * Creates a new Processor, with the given named and parent {@link ProcessorSet}.
	 * @param name The name of this Element Processor.
	 * @param set The {@link ProcessorSet} which this Element Processor should be a child of.
	 */
	public Processor(String name, ProcessorSet set) {
		this.name = name;
		set.addProcessor(this);
	}
	
	/**
	 * @return The name of this Processor.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * WHY DO I EVEN EXIST!!!
	 */
	public void startCompute(HttpExchange he, RequestVariables vars, Map<String, Object> pageVariables) {
		compute(he, vars, pageVariables);
	}
	
	/**
	 * A Content Processor implementor method which computes the code which should be run
	 * when this method is called by a JDC tag in the document.
	 * @param he The {@link HttpExchange} to which the client request to the page that called
	 * this Element Processor is connected.
	 * @param vars The {@link RequestVariables} which have been processed from the client request.
	 * @param pageVariables A map of variables used to pass information around the document in
	 * a way the supersedes tag scope.
	 */
	public abstract void compute(HttpExchange he, RequestVariables vars, Map<String, Object> pageVariables);
	
}
