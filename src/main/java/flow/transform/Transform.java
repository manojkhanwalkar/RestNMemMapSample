package flow.transform;

import flow.adapter.app1.App1Request;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public interface Transform {
    Request convert(Request request);
    Response convert(Response response);

    // public Response transform(Request request);

}
