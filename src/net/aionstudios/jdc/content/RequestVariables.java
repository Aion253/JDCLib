package net.aionstudios.jdc.content;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An API for receiving client request data.
 * @author Winter Roberts
 */
public class RequestVariables {
	
	private Map<String, String> post;
	private Map<String, String> get;
	private Map<String, String> cookies;
	private CookieManager cookieManager;
	private String page;
	private List<MultipartFile> multipartFiles;
	
	private String redirect = null;
	private File streamFile = null;
	private String type = "text/html; charset=UTF-8";
	private ResponseCode responseCode = ResponseCode.OK;
	
	/**
	 * Creates a new RequestVariables.
	 * @param post The client's post contents, from the {@link HttpExchange} that received it.
	 * @param get The client's get contents, from the {@link HttpExchange} that received it.
	 * @param cookies  The client's {@link Cookie}s, from the {@link HttpExchange} that received it.
	 * @param page The page this request is being made for.
	 * @param multipartFiles The collection of all files that have been transmitted in the request.
	 */
	public RequestVariables(Map<String, String> post, Map<String, String> get, Map<String, String> cookies, String page, List<MultipartFile> multipartFiles) {
		this.post = post!=null ? post : new HashMap<String, String>();
		this.get = get!=null ? get : new HashMap<String, String>();
		this.cookies = cookies!=null ? cookies : new HashMap<String, String>();
		this.cookieManager = new CookieManager(cookies);
		this.page = page;
		this.multipartFiles = multipartFiles;
	}

	/**
	 * @return A map of post variables.
	 */
	public Map<String, String> getPost() {
		return post;
	}

	/**
	 * @return A map of get variables.
	 */
	public Map<String, String> getGet() {
		return get;
	}

	/**
	 * @return A map of client request cookies.
	 */
	public Map<String, String> getRequestCookies() {
		return cookies;
	}

	/**
	 * @return The {@link CookieManager} for this request.
	 */
	public CookieManager getCookieManager() {
		return cookieManager;
	}
	
	/**
	 * @return The full context string for this request.
	 */
	public String getPage() {
		return page;
	}
	
	/**
	 * Assigns the server response to tell the client to redirect their request.
	 * @param url The url to be redirected to.
	 */
	public void setRedirect(String url) {
		if(url!=null && url.length()>0) {
			redirect = url;
		}
	}
	
	/**
	 * @return The string url which the server response will advise the client to redirect to,
	 * or null if it has not been assigned.
	 */
	public String getRedirect() {
		return redirect;
	}
	
	/**
	 * Modifies the content type of the response.
	 * @param ctype The content type (mime) to be assigned for the server response.
	 */
	public void setContentType(String ctype) {
		if(ctype!=null && ctype.length()>0) {
			type = ctype;
		}
	}
	
	/**
	 * @return The current content type (mime) to be used in the server's response.
	 */
	public String getContentType() {
		return type;
	}
	
	/**
	 * Changes the server response to that of a file passed by this method.
	 * @param f The file which should be streamed as a response.
	 */
	public void setStreamFile(File f) {
		streamFile = f;
	}
	
	/**
	 * @return The {@link File}, which should be sent as the server's response.
	 */
	public File getStreamFile() {
		return streamFile;
	}

	/**
	 * @return The current {@link ResponseCode} for the server's response.
	 */
	public ResponseCode getResponseCode() {
		return responseCode;
	}

	/**
	 * Modifies the {@link ResponseCode} for the server's response.
	 * @param responseCode The {@link ResponseCode} which should now be used.
	 */
	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}
	
	/**
	 * @return The collection of all files that have been transmitted in the request.
	 */
	public List<MultipartFile> getMultipartFiles() {
		return multipartFiles;
	}

}
