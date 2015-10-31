package sample;

import query.Request;
import query.Response;

public class Sample {

    private Sample()
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
        static Sample factory = new Sample();
    }

    public static Sample getInstance()
    {
        return Holder.factory;

    }






}
