package net.aionstudios.jdc.cron;

import net.aionstudios.jdc.processor.ElementProcessor;

public class CronCompute extends CronJob {
	
	private ElementProcessor ep;

	public CronCompute(ElementProcessor ep) {
		super(new CronDateTime());
		this.ep = ep;
	}

	@Override
	public void run() {
		ep.updateCompute();
	}

}
