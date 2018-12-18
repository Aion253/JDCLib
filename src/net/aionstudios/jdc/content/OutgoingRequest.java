package net.aionstudios.jdc.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutgoingRequest {
	
	private String content = "";
	private Map<String, List<String>> headers;
	
	public OutgoingRequest(String pageContent, Map<String, List<String>> reqHeaders) {
		content = pageContent != null ? pageContent : "";
		headers = reqHeaders != null ? reqHeaders : new HashMap<String, List<String>>();
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String c) {
		content = c;
	}
	
	public Map<String, List<String>> getHeaders() {
		return headers;
	}
	
	public void setHeaders(Map<String, List<String>> hs) {
		headers = hs;
	}
	
	public List<String> getHeader(String header) {
		return headers.containsKey(header) ? headers.get(header) : null;
	}
	
	public String getHeader(String header, int arrayLocation) {
		if(headers.containsKey(header)) {
			List<String> h = headers.get(header);
			if(h.size() > 0 && arrayLocation < h.size() && arrayLocation >= 0) {
				return h.get(arrayLocation);
			}
		}
		return null;
	}
	
	public String getLastHeader(String header) {
		if(headers.containsKey(header)) {
			List<String> h = headers.get(header);
			if(h.size() > 0) {
				return h.get(h.size());
			}
		}
		return null;
	}

}
