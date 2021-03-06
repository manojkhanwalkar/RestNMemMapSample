package flow.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import flow.adapter.app1.App1Adapter;
import flow.adapter.app2.App2Adapter;
import flow.transform.App1Transform;
import flow.transform.App2Transform;
import flow.transport.App1Transport;
import flow.transport.App2Transport;
import flow.workflow.App12Workflow;
import flow.workflow.App1Workflow;
import flow.workflow.App2Workflow;
import query.ClientRequest;
import query.ClientResponse;
import flow.workflow.WorkflowManager;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

    public SampleResource() {
    }


    static ObjectMapper mapper = new ObjectMapper();

    @POST
    public ClientResponse sayHello(@Context HttpServletRequest hsReq, @Valid ClientRequest request) {

        WorkflowManager sample = WorkflowManager.getInstance();




        ClientResponse response = sample.getWorkflow(request).execute(request);



        return response;
    }
}