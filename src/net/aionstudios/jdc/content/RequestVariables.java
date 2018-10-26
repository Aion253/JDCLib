package net.aionstudios.jdc.content;

import java.util.Map;

public class RequestVariables {
	
	private Map<String, String> post;
	private Map<String, String> get;
	private Map<String, String> cookies;
	private CookieManager cookieManager;
	
	public RequestVariables(Map<String, String> post, Map<String, String> get, Map<String, String> cookies) {
		this.post = post;
		this.get = get;
		this.cookies = cookies;
		this.cookieManager = new CookieManager(cookies);
	}

	public Map<String, String> getPost() {
		return post;
	}

	public Map<String, String> getGet() {
		return get;
	}

	public Map<String, String> getRequestCookies() {
		return cookies;
	}

	public CookieManager getCookieManager() {
		return cookieManager;
	}

}
