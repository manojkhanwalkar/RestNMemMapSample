package flow.workflow.steps;

import flow.workflow.Decision;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 11/6/15.
 */
public class FalseDecision implements Decision {

    @Override
    public boolean execute(Request request, Response response) {
        return false;
    }
}
