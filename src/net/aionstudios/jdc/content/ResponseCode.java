package net.aionstudios.jdc.content;

/**
 * Enumerates possible response statuses.
 * 
 * @author Winter Roberts
 *
 */
public enum ResponseCode {
	
	OK(200),
	NO_CONTENT(204),
	NOT_FOUND(404),
	INTERNAL_SERVER_ERROR(500);

	private final int value;

	/**
	 * Creates a {@link ResponseStatus} by value.
	 * 
	 * @param newValue An integer representing the value of an enum in this class.
	 */
	ResponseCode(final int newValue) {
		value = newValue;
	}
	
	public String getDefaultErrorPage(String pageName) {
		return "<h1>"+getCodeName()+"</h1><p>"+getCodeDesc(pageName)+"</p>";
	}

	/**
	 * @return The numeric value of a definition.
	 */
	public int getCode() {
		return value;
	}
	
	/**
	 * @return A string representing the name of this {@link ResponseCode}.
	 */
	public String getCodeName() {
		if(value==200) {
			return "OK";
		} else if(value==404) {
			return "Not Found";
		} else if(value==500) {
			return "Internal Server Error";
		} else if(value==204) {
			return "No Content";
		}
		return null;
	}
	
	/**
	 * @return A string describing what this {@link ResponseCode} means.
	 */
	public String getCodeDesc(String pageName) {
		if(value==200) {
			return "The request was completed without serious error and returned valid data.";
		} else if(value==404) {
			return "The requested resource, '"+pageName+"', was not found on this server.";
		} else if(value==500) {
			return "The server encountered an unhandled internal error and was unable to complete your request.";
		} else if(value==500) {
			return "The request was completed without serious error but returned no data.";
		}
		return null;
	}

}
