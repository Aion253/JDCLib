package net.aionstudios.jdc.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An interstitial collector of {@link Processor}s and {@link ElementProcessor}s.
 * @author Winter Roberts
 */
public class ProcessorSet {
	
	//multiple per processorset
	private String name;
	private Map<String, ElementProcessor> eps = new HashMap<>();
	private Map<String, Processor> ps = new HashMap<>();
	
	/**
	 * Creates a processor set with the given name and parent {@link ProcessorManager}.
	 * @param name The name of this processor set.
	 * @param pm The {@link ProcessorManager} which this processor set should be a child of.
	 */
	public ProcessorSet(String name, ProcessorManager pm) {
		this.name = name;
		pm.addProcessorSet(this);
	}
	
	/**
	 * Adds an {@link ElementProcessor} to this processor set.
	 * @param e The {@link ElementProcessor} to be added.
	 */
	public void addElementProcessor(ElementProcessor e) {
		eps.put(e.getName(), e);
	}
	
	/**
	 * @return A collection of the {@link ElementProcessor}s to which this processor set
	 * is a parent.
	 */
	public Map<String, ElementProcessor> getElementProcessors() {
		return eps;
	}
	
	/**
	 * Adds an {@link Processor} to this processor set.
	 * @param e The {@link Processor} to be added.
	 */
	public void addProcessor(Processor e) {
		ps.put(e.getName(), e);
	}
	
	/**
	 * @return A collection of the {@link Processor}s to which this processor set
	 * is a parent.
	 */
	public Map<String, Processor> getProcessors() {
		return ps;
	}
	
	/**
	 * @return The name of this Element Processor.
	 */
	public String getName() {
		return name;
	}

}
