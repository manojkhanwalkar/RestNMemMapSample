package flow.adapter.app1;

import client.SampleClient;
import flow.adapter.Adapter;
import flow.adapter.AdapterManager;
import flow.transform.Transform;
import flow.transform.TransformManager;
import flow.transport.Transport;
import flow.transport.TransportManager;
import query.ClientRequest;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App1Adapter implements Adapter {

    String key ;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {

        this.key = key;
    }


    public App1Adapter()
    {
      ///  AdapterManager.getInstance().register(key,this);

    }


    @Override
    public Response send(Request request) {

        Transform transform = TransformManager.getInstance().getTransform("APP1~C1");

        App1Request request1 = (App1Request) transform.convert(request);

        Transport transport = TransportManager.getInstance().getTransport("APP1~C1");
        App1Response response1 = (App1Response) transport.send(request1);

        Response response = transform.convert(response1);

        return response ;
    }


}
