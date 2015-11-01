package flow.transport;

import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import flow.adapter.app2.App2Request;
import flow.adapter.app2.App2Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App2Transport implements Transport {

    String host ;
    int port ;
    String key ;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    RestTemplate restTemplate ;

    public App2Transport()
    {
 //       TransportManager.getInstance().register(key,this);
    }

    public void connect() {


        restTemplate = new RestTemplate();

        System.out.println("Rest adapter initialized and connected");
    }

    public void finalize()
    {
        disconnect();

        System.out.println("Finalizer called ");
    }


    public void disconnect() {
        restTemplate = null;
    }


    @Override
    public Response send(Request request) {

            try {
                connect();
                return send((App2Request) request);
            } finally {
                disconnect();
            }


    }


    private App2Response send(App2Request request)
    {
        HttpEntity<App2Request> requestEntity = new HttpEntity<>(request);
        ResponseEntity<App2Response> response1 = restTemplate.exchange("http://" + host + ":" + port + "/app2", HttpMethod.POST, requestEntity, App2Response.class);

        return response1.getBody();
    }


}
