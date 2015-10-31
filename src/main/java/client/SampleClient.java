package client;

import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import flow.adapter.app2.App2Request;
import flow.adapter.app2.App2Response;
import query.ClientRequest;
import query.ClientResponse;

/**
 * Created by mkhanwalkar on 7/25/15.
 */
public class SampleClient {

 //   ThreadLocal< RestConnector> localConnector = new ThreadLocal<>();

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

    public ClientResponse send( ClientRequest request) {

/*        RestConnector connector = localConnector.get();
        if (connector==null)
        {
            connector = new RestConnector(host, port);
            connector.connect();
            localConnector.set(connector);
        }*/

        RestConnector connector = new RestConnector(host, port);
        try {
            connector.connect();
            return connector.send(request);
        } finally {
            connector.disconnect();
        }

    }


    public App1Response send( App1Request request) {

        RestConnector connector = new RestConnector(host, port);
        try {
            connector.connect();
            return connector.send(request);
        } finally {
            connector.disconnect();
        }

    }

    public App2Response send( App2Request request) {

        RestConnector connector = new RestConnector(host, port);
        try {
            connector.connect();
            return connector.send(request);
        } finally {
            connector.disconnect();
        }

    }



}
