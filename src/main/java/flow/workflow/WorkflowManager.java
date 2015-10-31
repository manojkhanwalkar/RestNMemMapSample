package flow.workflow;

import query.Request;
import query.Response;

public class WorkflowManager {

    private WorkflowManager()
    {

    }




    public Response getScore(Request request) {
        Response response=new Response();
 /*       request.getIdentifiers().stream().forEach(id->{

            IdCount score = new IdCount(id,10);
            response.addScore(score);

        }); */

        return response;

    }





    static class Holder
    {
        static WorkflowManager factory = new WorkflowManager();
    }

    public static WorkflowManager getInstance()
    {
        return Holder.factory;

    }






}
