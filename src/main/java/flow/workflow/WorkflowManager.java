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

import java.util.HashMap;
import java.util.Map;

public class WorkflowManager {

    private WorkflowManager()
    {

    }

    Map<String,Workflow> workflows = new HashMap<>();

    public void register(String key, Workflow workflow)
    {
        workflows.put(key,workflow);
    }

    private String extractKey(ClientRequest request)
    {
        return request.getEnvelope().getRequestType() + "~" + request.getEnvelope().getCliendId();
    }

    public Workflow getWorkflow(ClientRequest request)
    {

        String key =  extractKey(request);
        Workflow wf = workflows.get(key);


        return wf;

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
