package net.aionstudios.jdc.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookieManager {
	
	private List<Cookie> newCookies;
	private Map<String, String> requestCookies;
	
	public CookieManager() {
		newCookies = new ArrayList<Cookie>();
		requestCookies = new HashMap<String, String>();
	}
	
	public CookieManager(Map<String, String> cookies) {
		newCookies = new ArrayList<Cookie>();
		requestCookies = new HashMap<String, String>();
		if(cookies!=null&&!cookies.isEmpty()) {
			this.requestCookies = cookies;
		}
	}
	
	public Cookie setCookie(String name, String value) {
		Cookie c = new Cookie(name, value);
		newCookies.add(c);
		return c;
	}
	
	public void addCookie(Cookie c) {
		newCookies.add(c);
	}
	
	public List<Cookie> getNewCookies() {
		return newCookies;
	}
	
	public Map<String, String> getRequestCookies() {
		return requestCookies;
	}
	
	public String getRequestCookie(String name) {
		return requestCookies.get(name);
	}

}
