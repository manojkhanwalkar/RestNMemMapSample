package flow.transform;

import flow.adapter.app1.App1Request;
import flow.adapter.app2.App2Request;
import flow.adapter.app2.App2Response;
import flow.transport.Transport;
import flow.transport.TransportManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App2Transform implements Transform {

    String key ;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {

        this.key = key;
    }



    public App2Transform()
    {
     //   TransformManager.getInstance().register(key,this);
    }

    @Override
    public Request convert(Request request) {
        App2Request request1 = new App2Request();

        return request1;
    }

    @Override
    public Response convert(Response response) {
        return response;
    }
}
