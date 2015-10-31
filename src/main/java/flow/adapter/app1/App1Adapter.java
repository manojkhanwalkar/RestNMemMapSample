package flow.adapter.app1;

import client.SampleClient;
import flow.adapter.Adapter;
import flow.transport.Transport;
import flow.transport.TransportManager;
import query.ClientRequest;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App1Adapter implements Adapter {


    @Override
    public Response send(Request request) {

        Transport transport = TransportManager.getInstance().getTransport("APP1~C1");
        App1Request request1 = new App1Request();
        App1Response response1 = (App1Response) transport.send(request1);

        return response1 ;
    }


}
