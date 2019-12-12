package net.aionstudios.jdc.content;

/**
 * Enumerates possible response statuses.
 * Not all responses are included as some should only be passed by the server itself and are not relevant.
 * @author Winter Roberts
 */
public enum ResponseCode {
	
	OK(200),
	CREATED(201),
	ACCEPTED(202),
	NON_AUTHORITATIVE(203),
	NO_RESPONSE(204),
	FOUND_REDIRECT(302),
	NO_CONTENT(204),
	RESET_CONTENT(205),
	PARTIAL_CONTENT(206),
	MULTIPLE_CHOICE(300),
	MOVED_PERMANENTLY(301),
	FOUND(302),
	SEE_OTHER(303),
	NOT_MODIFIED(304),
	TEMPORARY_REDIRECT(307),
	PERMANENT_REDIRECT(308),
	BAD_REQUEST(400),
	UNUATHORIZED(401),
	FORBIDDEN(403),
	NOT_FOUND(404),
	METHOD_NOT_ALLOWED(405),
	NOT_ACCEPTABLE(406),
	PROXY_AUTHETICATION_REQUIRED(407),
	REQUEST_TIMEOUT(408),
	CONFLICT(409),
	GONE(410),
	LENGTH_REQUIRED(411),
	PRECONDITION_FAILED(412),
	PAYLOAD_TOO_LARGE(413),
	URI_TOO_LONG(414),
	UNSUPPORTED_MEDIA_TYPE(415),
	REQUEST_RANGE_NOT_SATISFIABLE(416),
	EXPECTATION_FAILED(417),
	UNPROCESSABLE_ENTITY(422),
	TOO_EARLY(425),
	UPGRADE_REQUIRED(426),
	PRECONDITION_REQUIRED(428),
	TOO_MANY_REQUESTS(429),
	REQUEST_HEADER_FIELDS_TOO_LARGE(431),
	UNAVAILABLE_FOR_LEGAL_REASONS(451),
	ABUSE_DETECTED(480), //Has to be called by application; not in spec as added by JDC.
	INTERNAL_SERVER_ERROR(500),
	NOT_IMPLEMENTED(501),
	BAD_GATEWAY(502),
	SERVICE_UNAVAILABLE(503),
	GATEWAY_TIMEOUT(504),
	HTTP_VERSION_BOT_SUPPORTED(505),
	VARIANT_ALSO_NEGOTIATES(506),
	NETWORK_AUTHENTICATION_REQUIRED(511);

	private final int value;

