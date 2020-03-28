package net.aionstudios.jdc.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages {@link Processor}s and {@link ElementProcessor}s for a content processor.
 * @author Winter Roberts
 */
public class ProcessorManager {
	
	private Map<String, ProcessorSet> pss = new HashMap<>();
	
	public ProcessorManager() {
		
	}
	
	/**
	 * Adds a {@link ProcessorSet}, with it's {@link Processors}s and
	 * {@link ElementProcessor}s to this manager.
	 * @param e
	 */
	public void addProcessorSet(ProcessorSet e) {
		pss.put(e.getName(), e);
	}
	
	/**
	 * @return The {@link ProcessorSet}s registered to this manager.
	 */
	public Map<String, ProcessorSet> getProcessorSets() {
		return pss;
	}

}
