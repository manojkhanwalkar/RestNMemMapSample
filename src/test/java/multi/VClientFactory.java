package multi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mkhanwalkar on 10/11/15.
 */
public class VClientFactory {

    private VClientFactory() {}

    private static VClientFactory instance = new VClientFactory();

    public static VClientFactory getInstance()
    {
        return instance ;
    }

    Map<String,VClient> clients = new HashMap<>();

    public VClient getVClient(String name)
    {

        VClient client = clients.get(name);
        if (client==null)
        {
            client = new VClient();
            clients.put(name,client);
        }

        return client;

    }

}
