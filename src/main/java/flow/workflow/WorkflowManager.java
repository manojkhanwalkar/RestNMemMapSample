package flow.workflow;

import client.SampleClient;
import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import flow.adapter.app2.App2Request;
import flow.adapter.app2.App2Response;
import query.Payload;
import query.ClientRequest;
import query.ClientResponse;

public class WorkflowManager {

    private WorkflowManager()
    {

    }




    public ClientResponse getScore(ClientRequest request) {
        ClientResponse response=new ClientResponse();
        Payload payload = new Payload();

        SampleClient client = SampleClient.getInstance();


        client.setHost("localhost");
        client.setPort(11025);

        App1Request request1 = new App1Request();
        App1Response response1 = client.send(request1);
        payload.set("App1Response",response1.getDummy() );
        response.setPayload(payload);

        client.setHost("localhost");
        client.setPort(12025);

        App2Request request2 = new App2Request();
        App2Response response2 = client.send(request2);
        payload.set("App2Response",response2.getDummy() );
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
