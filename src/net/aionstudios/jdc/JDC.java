package net.aionstudios.jdc;

import net.aionstudios.jdc.processor.ProcessorManager;

/**
 * The base class for content processors. JDC Server will load this to enable
 * user code related to it.
 * @author Winter Roberts
 */
public abstract class JDC {
	
	private ProcessorManager pm = new ProcessorManager();
	
	public JDC() {
	}
	
	//Where ElementsProcessors are added to ProcessorSets, of which an empty ArrayList is provided
	//By the JDC file.
	/**
	 * Initializes {@link ProcessorSet}s, and {@link ElementProcessor}s, among other application-local
	 * functionality for the content processor which owns this JDC.
	 */
	public abstract void initialize();

	/**
	 * @return The {@link ProcessorManager} for this JDC, to which {@link ProcessorSet}s
	 * and their registered {@link ElementProcessor}s should be registered.
	 */
	public ProcessorManager getProcessorManager() {
		return pm;
	}
	
	//Override me!
	public void onShutdown() {
		
	}

}
