package net.aionstudios.jdc.processor;

import java.util.ArrayList;
import java.util.List;

public class ProcessorSet {
	
	//multiple per processorset
	private String name;
	private List<ElementProcessor> eps = new ArrayList<ElementProcessor>();
	
	public ProcessorSet(String name, ProcessorManager pm) {
		this.name = name;
		pm.addProcessorSet(this);
	}
	
	public void addElementProcessor(ElementProcessor e) {
		for(ElementProcessor ep : eps) {
			if(ep.getName() == e.getName()) {
				eps.remove(ep);
				eps.add(e);
				return;
			}
		}
		eps.add(e);
	}
	
	public List<ElementProcessor> getElementProcessors() {
		return eps;
	}
	
	public String getName() {
		return name;
	}

}
