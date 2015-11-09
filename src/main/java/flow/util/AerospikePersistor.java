package flow.util;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;
import query.ClientRequest;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 11/7/15.
 */
public class AerospikePersistor implements Persistor {

    public AerospikePersistor()
    {

    }

    String hostName;
    int port ;


    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    AerospikeClient client ;

    @Override
    public void init() {

         client = new AerospikeClient(null, hostName, port);

    }

    @Override
    public void persist(Request request) {
            WritePolicy policy = new WritePolicy();
            policy.sendKey = true;

                Key key = new Key("test", "Request", request.getRequestId());
                Bin bin = new Bin("Request", request.jsonString());
                client.put(policy, key, bin);



    }

    @Override
    public void persist(Response response) {

    }

    @Override
    public void destroy() {

        client.close();
    }


    public static void main(String[] args) throws Exception {
        AerospikePersistor persistor = new AerospikePersistor();
        persistor.setHostName("localhost");
        persistor.setPort(3000);

        persistor.init();

        persistor.persist(new ClientRequest());

        Thread.sleep(5000);

        persistor.destroy();
    }



}
