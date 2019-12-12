package net.aionstudios.jdc.content;

import java.util.Date;

import net.aionstudios.jdc.service.DateTimeServices;

/**
 * Defines an API for working with client browser cookies.
 * @author Winter Roberts
 */
public class Cookie {
	
	private String name;
	private String value;
	
	private Date expiry = null;
	private long maxAge = -Long.MAX_VALUE;
	private String domain = null;
	private String path = null;
	private boolean secure = false;
	private boolean httpOnly = false;
	//Because the SameSite api is not officially supported it has not been added to this file.
	
	/**
	 * Creates a cookie definition to be set in the response to a client request.
	 * @param name The name of this cookie.
	 * @param value The value of this cookie.
	 */
	public Cookie(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Builds the string which sets the value of this cookie in the client's browser,
	 * including adding cache, domain, and security options.
	 * @return The client response setter string for this cookie.
	 */
	public String makeSetterString() {
		String setter = name+"="+value;
		if(domain!=null&&domain.length()>4) {
			setter += "; Domain="+domain;
		}
		if(path!=null) {
			setter += "; Path="+path;
		}
		if(maxAge!=-Long.MAX_VALUE) {
			setter += "; Max-Age="+maxAge;
		}
		if(secure) {
			setter += "; Secure";
		}
		if(httpOnly) {
			setter += "; HttpOnly";
		}
		if(expiry!=null&&expiry.after(new Date())) {
			setter += "; Expires="+DateTimeServices.getHttpTime(expiry);
		}
		return setter;
	}

	/**
	 * Sets the name of this cookie.
	 * @param name The new name of this cookie.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the value of this cookie.
	 * @param value The new value of this cookie.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Sets the time at which this cookie should expire.
	 * @param expiry The Date when this cookie should expire.
	 */
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	/**
	 * Sets the max age of this cookie, before it should be auto-removed.
	 * @param maxAge The milliseconds from request when this cookie should expire.
	 */
	public void setMaxAge(long maxAge) {
		this.maxAge = maxAge;
	}

	/**
	 * Sets the domain(s) for which this cookie should be transmitted.
	 * @param domain The domain(s) for which this cookie should be transmitted.
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * Sets the request context for which this cookie should be transmitted.
	 * @param path The request context for which this cookie should be transmitted.
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Sets whether or not this cookie can be transmitted over insecure connections.
	 * @param secure False if the cookie can be transmitted over insecure connections.
	 */
	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	/**
	 * Sets whether or not this cookie should be accessible to client scripts.
	 * @param httpOnly False if this cookie should be accessible to client scripts.
	 */
	public void setHttpOnly(boolean httpOnly) {
		this.httpOnly = httpOnly;
	}

}
