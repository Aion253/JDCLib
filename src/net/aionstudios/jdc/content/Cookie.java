package net.aionstudios.jdc.content;

import java.util.Date;

import net.aionstudios.jdc.service.DateTimeServices;

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
	
	public Cookie(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
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

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public void setMaxAge(long maxAge) {
		this.maxAge = maxAge;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public void setHttpOnly(boolean httpOnly) {
		this.httpOnly = httpOnly;
	}

}
