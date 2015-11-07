package flow.transform;

import flow.adapter.app1.App1Request;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App1Transform implements Transform {

    String key ;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {

        this.key = key;
    }



    public App1Transform()
    {
      //  TransformManager.getInstance().register(key,this);
    }

    @Override
    public Request convert(Request request) {
        App1Request request1 = new App1Request();
        request1.setDummy(request.toString());

        return request1;
    }

    @Override
    public Response convert(Response response) {
        return response;
    }
}
