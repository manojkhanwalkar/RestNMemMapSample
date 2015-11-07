package flow.workflow.steps;

import flow.adapter.Adapter;
import flow.adapter.AdapterManager;
import flow.adapter.app1.App1Response;
import flow.util.KeyCreator;
import flow.workflow.Activity;
import query.*;

/**
 * Created by mkhanwalkar on 11/6/15.
 */
public class Activity2 implements Activity {

    @Override
    public void execute(Request req, Response res) {
        System.out.println(req);

        ClientRequest request = (ClientRequest) req;
        ClientResponse response = (ClientResponse) res;

        Payload payload = new Payload();

        String adapterKey = KeyCreator.createKey(request);
        Adapter adapter1 = AdapterManager.getInstance().getAdapter(adapterKey);
        App1Response response1 = (App1Response) adapter1.send(adapterKey,req);

        payload.set("App1Response",response1.getDummy() );

        response.setPayload(payload);

    }

}
