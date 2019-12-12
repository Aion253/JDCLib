package net.aionstudios.jdc.cron;

import net.aionstudios.jdc.processor.ElementProcessor;

/**
 * Computes the content of an {@link ElementProcessor} as a {@link CronJob}.
 * <p>
 * THIS CLASS IS NOT IMPLEMENTED!
 * @author Winter Roberts
 */
public class CronCompute extends CronJob {
	
	private ElementProcessor ep;

	/**
	 * Creates a new cron compute, scheduling the referenced {@link ElementProcessor}
	 * to compute on each cron hit.
	 * @param ep The {@link ElementProcessor} which should be computed on intervals
	 * defined by this {@link CronJob}.
	 */
	public CronCompute(ElementProcessor ep) {
		super(new CronDateTime());
		this.ep = ep;
	}

	@Override
	public void run() {
		ep.updateCompute();
	}

}
