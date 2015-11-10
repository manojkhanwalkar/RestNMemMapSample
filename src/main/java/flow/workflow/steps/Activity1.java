package flow.workflow.steps;

import flow.adapter.Adapter;
import flow.adapter.AdapterManager;
import flow.adapter.app1.App1Response;
import flow.util.AerospikePersistor;
import flow.util.MySQLPersistor;
import flow.workflow.Activity;
import io.dropwizard.cli.Cli;
import query.*;

/**
 * Created by mkhanwalkar on 11/6/15.
 */
public class Activity1 implements Activity {

    @Override
    public void execute(Request req, Response res) {

        ClientRequest request = (ClientRequest) req;

     //   AerospikePersistor.getInstance().persist(request.getEnvelope().getRequestId(),ClientRequest.jsonString(request));
     //
     MySQLPersistor.getInstance().persist(request.getEnvelope().getRequestId(),ClientRequest.jsonString(request));

    }
}
