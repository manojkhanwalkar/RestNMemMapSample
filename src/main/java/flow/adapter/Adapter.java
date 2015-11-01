package flow.adapter;

import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public interface Adapter {

    public Response send(Request request);
    public String getKey();

    public void setKey(String key);


}
