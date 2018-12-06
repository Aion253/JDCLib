package net.aionstudios.jdc.content;

import java.util.HashMap;
import java.util.Map;

public class RequestVariables {
	
	private Map<String, String> post;
	private Map<String, String> get;
	private Map<String, String> cookies;
	private CookieManager cookieManager;
	private String page;
	
	public RequestVariables(Map<String, String> post, Map<String, String> get, Map<String, String> cookies, String page) {
		this.post = post!=null ? post : new HashMap<String, String>();
		this.get = get!=null ? get : new HashMap<String, String>();
		this.cookies = cookies!=null ? cookies : new HashMap<String, String>();
		this.cookieManager = new CookieManager(cookies);
		this.page = page;
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
	
	public String getPage() {
		return page;
	}

}
