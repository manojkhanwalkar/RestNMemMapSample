package flow.workflow.steps;

import flow.adapter.Adapter;
import flow.adapter.AdapterManager;
import flow.adapter.app1.App1Response;
import flow.workflow.Activity;
import io.dropwizard.cli.Cli;
import query.ClientResponse;
import query.Payload;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 11/6/15.
 */
public class Activity1 implements Activity {

    @Override
    public void execute(Request req, Response res) {
        System.out.println(req);

        ClientResponse response = (ClientResponse) res;

        Payload payload = new Payload();

        Adapter adapter1 = AdapterManager.getInstance().getAdapter("APP1~C1");
        App1Response response1 = (App1Response) adapter1.send(req);

        payload.set("App1Response",response1.getDummy() );

        response.setPayload(payload);

    }
}
