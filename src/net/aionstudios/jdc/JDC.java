package net.aionstudios.jdc;

import net.aionstudios.jdc.processor.ProcessorManager;

public abstract class JDC {
	
	private ProcessorManager pm = new ProcessorManager();
	
	public JDC() {
	}
	
	//Where ElementsProcessors are added to ProcessorSets, of which an empty ArrayList is provided
	//By the JDC file.
	public abstract void initialize();

	public ProcessorManager getProcessorManager() {
		return pm;
	}

}
