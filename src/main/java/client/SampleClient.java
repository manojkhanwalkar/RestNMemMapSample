package client;

import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 7/25/15.
 */
public class SampleClient {

    ThreadLocal< RestConnector> localConnector = new ThreadLocal<>();

    private SampleClient()
    {

    }

    static class Holder
    {
        static SampleClient factory = new SampleClient();
    }

    public static SampleClient getInstance()
    {
        return Holder.factory;

    }


    String host ;
    int port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Response send( Request request) {

        RestConnector connector = localConnector.get();
        if (connector==null)
        {
            connector = new RestConnector(host, port);
            connector.connect();
            localConnector.set(connector);
        }


        return connector.send(request);

    }


    public App1Response send( App1Request request) {

        RestConnector connector = localConnector.get();
        if (connector==null)
        {
            connector = new RestConnector(host, port);
            connector.connect();
            localConnector.set(connector);
        }


        return connector.send(request);

    }




}
