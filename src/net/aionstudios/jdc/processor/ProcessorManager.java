package net.aionstudios.jdc.processor;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages {@link Processor}s and {@link ElementProcessor}s for a content processor.
 * @author Winter Roberts
 */
public class ProcessorManager {
	
	private List<ProcessorSet> pss = new ArrayList<ProcessorSet>();
	
	public ProcessorManager() {
		
	}
	
	/**
	 * Adds a {@link ProcessorSet}, with it's {@link Processors}s and
	 * {@link ElementProcessor}s to this manager.
	 * @param e
	 */
	public void addProcessorSet(ProcessorSet e) {
		for(ProcessorSet ep : pss) {
			if(ep.getName() == e.getName()) {
				pss.remove(ep);
				pss.add(e);
				return;
			}
		}
		pss.add(e);
	}
	
	/**
	 * @return The {@link ProcessorSet}s registered to this manager.
	 */
	public List<ProcessorSet> getProcessorSets() {
		return pss;
	}

}
