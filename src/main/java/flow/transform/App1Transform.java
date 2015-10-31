package flow.transform;

import flow.adapter.app1.App1Request;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App1Transform implements Transform {


    public App1Transform(String key)
    {
        TransformManager.getInstance().register(key,this);
    }

    @Override
    public Request convert(Request request) {
        App1Request request1 = new App1Request();

        return request1;
    }

    @Override
    public Response convert(Response response) {
        return response;
    }
}
