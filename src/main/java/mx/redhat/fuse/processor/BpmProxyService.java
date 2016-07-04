package mx.redhat.fuse.processor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import mx.redhat.fuse.service.BpmService;

public class BpmProxyService {
	private static final Logger log = Logger.getLogger(BpmService.class);

	public String getRuntime(String deploymentId) throws Exception {
		log.info("starting getRuntime method");
		String url = "runtime/" + deploymentId;
		return BpmService.getDataFromService(url);
	}

	/**
	 * /runtime/{deploymentId}/execute
	 * 
	 * @param ui
	 * @param deploymentId
	 * @return
	 * @throws Exception
	 */
	public String runtimeExecute(@Context UriInfo ui, String deploymentId) throws Exception {
		log.info("starting getRuntimeExecute method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/runtime/" + deploymentId + "/execute";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * 
	 * [POST] /runtime/{deploymentId}/process/{processDefId}/start
	 * 
	 * @param ui
	 * @param deploymentId
	 * @return
	 * @throws Exception
	 */
	public String runtimeStart(@Context UriInfo ui, String deploymentId, String processDefId) throws Exception {
		log.info("starting runtimeStart method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/runtime/" + deploymentId + "/process/" + processDefId + "/start";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * [GET] /runtime/{deploymentId}/process/instance/{procInstId}
	 * 
	 * Does a (read only) retrieval of the process instance. This operation will
	 * fail (code 400) if the process instance has been completed. Returns a
	 * JaxbProcessInstanceResponse instance.
	 * 
	 * Notes: The procInstId component of the URL must conform to the following
	 * regex: [0-9]+
	 * 
	 * @param deploymentId
	 * @param instanceId
	 * @return
	 * @throws Exception
	 */
	public String runtimeInstance(String deploymentId, String procInstId) throws Exception {
		log.info("starting runtimeInstance method");
		String url = "/runtime/" + deploymentId + "/process/instance/" + procInstId;
		return BpmService.getDataFromService(url);
	}

	/**
	 * [POST] /runtime/{deploymentId}/process/instance/{procDefID}/start
	 * 
	 * start a process instance based on the Process definition (accepts query
	 * map parameters)
	 * 
	 * @param ui
	 * @param deploymentId
	 * @param instanceId
	 * @return
	 * @throws Exception
	 */
	public String runtimeInstanceStart(@Context UriInfo ui, String deploymentId, String procDefID) throws Exception {
		log.info("starting runtimeInstanceStart method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/runtime/" + deploymentId + "/process/instance/" + procDefID + "/start";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /runtime/{id: [a-zA-Z0-9-:\\.]+}")/process/instance/{id: [0-9]+}/signal
	 * signal event [POST] (accepts query map params)
	 * 
	 * @param ui
	 * @param deploymentId
	 * @param procDefID
	 * @return
	 * @throws Exception
	 */
	public String runtimeInstanceSignal(@Context UriInfo ui, String deploymentId, String procDefID) throws Exception {
		log.info("starting runtimeInstanceSignal method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/runtime/" + deploymentId + "/process/instance/" + procDefID + "/signal";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /runtime/{id: [a-zA-Z0-9-:\\.]+}")/process/instance/{id: [0-9]+}/abort
	 * signal event [POST] (accepts query map params)
	 * 
	 * @param ui
	 * @param deploymentId
	 * @param procDefID
	 * @return
	 * @throws Exception
	 */
	public String runtimeInstanceAbort(@Context UriInfo ui, String deploymentId, String procDefID) throws Exception {
		log.info("starting runtimeInstanceAbort method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/runtime/" + deploymentId + "/process/instance/" + procDefID + "/abort";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /runtime/{id: [a-zA-Z0-9-:\\.]+}")/signal/{id: [a-zA-Z0-9-]+} signal
	 * event [POST] (accepts query map params)
	 * 
	 * @param ui
	 * @param deploymentId
	 * @param procDefID
	 * @return
	 * @throws Exception
	 */
	public String runtimeSignal(@Context UriInfo ui, String deploymentId, String signalId) throws Exception {
		log.info("starting runtimeInstanceSignal method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/runtime/" + deploymentId + "/signal/" + signalId;
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /runtime/{id: [a-zA-Z0-9-:\\.]+}")/workitem/{id: [0-9]+}/complete
	 * complete work item [POST] (accepts query map params) - accepts
	 * "query map parameters"
	 * 
	 * @param ui
	 * @param deploymentId
	 * @param signalId
	 * @return
	 * @throws Exception
	 */
	public String runtimeWorkItemComplete(@Context UriInfo ui, String deploymentId, String workitemId)
			throws Exception {
		log.info("starting runtimeWorkItemComplete method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/runtime/" + deploymentId + "/workitem/" + workitemId + "/complete";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /runtime/{id: [a-zA-Z0-9-:\\.]+}")/workitem/{id: [0-9]+}/abort abort work
	 * item [POST]
	 * 
	 * @param ui
	 * @param deploymentId
	 * @param workItemID
	 * @return
	 * @throws Exception
	 */
	public String runtimeWorkitemAbort(@Context UriInfo ui, String deploymentId, String workItemID) throws Exception {
		log.info("starting runtimeWorkItemAbort method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/runtime/" + deploymentId + "/workitem/" + workItemID + "/abort";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	public String getRepos(@Context UriInfo ui) throws Exception {
		log.info("starting getRepos method");
		return BpmService.getDataFromService("repositories");
	}

	private Map<String, Object> prepareParameters(MultivaluedMap<String, String> queryParameters) {

		Map<String, Object> parameters = new HashMap<String, Object>();

		Iterator<String> it = queryParameters.keySet().iterator();

		while (it.hasNext()) {
			String theKey = (String) it.next();
			parameters.put(theKey, queryParameters.getFirst(theKey));
		}

		return parameters;

	}

}