	/**
	 * Creates a {@link ResponseStatus} by value.
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
		} else if(value==302) {
			return "Found Redirect";
		} else if(value==404) {
			return "Not Found";
		} else if(value==500) {
			return "Internal Server Error";
		} else if(value==204) {
			return "No Content";
		} else if(value==422) {
			return "Unprocessable Entity";
		} else if(value==480) {
			return "Abuse Detected";
		} else if(value==201) {
			return "Created";
		} else if(value==202) {
			return "Accepted";
		} else if(value==203) {
			return "Non-Authoritative Information";
		} else if(value==204) {
			return "No Content";
		} else if(value==205) {
			return "Reset Content";
		} else if(value==206) {
			return "Partial Content";
		} else if(value==300) {
			return "Multiple Choice";
		} else if(value==301) {
			return "Moved Permanently";
		} else if(value==302) {
			return "Found";
		} else if(value==303) {
			return "See Other";
		} else if(value==304) {
			return "Not Modified";
		} else if(value==307) {
			return "Temporary Redirect";
		} else if(value==308) {
			return "Permanent Redirect";
		} else if(value==400) {
			return "Bad Request";
		} else if(value==401) {
			return "Unauthorized";
		} else if(value==403) {
			return "Forbidden";
		} else if(value==405) {
			return "Method Not Allowed";
		} else if(value==406) {
			return "Not Acceptable";
		} else if(value==407) {
			return "Proxy Authentication Required";
		} else if(value==408) {
			return "Request Timeout";
		} else if(value==409) {
			return "Conflict";
		} else if(value==410) {
			return "Gone";
		} else if(value==411) {
			return "Length Required";
		} else if(value==412) {
			return "Precondition Failed";
		} else if(value==413) {
			return "Payload Too Large";
		} else if(value==414) {
			return "URI Too Long";
		} else if(value==415) {
			return "Unsupported Media Type";
		} else if(value==416) {
			return "Request Range Not Satisfiable";
		} else if(value==417) {
			return "Expectation Failed";
		} else if(value==425) {
			return "Too Early";
		} else if(value==426) {
			return "Upgrade Required";
		} else if(value==428) {
			return "Precondition Required";
		} else if(value==429) {
			return "Too Many Requests";
		} else if(value==431) {
			return "Request Header Fields Too Large";
		} else if(value==431) {
			return "Unavailable For Legal Reasons";
		} else if(value==501) {
			return "Not Implemented";
		} else if(value==502) {
			return "Bad Gateway";
		} else if(value==503) {
			return "Service Unavailable";
		} else if(value==504) {
			return "Gateway Timeout";
		} else if(value==505) {
			return "HTTP Version Not Supported";
		} else if(value==506) {
			return "Variant Also Negotiates";
		} else if(value==511) {
			return "Network Authentication Required";
		}
		return null;
	}
	
	/**
	 * @return A string describing what this {@link ResponseCode} means.
	 */
	public String getCodeDesc(String pageName) {
		if(value==200) {
			return "The request was completed without serious error and returned valid data.";
		} else if(value==302) {
			return "The requested resource, '"+pageName+"', was found elsewhere.";
		} else if(value==404) {
			return "The requested resource, '"+pageName+"', was not found on this server.";
		} else if(value==500) {
			return "The server encountered an unhandled internal error and was unable to complete your request.";
		} else if(value==204) {
			return "The request was completed without serious error but returned no data.";
		} else if(value==422) {
			return "The request was accepted but was unprocessable due to semantic errors.";
		} else if(value==480) {
			return "The request was rejected by the server's abuse detection system.";
		} else if(value==201) {
			return "The request created a resource.";
		} else if(value==202) {
			return "The request hasn't been acted on yet.";
		} else if(value==203) {
			return "The response may not be up-to-date.";
		} else if(value==204) {
			return "The response contains no data apart from headers.";
		} else if(value==205) {
			return "The response expects the client to reset the document.";
		} else if(value==206) {
			return "The response is incomplete because the client asked for a range.";
		} else if(value==300) {
			return "The response requires a client decision.";
		} else if(value==301) {
			return "The resource has been moved permanently.";
		} else if(value==302) {
			return "The resource has been moved, but this URI should still be used.";
		} else if(value==303) {
			return "The response is an explicit redirect.";
		} else if(value==304) {
			return "The cached resource is up-to-date.";
		} else if(value==307) {
			return "The resource has been moved, but this URI should still be used and the method preserved.";
		} else if(value==308) {
			return "The resource has been moved permanently, please preserved method.";
		} else if(value==400) {
			return "The server couldn't understand the request.";
		} else if(value==401) {
			return "Access to the resource requires authentication.";
		} else if(value==403) {
			return "The server will not allow the client to access this resource.";
		} else if(value==405) {
			return "The request is disabled by the server or doesn't exist.";
		} else if(value==406) {
			return "The server couldn't meet client content expectations.";
		} else if(value==407) {
			return "Access to the resource requires authentication through a proxy.";
		} else if(value==408) {
			return "The server couldn't complete and transmit the resource in a reasonable time.";
		} else if(value==409) {
			return "The request conflicts with the server's current state.";
		} else if(value==410) {
			return "The resource has been removed.";
		} else if(value==411) {
			return "The resource requires a Content-Length header form the client.";
		} else if(value==412) {
			return "The server does not meet client header preconditions.";
		} else if(value==413) {
			return "The client attempted to send more content than the server allows.";
		} else if(value==414) {
			return "The client requested a URI of a length which the server will not interpret.";
		} else if(value==415) {
			return "The client request contained a media type the server rejected.";
		} else if(value==416) {
			return "The resource cannot be provided at the client-specified range.";
		} else if(value==417) {
			return "The server cannot meet the client-specified expectations.";
		} else if(value==425) {
			return "The server wants to avoid processing a request that may be replayed.";
		} else if(value==426) {
			return "The server will not accept requests from the current protocol.";
		} else if(value==428) {
			return "Modifying the resource would overwrite local changes.";
		} else if(value==429) {
			return "The client is being rate-limited.";
		} else if(value==431) {
			return "The client header is of a length which the server will not interpret.";
		} else if(value==431) {
			return "The resource could not be legally transmitted to the client.";
		} else if(value==501) {
			return "The request method is not implemented by the server.";
		} else if(value==502) {
			return "A downstream resource from the server, as a gateway, errored.";
		} else if(value==503) {
			return "The server is unable to process your request right now.";
		} else if(value==504) {
			return "A downstream resource from the server, as a gateway, timed out.";
		} else if(value==505) {
			return "The client request specifies a version of HTTP that the server does not support.";
		} else if(value==506) {
			return "The end resource requires content negotiation; inherently misconfigured.";
		} else if(value==511) {
			return "Authentication is required to access resources on this network.";
		}
		return null;
	}

}
