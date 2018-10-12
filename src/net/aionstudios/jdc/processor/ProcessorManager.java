package net.aionstudios.jdc.processor;

import java.util.ArrayList;
import java.util.List;

public class ProcessorManager {
	
	private List<ProcessorSet> pss = new ArrayList<ProcessorSet>();
	
	public ProcessorManager() {
		
	}
	
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
	
	public List<ProcessorSet> getProcessorSets() {
		return pss;
	}

}
