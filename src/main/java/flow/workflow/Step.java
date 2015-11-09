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

    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Step getTrueStep() {
        return trueStep;
    }

    public void setTrueStep(Step trueStep) {
        this.trueStep = trueStep;
    }

    public Step getFalseStep() {
        return falseStep;
    }

    public void setFalseStep(Step falseStep) {
        this.falseStep = falseStep;
    }

    public boolean execute(Request request , Response response)
    {
        activity.execute(request, response);
        if (decision==null)
        {
            return true ;
        }
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
