package flow.util;

import query.ClientRequest;

/**
 * Created by mkhanwalkar on 11/7/15.
 */
public class KeyCreator {

    public static String createKey(ClientRequest request)
    {
        String adapterKey = request.getEnvelope().getRequestType() + "~" + request.getEnvelope().getCliendId();
        return adapterKey;

    }
}
