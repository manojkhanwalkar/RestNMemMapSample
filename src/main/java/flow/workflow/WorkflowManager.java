package flow.workflow;

import client.SampleClient;
import flow.adapter.Adapter;
import flow.adapter.app1.App1Adapter;
import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import flow.adapter.app2.App2Adapter;
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

        System.out.println(request);

        ClientResponse response=new ClientResponse();
        Payload payload = new Payload();

        Adapter adapter1 = new App1Adapter();
        App1Response response1 = (App1Response) adapter1.send(request);

        payload.set("App1Response",response1.getDummy() );

        Adapter adapter2 = new App2Adapter();
        App2Response response2 = (App2Response) adapter2.send(request);

        payload.set("App1Response",response1.getDummy() );


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
