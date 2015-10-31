package flow.workflow;

import flow.adapter.Adapter;
import flow.adapter.app1.App1Adapter;
import flow.adapter.app1.App1Response;
import flow.adapter.app2.App2Adapter;
import flow.adapter.app2.App2Response;
import query.ClientRequest;
import query.ClientResponse;
import query.Payload;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App12Workflow implements Workflow {

    public App12Workflow()
    {
        init();
    }


    public void init()
    {
        //        return request.getEnvelope().getRequestType() + "~" + request.getEnvelope().getCliendId();

        WorkflowManager.getInstance().register("APP12~C1",this);
    }

    @Override
    public ClientResponse execute(ClientRequest request) {


            System.out.println(request);

            ClientResponse response=new ClientResponse();
            Payload payload = new Payload();

            Adapter adapter1 = new App1Adapter();
            App1Response response1 = (App1Response) adapter1.send(request);

            payload.set("App1Response",response1.getDummy() );

           Adapter adapter2 = new App2Adapter();
            App2Response response2 = (App2Response) adapter2.send(request);



            payload.set("App2Response",response2.getDummy() );
            response.setPayload(payload);


            return response;



    }
}
