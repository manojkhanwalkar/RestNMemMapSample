package flow.adapter.app2;

import flow.adapter.Adapter;
import flow.transform.Transform;
import flow.transform.TransformManager;
import flow.transport.Transport;
import flow.transport.TransportManager;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App2Adapter implements Adapter {

    String key ;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {

        this.key = key;
    }


    public App2Adapter()
    {
      //  AdapterManager.getInstance().register(key,this);

    }



    @Override
    public Response send(String adapterKey, Request request) {

        Transform transform = TransformManager.getInstance().getTransform(adapterKey);

        App2Request request1 = (App2Request) transform.convert(request);

        Transport transport = TransportManager.getInstance().getTransport(adapterKey);
        App2Response response1 = (App2Response) transport.send(request1);

        Response response = transform.convert(response1);

        return response ;
    }


}
