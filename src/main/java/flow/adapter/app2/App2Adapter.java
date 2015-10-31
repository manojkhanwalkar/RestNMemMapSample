package flow.adapter.app2;

import client.SampleClient;
import flow.adapter.Adapter;
import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import flow.transport.Transport;
import flow.transport.TransportManager;
import query.ClientRequest;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App2Adapter implements Adapter {


    @Override
    public Response send(Request request) {

        Transport transport = TransportManager.getInstance().getTransport("APP2~C1");
        App2Request request1 = new App2Request();
        App2Response response1 = (App2Response) transport.send(request1);

        return response1 ;
    }


}
