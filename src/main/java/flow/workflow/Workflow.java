package flow.workflow;

import query.ClientRequest;
import query.ClientResponse;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public interface Workflow {

    public ClientResponse execute(ClientRequest request);

}