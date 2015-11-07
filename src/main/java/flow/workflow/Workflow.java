package flow.workflow;

import query.ClientRequest;
import query.ClientResponse;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public abstract class  Workflow {

    public abstract ClientResponse execute(ClientRequest request);

    public abstract String getKey();

    public abstract void setKey(String key);

    Step firstStep;

    public Step getFirstStep() {
        return firstStep;
    }

    public void setFirstStep(Step firstStep) {
        this.firstStep = firstStep;
    }
}