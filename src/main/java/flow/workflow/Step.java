package flow.workflow;

import query.Request;
import query.Response;

import java.util.List;

/**
 * Created by mkhanwalkar on 11/6/15.
 */
public class  Step {

    Decision decision ;

    Activity activity;

    Step trueStep;
    Step falseStep;

    public boolean execute(Request request , Response response)
    {
        activity.execute(request,response);
        boolean result = decision.execute(request,response);

        if (result&&trueStep!=null)
        {
            return trueStep.execute(request,response);
        }
        else if (!result && falseStep!=null)
        {
            return falseStep.execute(request,response);
        }
        else
        {
            return result ;
        }
    }
}
