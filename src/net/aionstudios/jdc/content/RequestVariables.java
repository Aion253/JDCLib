package net.aionstudios.jdc.content;

import java.util.HashMap;
import java.util.Map;

public class RequestVariables {
	
	private Map<String, String> post;
	private Map<String, String> get;
	private Map<String, String> cookies;
	private CookieManager cookieManager;
	private String page;
	private String redirect = null;
	private String type = "text/html; charset=UTF-8";
	
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
	
	public void setRedirect(String url) {
		if(url!=null && url.length()>0) {
			redirect = url;
		}
	}
	
	public String getRedirect() {
		return redirect;
	}
	
	public void setContentType(String ctype) {
		if(ctype!=null && ctype.length()>0) {
			type = ctype;
		}
	}
	
	public String getContentType() {
		return type;
	}

}
