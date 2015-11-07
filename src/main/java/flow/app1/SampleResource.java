package flow.app1;

import com.fasterxml.jackson.databind.ObjectMapper;
import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/app1")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

    public SampleResource() {
    }


    static ObjectMapper mapper = new ObjectMapper();

    @POST
    public App1Response sayHello(@Context HttpServletRequest hsReq, @Valid App1Request request) {



        App1Response response = new App1Response();
        response.setDummy("Hello from App1 " + new Date() + " " + request.toString());

        return response;

    }
}