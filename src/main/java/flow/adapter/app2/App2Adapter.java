package flow.adapter.app2;

import client.SampleClient;
import flow.adapter.Adapter;
import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App2Adapter implements Adapter {


    @Override
    public Response send(Request request) {

        SampleClient client = SampleClient.getInstance();


        client.setHost("localhost");
        client.setPort(12025);

        App2Request request2 = new App2Request();
        App2Response response2 = client.send(request2);

        return response2 ;
    }


}
