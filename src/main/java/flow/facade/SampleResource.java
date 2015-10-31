package flow.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
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

        ClientResponse response = sample.getScore(request);



        return response;
    }
}