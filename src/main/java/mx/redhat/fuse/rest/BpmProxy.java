package mx.redhat.fuse.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/business-central/rest")
public class BpmProxy {

	@GET
	@Path("/repositories")
	@Produces({ MediaType.APPLICATION_JSON })
	public String repositories() throws Exception {
		return null;
	}

	@GET
	@Path("/query/runtime/task")
	@Produces({ MediaType.APPLICATION_JSON })
	public String queryRuntimeTask(@Context UriInfo ui) throws Exception {
		return null;
	}

	@GET
	@Path("/runtime/${deploymentId}/withvars/process/${procDefID}/start")
	@Produces({ MediaType.APPLICATION_JSON })
	public String runtimeWithvarsStart(@Context UriInfo ui, String deploymentId, String procDefID) throws Exception {
		return null;
	}

	// @GET
	// @Path("/runtime/{deploymentId}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String getRuntime(String deploymentId) throws Exception {
	// return null;
	// }
	//
	// @POST
	// @Path("/runtime/{deploymentId}/execute")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String runtimeExecute(@Context UriInfo ui, String deploymentId)
	// throws Exception {
	// return null;
	// }
	//
	// /**
	// * [POST] /runtime/{deploymentId}/process/{processDefId}/start
	// *
	// * Starts a process. Returns a JaxbProcessInstanceResponse instance, that
	// * contains basic information about the process instance.
	// *
	// * Notes: The processDefId component of the URL must conform to the
	// * following regex: [_a-zA-Z0-9-:\.]+
	// *
	// * Parameters: This operation takes map query parameters (see below),
	// which
	// * will be used as parameters for the process instance. You can only pass
	// * basic types (as map query parameters) using this URL. If you want to
	// pass
	// * complex and/or custom classes, you should use the Java Remote API
	// * instead.
	// *
	// * @param ui
	// * @param deploymentId
	// * @param processId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/runtime/{deploymentId}/process/{processDefId}/start")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String runtimeStart(@Context UriInfo ui, String deploymentId,
	// String processDefId) throws Exception {
	// return null;
	// }
	//
	// /**
	// * [GET] /runtime/{deploymentId}/process/instance/{procInstId}
	// *
	// * Does a (read only) retrieval of the process instance. This operation
	// will
	// * fail (code 400) if the process instance has been completed. Returns a
	// * JaxbProcessInstanceResponse instance.
	// *
	// * Notes: The procInstId component of the URL must conform to the
	// following
	// * regex: [0-9]+
	// *
	// * @param deploymentId
	// * @param instanceId
	// * @return
	// * @throws Exception
	// */
	// @GET
	// @Path("/runtime/{deploymentId}/process/instance/{procInstId}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String runtimeInstance(String deploymentId, String procInstId)
	// throws Exception {
	// return null;
	// }
	//
	// /**
	// * [POST] /runtime/{deploymentId}/process/{procDefID}/start
	// *
	// * start a process instance based on the Process definition (accepts query
	// * map parameters)
	// *
	// * @param ui
	// * @param deploymentId
	// * @param instanceId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/runtime/{deploymentId}/process/instance/{procDefID}/start")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String runtimeInstanceStart(@Context UriInfo ui, String
	// deploymentId, String procDefID) throws Exception {
	// return null;
	// }
	//
	// /**
	// * [POST] /runtime/{deploymentId}/process/instance/{procInstanceID}/signal
	// *
	// * send a signal event to process instance (accepts query map parameters)
	// *
	// * @param ui
	// * @param deploymentId
	// * @param instanceId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/runtime/{deploymentId}/process/instance/{procInstanceID}/signal")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String runtimeInstanceSignal(@Context UriInfo ui, String
	// deploymentId, String procInstanceID)
	// throws Exception {
	// return null;
	// }
	//
	// /**
	// * [POST] /runtime/{deploymentId}/process/instance/{procInstanceID}/abort
	// *
	// * send a signal event to process instance (accepts query map parameters)
	// *
	// * @param ui
	// * @param deploymentId
	// * @param instanceId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/runtime/{deploymentId}/process/instance/{procInstanceID}/abort")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String runtimeInstanceAbort(@Context UriInfo ui, String
	// deploymentId, String procInstanceID)
	// throws Exception {
	// return null;
	// }
	//
	// /**
	// * [POST] /runtime/{deploymentId}/signal/{signalCode}
	// *
	// * send a signal event to deployment
	// *
	// * @param ui
	// * @param deploymentId
	// * @param signalCode
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/runtime/{deploymentId}/signal/{signalCode}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String runtimeSignal(@Context UriInfo ui, String deploymentId,
	// String signalCode) throws Exception {
	// return null;
	// }
	//
	// /**
	// * [POST] /runtime/{deploymentId}/workitem/{workItemID}/complete
	// *
	// * complete a work item (accepts query map parameters)
	// *
	// * @param ui
	// * @param deploymentId
	// * @param signalCode
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/runtime/{deploymentId}/workitem/{workItemID}/complete")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String runtimeWorkitemComplete(@Context UriInfo ui, String
	// deploymentId, String workItemID)
	// throws Exception {
	// return null;
	// }
	//
	// /**
	// * [POST] /runtime/{deploymentId}/workitem/{workItemID}/abort
	// *
	// * complete a work item (accepts query map parameters)
	// *
	// * @param ui
	// * @param deploymentId
	// * @param signalCode
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/runtime/{deploymentId}/workitem/{workItemID}/abort")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String runtimeWorkitemAbort(@Context UriInfo ui, String
	// deploymentId, String workItemID) throws Exception {
	// return null;
	// }
	//
	/**
	 * /task/query query tasks TaskSummary returned) [GET]
	 * 
	 * @param ui
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/task/query")
	@Produces({ MediaType.APPLICATION_JSON })
	public String taskQuery(@Context UriInfo ui) throws Exception {
		return null;
	}

	//
	// /**
	// * /task/execute/{taskId} query tasks TaskSummary returned) [GET | POST]
	// *
	// * @param ui
	// * @return
	// * @throws Exception
	// */
	// @GET
	// @POST
	// @Path("/task/execute/{taskId}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecute(@Context UriInfo ui, Long taskId) throws
	// Exception {
	// return null;
	// }
	//
	// /**
	// * /task/execute{id: \\d+}/activate activate task (taskId as query param..
	// )
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @GET
	// @POST
	// @Path("/task/execute{taskId}/activate")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteActivate(@Context UriInfo ui, Long taskId)
	// throws Exception {
	// return null;
	// }
	//
	/**
	 * /task/execute{id: \\d+}/claim activate task (taskId as query param.. )
	 *
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/task/{taskId}/claim")
	@Produces(MediaType.APPLICATION_JSON)
	public String taskClaim(@Context UriInfo ui, String taskId) throws Exception {
		return null;
	}

	//
	// /**
	// * /task/execute{id: \\d+}/claimnextavailable claim next available task
	// * [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/claimnextavailable")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteClaimNextAvailable(@Context UriInfo ui, Long
	// taskId) throws Exception {
	// return null;
	// }
	//
	/**
	 * /task/{id: \\d+}/complete complete task [POST] - accepts
	 * "query map parameters"
	 *
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/task/{taskId}/complete")
	@Produces(MediaType.APPLICATION_JSON)
	public String taskComplete(@Context UriInfo ui, String taskId) throws Exception {
		return null;
	}

	//
	// /**
	// * /task/execute{id: \\d+}/delegate delegate task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/delegate")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteDelegate(@Context UriInfo ui, Long taskId)
	// throws Exception {
	// return null;
	// }
	//
	// /**
	// * /task/execute{id: \\d+}/exit exit task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/exit")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteExit(@Context UriInfo ui, Long taskId) throws
	// Exception {
	// return null;
	// }
	//
	// /**
	// * /task/execute{id: \\d+}/fail fail task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/fail")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteFail(@Context UriInfo ui, Long taskId) throws
	// Exception {
	// return null;
	// }
	//
	// /**
	// * /task/execute{id: \\d+}/forward forward task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/fordward")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteForward(@Context UriInfo ui, Long taskId) throws
	// Exception {
	// return null;
	// }
	//
	// /**
	// * /task/execute{id: \\d+}/release release task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/release")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteRelease(@Context UriInfo ui, Long taskId) throws
	// Exception {
	// return null;
	// }
	//
	// /**
	// * /task/execute{id: \\d+}/resume resume task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/resume")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteResume(@Context UriInfo ui, Long taskId) throws
	// Exception {
	// return null;
	// }
	//
	// /**
	// * /task/execute{id: \\d+}/skip skip task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/skip")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteSkip(@Context UriInfo ui, Long taskId) throws
	// Exception {
	// return null;
	// }
	//
	/**
	 * /task/{id: \\d+}/start start task [POST]
	 *
	 * @param ui
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/task/{taskId}/start")
	@Produces(MediaType.APPLICATION_JSON)
	public String taskStart(@Context UriInfo ui, String taskId) throws Exception {
		return null;
	}
	//
	// /**
	// * /task/execute{id: \\d+}/stop stop task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/stop")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteStop(@Context UriInfo ui, Long taskId) throws
	// Exception {
	// return null;
	// }
	//
	// /**
	// * /task/execute{id: \\d+}/suspend suspend task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/suspend")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteSuspend(@Context UriInfo ui, Long taskId) throws
	// Exception {
	// return null;
	// }
	//
	// /**
	// * /task/execute{id: \\d+}/nominate nominate task [POST]
	// *
	// * @param ui
	// * @param taskId
	// * @return
	// * @throws Exception
	// */
	// @POST
	// @Path("/task/execute{taskId}/nominate")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String taskExecuteNominate(@Context UriInfo ui, Long taskId)
	// throws Exception {
	// return null;
	// }
	//
	// @GET
	// @Path("/deployment")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String getDeployment() throws Exception {
	// return null;
	// }

}
