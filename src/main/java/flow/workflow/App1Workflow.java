package flow.workflow;

import flow.adapter.Adapter;
import flow.adapter.AdapterManager;
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
public class App1Workflow extends Workflow {


    String key ;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {

        this.key = key;
    }

    public App1Workflow()
    {
        init();
    }


    public  void init()
    {
        //        return request.getEnvelope().getRequestType() + "~" + request.getEnvelope().getCliendId();

     /*   WorkflowManager manager = WorkflowManager.getInstance();
        manager.register("APP1~C1", this);*/
    }

    @Override
    public ClientResponse execute(ClientRequest request) {

        ClientResponse response=new ClientResponse();
        getFirstStep().execute(request,response);


            return response;



    }
}
