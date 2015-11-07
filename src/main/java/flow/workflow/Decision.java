package flow.workflow;

import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 11/6/15.
 */
public interface Decision {
    boolean execute(Request request, Response response);
}
