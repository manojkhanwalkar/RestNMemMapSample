package flow.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import query.Request;
import query.Response;
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
    public Response sayHello(@Context HttpServletRequest hsReq, @Valid Request request) {

        WorkflowManager sample = WorkflowManager.getInstance();

        Response response = sample.getScore(request);



        return response;
    }
}