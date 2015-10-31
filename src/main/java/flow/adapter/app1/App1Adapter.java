package flow.adapter.app1;

import client.SampleClient;
import flow.adapter.Adapter;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App1Adapter implements Adapter {


    @Override
    public Response send(Request request) {

        SampleClient client = SampleClient.getInstance();


        client.setHost("localhost");
        client.setPort(11025);

        App1Request request1 = new App1Request();
        App1Response response1 = client.send(request1);

        return response1 ;
    }


}
