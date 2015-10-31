package flow.workflow;

import client.SampleClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import query.Payload;
import query.Request;
import query.Response;

public class WorkflowManager {

    private WorkflowManager()
    {

    }




    public Response getScore(Request request) {
        Response response=new Response();

        SampleClient client = SampleClient.getInstance();

        ObjectMapper mapper = new ObjectMapper();

        client.setHost("localhost");
        client.setPort(11025);


        App1Request request1 = new App1Request();
        App1Response response1 = client.send(request1);
   //     System.out.println(mapper.writeValueAsString(response1));

        Payload payload = new Payload();
        payload.set("App1Response",response1.getDummy() );
        response.setPayload(payload);


        return response;

    }





    static class Holder
    {
        static WorkflowManager factory = new WorkflowManager();
    }

    public static WorkflowManager getInstance()
    {
        return Holder.factory;

    }






}
