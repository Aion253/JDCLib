package net.aionstudios.jdc.processor;

public enum ComputeSchedule {
	
	LIVE(1),
	CRON(2),
	DEMAND(3);

	private final int value;

	/**
	 * Creates a {@link ComputeSchedule} by value.
	 * 
	 * @param newValue An integer representing the value of an enum in this class.
	 */
	ComputeSchedule(final int newValue) {
		value = newValue;
	}
	
	/**
	 * @return A string representing the name of this {@link RateEventReference}.
	 */
	public String getTypeName() {
		if(value==1) {
			return "Live Content Compute";
		}
		if(value==2) {
			return "Cron Content Compute";
		}
		if(value==3) {
			return "On Demand Content Compute";
		}
		return "Unrecognized";
	}
	
	public int getTypeInt() {
		return value;
	}

}
