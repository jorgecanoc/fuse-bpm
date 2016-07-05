package mx.redhat.fuse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

public class BpmService {
	private static final Logger log = Logger.getLogger(BpmService.class);
	private static final String BASE_URL = "http://jbpm.kaf.com.mx:8080/business-central/rest/";
	private static final String USERNAME = "bpms";
	private static final String PASSWORD = "KAF_bpm2016*";
	private static final String METHOD = "GET";

	/**
	 * Call service (GET)
	 * 
	 * @param urlpath
	 * @param method
	 * @return
	 * @throws Exception
	 */
	public static String getDataFromService(String urlpath) throws Exception {
		// no params
		return getDataFromService(BASE_URL + urlpath, METHOD, null, false, USERNAME, PASSWORD);

	}

	/**
	 * Call service (GET)
	 * 
	 * @param urlpath
	 * @param method
	 * @return
	 * @throws Exception
	 */
	public static String getDataFromService(String urlpath, String method) throws Exception {
		// no params
		return getDataFromService(BASE_URL + urlpath, method, null, false, USERNAME, PASSWORD);

	}

	/**
	 * Call service (GET)
	 * 
	 * @param urlpath
	 * @param method
	 * @return
	 * @throws Exception
	 */
	public static String getDataFromService(String urlpath, Map<String, Object> params) throws Exception {
		// no params
		return getDataFromService(BASE_URL + urlpath, "GET", params, false, USERNAME, PASSWORD);

	}

	/**
	 * Call service (GET)
	 * 
	 * @param urlpath
	 * @param method
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String getDataFromService(String urlpath, String method, String username, String password)
			throws Exception {
		// no params
		return getDataFromService(urlpath, method, null, false, username, password);

	}

	public static String getDataFromService(String urlpath, String method, Map<String, Object> params)
			throws Exception {
		String username = (String) params.get("username");
		String password = (String) params.get("password");
		if (username == null || username.isEmpty() || username.equals("")) {
			username = USERNAME;
			password = PASSWORD;
		}
		return getDataFromService(urlpath, method, params, false, username, password);

	}

	/**
	 * 
	 * @param url
	 * @param httpclient
	 * @param method
	 * @param username
	 * @param password
	 */
	private static void doAuthorization2(String url, HttpClient httpclient, HttpMethod method, String username,
			String password) {
		httpclient.getState().setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM),
				new UsernamePasswordCredentials(username, password)

		);
		method.setDoAuthentication(true);
		httpclient.getParams().setAuthenticationPreemptive(true);
	}

	/**
	 * 
	 * @param urlpath
	 * @param method
	 * @param params
	 * @param multipart
	 * @param username
	 * @param password
	 * @return
	 */
	public static String getDataFromService(String urlpath, String method, Map<String, Object> params,
			boolean multipart, String username, String password) {
		boolean handleException = false;
		// extract required parameters
		String urlStr = urlpath;

		String result = "";

		if (urlStr == null) {
			throw new IllegalArgumentException("Url is a required parameter");
		}
		if (method == null || method.trim().length() == 0) {
			method = "GET";
		}

		HttpClient httpclient = new HttpClient();

		httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
		httpclient.getHttpConnectionManager().getParams().setSoTimeout(3000);
		httpclient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);

		HttpMethod theMethod = null;

		if (method.equalsIgnoreCase("GET")) {
			theMethod = new GetMethod(urlpath);
		} else {
			theMethod = new PostMethod(urlpath);
		}

		if (params != null && params.size() > 0) {
			List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();

			Iterator<String> paramKeys = params.keySet().iterator();

			while (paramKeys.hasNext()) {
				String key = paramKeys.next();
				Object value = params.get(key);
				if (value != null) {
					NameValuePair pair = new NameValuePair(key, value.toString());
					valuePairs.add(pair);
				}

			}

			NameValuePair[] pairsArray = new NameValuePair[valuePairs.size()];
			pairsArray = valuePairs.toArray(pairsArray);
			theMethod.setQueryString(pairsArray);
		}

		theMethod.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		doAuthorization2(urlpath, httpclient, theMethod, username, password);

		try {

			Header[] headers = theMethod.getRequestHeaders();
			for (Header header : headers) {
				log.info(header.getName() + ":[" + header.getValue() + "]");
			}

			int responseCode = httpclient.executeMethod(theMethod);
			log.info("Call Restful API again authMethod responseCode:[" + responseCode + "] ");

			Map<String, Object> results = new HashMap<String, Object>();
			if (responseCode >= 200 && responseCode < 300) {
				result = theMethod.getResponseBodyAsString();

				log.info("Successfully completed :[" + result + "]");
			} else {
				if (handleException) {
					log.info("handleException responseCode:[" + responseCode + "] theMethod.getResponseBodyAsString():["
							+ theMethod.getResponseBodyAsString() + "] urlStr:[" + urlStr + "]");

				} else {

					log.info("Unsuccessful responseCode:[" + responseCode + "] theMethod.getResponseBodyAsString():["
							+ theMethod.getResponseBodyAsString() + "] urlStr:[" + urlStr + "]");
					results.put("StatusMsg",
							"endpoint " + urlStr + " could not be reached: " + theMethod.getResponseBodyAsString());
				}
			}
			results.put("Status", responseCode);

		} catch (Exception e) {
			log.error("Error invoking bpms service", e);
		} finally {
			theMethod.releaseConnection();
		}
		return result;
	}

}
