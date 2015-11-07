package flow.workflow;

import flow.adapter.Adapter;
import flow.adapter.AdapterManager;
import flow.adapter.app1.App1Response;
import flow.adapter.app2.App2Response;
import query.ClientRequest;
import query.ClientResponse;
import query.Payload;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App12Workflow extends Workflow {

    String key ;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {

        this.key = key;
    }


    public App12Workflow()
    {
        init();
    }


    public void init()
    {
        //        return request.getEnvelope().getRequestType() + "~" + request.getEnvelope().getCliendId();

     ///   WorkflowManager.getInstance().register("APP12~C1",this);
    }

    @Override
    public ClientResponse execute(ClientRequest request) {


            System.out.println(request);

            ClientResponse response=new ClientResponse();
            Payload payload = new Payload();

        Adapter adapter1 = AdapterManager.getInstance().getAdapter("APP1~C1");
        App1Response response1 = (App1Response) adapter1.send("APP1~C1", request);

            payload.set("App1Response",response1.getDummy() );

        Adapter adapter2 = AdapterManager.getInstance().getAdapter("APP2~C1");
        App2Response response2 = (App2Response) adapter2.send("APP2~C1", request);



            payload.set("App2Response",response2.getDummy() );
            response.setPayload(payload);


            return response;



    }
}
