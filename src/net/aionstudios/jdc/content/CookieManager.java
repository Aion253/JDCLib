package net.aionstudios.jdc.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages cookies to be set and sent by a request.
 * @author Winter Roberts
 */
public class CookieManager {
	
	private List<Cookie> newCookies;
	private Map<String, String> requestCookies;
	
	/**
	 * Creates a cookie manager with no request cookies.
	 */
	public CookieManager() {
		newCookies = new ArrayList<Cookie>();
		requestCookies = new HashMap<String, String>();
	}
	
	/**
	 * Creates a cookie manager with request cookies.
	 * @param cookies The cookies transmitted by the client.
	 */
	public CookieManager(Map<String, String> cookies) {
		newCookies = new ArrayList<Cookie>();
		requestCookies = new HashMap<String, String>();
		if(cookies!=null&&!cookies.isEmpty()) {
			this.requestCookies = cookies;
		}
	}
	
	/**
	 * Creates, adds, and returns a new {@link Cookie} for the server response.
	 * @param name The name of the new {@link Cookie}.
	 * @param value The value of the new {@link Cookie}.
	 * @return The {@link Cookie} created by this method.
	 */
	public Cookie setCookie(String name, String value) {
		Cookie c = new Cookie(name, value);
		newCookies.add(c);
		return c;
	}
	
	/**
	 * Adds a {@link Cookie} to this cookie manager, for the server response.
	 * @param c The {@link Cookie} that should be added.
	 */
	public void addCookie(Cookie c) {
		newCookies.add(c);
	}
	
	/**
	 * @return A list of all {@link Cookie}s that should be set by the server response.
	 */
	public List<Cookie> getNewCookies() {
		return newCookies;
	}
	
	/**
	 * @return A Map of name and value pairs of {@link Cookie}s that were transmitted by
	 * the client request.
	 */
	public Map<String, String> getRequestCookies() {
		return requestCookies;
	}
	
	/**
	 * @param name The name of the {@link Cookie}, transmitted by the client request,
	 * for which a value should be returned.
	 * @return The string value for the named {@link Cookie}, or null if it doesn't exist.
	 */
	public String getRequestCookie(String name) {
		return requestCookies.get(name);
	}

}
