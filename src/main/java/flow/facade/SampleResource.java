package flow.facade;

import flow.workflow.Workflow;
import flow.workflow.WorkflowManager;
import flow.workflow.steps.HMACValidityDecision;
import query.ClientRequest;
import query.ClientResponse;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

    public SampleResource() {
    }

    @POST
    public ClientResponse sayHello(@Valid ClientRequest request) {

        if (request == null || request.getEnvelope() == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        // Every workflow forwards to a backend service, so every request must carry a valid
        // HMAC for its client id before any workflow (including persistence) runs.
        if (!HMACValidityDecision.isValid(request.getEnvelope())) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        Workflow workflow = WorkflowManager.getInstance().getWorkflow(request);
        if (workflow == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return workflow.execute(request);
    }
}
