package flow.transport;

import client.RestConnector;
import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App1Transport implements Transport {

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

    public App1Transport()
    {
  //      TransportManager.getInstance().register(key,this);
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
                return send((App1Request) request);
            } finally {
                disconnect();
            }


    }


    private App1Response send(App1Request request)
    {
        HttpEntity<App1Request> requestEntity = new HttpEntity<>(request);
        ResponseEntity<App1Response> response1 = restTemplate.exchange("http://" + host + ":" + port + "/app1", HttpMethod.POST, requestEntity, App1Response.class);

        return response1.getBody();
    }


}
