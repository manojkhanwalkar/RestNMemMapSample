package flow.transport;

import flow.adapter.app2.App2Request;
import flow.adapter.app2.App2Response;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public interface  Transport {

    public Response send(Request request);

    public String getKey();

    public void setKey(String key);



}
