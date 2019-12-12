package net.aionstudios.jdc.processor;

import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import net.aionstudios.jdc.content.JDCElement;
import net.aionstudios.jdc.content.JDCHeadElement;
import net.aionstudios.jdc.content.RequestVariables;
import net.aionstudios.jdc.cron.CronCompute;

/**
 * Generates page content when requested in a JDC document or as part of an
 * on-demand or cron-based {@link ComputeSchedule}.
 * @author Winter Roberts
 */
public abstract class ElementProcessor {
	
	private String name;
	private ComputeSchedule computeSchedule;
	
	private CronCompute cp;
	
	private String lastCompute;
	
	/**
	 * Creates a new Element Processor, with the given named, parent {@link ProcessorSet}
	 * and following the given {@link ComputeSchedule}.
	 * @param name The name of this Element Processor.
	 * @param set The {@link ProcessorSet} which this Element Processor should be a child of.
	 * @param cs The {@link ComputeSchedule} which should be used by this Element Processor.
	 */
	public ElementProcessor(String name, ProcessorSet set, ComputeSchedule cs) {
		this.name = name;
		this.computeSchedule = cs;
		set.addElementProcessor(this);
		if(cs==ComputeSchedule.CRON) {
			cp.enable();
		}
	}
	
	/**
	 * @return The name of this Element Processor.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The {@link CronComputer} schedule for this Element Processor if one has been set.
	 */
	public CronCompute getCronCompute() {
		return cp;
	}
	
	/**
	 * @return The {@link ComputeSchedule} which should be used by this Element Processor.
	 */
	public ComputeSchedule getComputeSchedule() {
		return computeSchedule;
	}
	
	/**
	 * Computes or copies and returns the current content which should be used to replace the
	 * JDC tag which called it, in the document.
	 * @param element The {@link JDCHeadElement} which spawned this call.
	 * @param he The {@link HttpExchange} to which the client request to the page that called
	 * this Element Processor is connected.
	 * @param vars The {@link RequestVariables} which have been processed from the client request.
	 * @param pageVariables A map of variables used to pass information around the document in
	 * a way the supersedes tag scope.
	 * @return The content which should replace the JDC tah which called this method, in the document.
	 */
	public String getContent(JDCHeadElement element, HttpExchange he, RequestVariables vars, Map<String, Object> pageVariables) {
		if(computeSchedule==ComputeSchedule.LIVE) {
			generateContent(element, he, vars, pageVariables);
			return element.makeString();
		}
		return lastCompute;
	}
	
	/**
	 * Computes a version of this page on a non-live {@link ComputeSchedule}.
	 */
	public void updateCompute() {
		JDCHeadElement e = new JDCHeadElement(null);
		generateContent(e);
		lastCompute = e.makeString();
	}
	
	/**
	 * A Content Processor implementor method which generates the content which should be used to 
	 * replace the JDC tag which called it, in the document.
	 * @param element The {@link JDCHeadElement} which spawned this call.
	 * @param he The {@link HttpExchange} to which the client request to the page that called
	 * this Element Processor is connected.
	 * @param vars The {@link RequestVariables} which have been processed from the client request.
	 * @param pageVariables A map of variables used to pass information around the document in
	 * a way the supersedes tag scope.
	 */
	public abstract void generateContent(JDCHeadElement element, HttpExchange he, RequestVariables vars, Map<String, Object> pageVariables);
	
	/**
	 * A Content Processor implementor method which generates the content which should be used to 
	 * replace the JDC tag which called it, in the document.
	 * @param element The {@link JDCHeadElement} which spawned this call.
	 */
	public abstract void generateContent(JDCHeadElement element);

}
