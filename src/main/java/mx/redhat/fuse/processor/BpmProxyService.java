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
	 * /query/runtime/task}
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String queryRuntimeTask(@Context UriInfo ui) throws Exception {
		log.info("starting queryRuntimeTask method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/query/runtime/task";
		return BpmService.getDataFromService(url, prepareParameters(queryParams));
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

	/**
	 * /task/query}
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskQuery(@Context UriInfo ui) throws Exception {
		log.info("starting taskQuery method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/query";
		return BpmService.getDataFromService(url, "GET", prepareParameters(queryParams));
	}

	/**
	 * /task/execute/{id: \\d+}
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecute(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecute method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute/" + taskId;
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/activate
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteActivate(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteActivate method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/activate";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/{id: \\d+}/claim
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskClaim(@Context UriInfo ui, String taskId) throws Exception {
		log.info("starting taskClaim method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/" + taskId + "/claim";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/claimnextavailable
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteClaimNextAvailable(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteClaimNextAvailable method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/claimnextavailable";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/{id: \\d+}/complete
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskComplete(@Context UriInfo ui, String taskId) throws Exception {
		log.info("starting taskExecuteComplete method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/" + taskId + "/complete";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/delegate
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteDelegate(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteDelegate method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/delegate";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/exit
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteExit(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteExit method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/exit";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/fail
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteFail(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteFail method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/fail";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/forward
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteForward(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteForward method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/forward";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/release
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteRelease(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteRelease method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/release";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/resume
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteResume(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteRelease method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/resume";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/skip
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteSkip(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteSkip method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/skip";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/{id: \\d+}/start
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskStart(@Context UriInfo ui, String taskId) throws Exception {
		log.info("starting taskStart method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/" + taskId + "/start";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/stop
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteStop(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteStop method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/stop";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/suspend
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteSuspend(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteSuspend method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/suspend";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * //Crear instancia $response =
	 * $rest->service('POST','runtime/'.$deploymentId.'/withvars/process/'.
	 * $procDefinitionID.'/start');
	 * 
	 * @param ui
	 * @param deploymentId
	 * @param procDefID
	 * @return
	 * @throws Exception
	 */
	public String runtimeWithvarsStart(@Context UriInfo ui, String deploymentId, String procDefID) throws Exception {
		log.info("starting runtimeWithvarsStart method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/runtime/" + deploymentId + "/withvars/process/" + procDefID + "/start";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	/**
	 * /task/execute{id: \\d+}/nominate
	 * 
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String taskExecuteNominate(@Context UriInfo ui, Long taskId) throws Exception {
		log.info("starting taskExecuteNominate method");
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		String url = "/task/execute" + taskId + "/nominate";
		return BpmService.getDataFromService(url, "POST", prepareParameters(queryParams));
	}

	public String getRepos() throws Exception {
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
