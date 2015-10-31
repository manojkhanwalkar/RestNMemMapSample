package flow.transport;

import flow.workflow.Workflow;
import query.ClientRequest;

import java.util.HashMap;
import java.util.Map;

public class TransportManager {

    private TransportManager()
    {

    }

    Map<String,Transport> transports = new HashMap<>();

    public void register(String key, Transport transport)
    {
        transports.put(key,transport);
    }

    private String extractKey(ClientRequest request)
    {
        return request.getEnvelope().getRequestType() + "~" + request.getEnvelope().getCliendId();
    }

    public Transport getTransport(ClientRequest request)
    {

        String key =  extractKey(request);
        Transport wf = transports.get(key);


        return wf;

    }









    static class Holder
    {
        static TransportManager factory = new TransportManager();
    }

    public static TransportManager getInstance()
    {
        return Holder.factory;

    }






}
