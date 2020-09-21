package net.aionstudios.jdc.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import net.aionstudios.jdc.content.OutgoingRequest;

/**
 * A content processor service for making outgoing requests.
 * @author Winter Roberts
 */
public class OutgoingRequestService {
	
	/**
	 * Makes a post request to the target URL with the given parameters.
	 * @param targetURL The URL to which a request should be made.
	 * @param urlParameters The URL parameters that should be included in this request.
	 * @param or An {@link OutgoingRequest}.
	 * @return The response from this request.
	 */
	public static String executePost(String targetURL, String urlParameters, OutgoingRequest or) {
		HttpURLConnection httpConn = null;
		HttpsURLConnection httpsConn = null;
		URLConnection conn = null;
		
		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    conn = url.openConnection();
		    if(conn instanceof HttpsURLConnection) {
		    	httpsConn = (HttpsURLConnection) url.openConnection();
		    	httpsConn.setRequestMethod("POST");
			    httpsConn.setRequestProperty("Content-Type", 
			        "application/x-www-form-urlencoded");

			    httpsConn.setRequestProperty("Content-Length", 
			        Integer.toString(urlParameters.getBytes().length));
			    httpsConn.setRequestProperty("Content-Language", "en-US");  

			    httpsConn.setUseCaches(false);
			    httpsConn.setDoOutput(true);
		    } else {
		    	httpConn = (HttpURLConnection) url.openConnection();
		    	httpConn.setRequestMethod("POST");
			    httpConn.setRequestProperty("Content-Type", 
			        "application/x-www-form-urlencoded");

			    httpConn.setRequestProperty("Content-Length", 
			        Integer.toString(urlParameters.getBytes().length));
			    httpConn.setRequestProperty("Content-Language", "en-US");  

			    httpConn.setUseCaches(false);
			    httpConn.setDoOutput(true);
		    }

		    conn.setDoOutput(true);
		    //Send request
		    DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		    wr.writeBytes(urlParameters);
		    wr.close();
		    
		    Map<String, List<String>> h = conn.getHeaderFields();
		    
		    or.setHeaders(h);
		    
		    //Get Response  
		    InputStream is = conn.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
		    String line;
		    while ((line = rd.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
		    rd.close();
		    or.setContent(response.toString());
		    return response.toString();
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if (httpConn != null) {
		      httpConn.disconnect();
		    }
		    if (httpsConn != null) {
			  httpsConn.disconnect();
			}
		  }
		}
	
	/**
	 * Makes a get request to the target URL with the given parameters.
	 * @param targetURL The URL to which a request should be made.
	 * @return The response from this request.
	 */
	public static String executeGet(String targetURL) {
		HttpURLConnection httpConn = null;
		HttpsURLConnection httpsConn = null;
		URLConnection conn = null;
		
		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    conn = url.openConnection();
		    if(conn instanceof HttpsURLConnection) {
		    	httpsConn = (HttpsURLConnection) url.openConnection();
		    	httpsConn.setRequestMethod("GET");
			    httpsConn.setRequestProperty("Content-Type", 
			        "application/x-www-form-urlencoded");

			    httpsConn.setRequestProperty("Content-Length", "0");
			    httpsConn.setRequestProperty("Content-Language", "en-US");  

			    httpsConn.setUseCaches(false);
			    httpsConn.setDoOutput(true);
		    } else {
		    	httpConn = (HttpURLConnection) url.openConnection();
		    	httpConn.setRequestMethod("GET");
			    httpConn.setRequestProperty("Content-Type", 
			        "application/x-www-form-urlencoded");

			    httpConn.setRequestProperty("Content-Length", "0");
			    httpConn.setRequestProperty("Content-Language", "en-US");  

			    httpConn.setUseCaches(false);
			    httpConn.setDoOutput(true);
		    }

		    conn.setDoOutput(true);
		    //Send request
		    DataOutputStream wr = new DataOutputStream (
		        conn.getOutputStream());
		    wr.close();

		    //Get Response  
		    InputStream is = conn.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
		    String line;
		    while ((line = rd.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
		    rd.close();
		    return response.toString();
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
			  if (httpConn != null) {
			      httpConn.disconnect();
			  }
			  if (httpsConn != null) {
				  httpsConn.disconnect();
			}
		  }
		}
	
	/**
	 * Converts a map of string, string pairs to a string to be added to the request header.
	 * @param postQuery The map which should be converted.
	 * @return The string conversion.
	 */
	public static String postMapToString(Map<String, String> postQuery) {
		String postString = "";
		for(int i = 0; i < postQuery.size(); i++) {
			String postVal = (String) postQuery.keySet().toArray()[i];
			postString = postString+postVal+"="+(postQuery.get(postVal))+(i < postQuery.size()-1 ? "&" : "");
		}
		return postString;
	}

}
