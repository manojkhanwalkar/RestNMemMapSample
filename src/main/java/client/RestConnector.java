package client;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import flow.adapter.app2.App2Request;
import flow.adapter.app2.App2Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import query.ClientRequest;
import query.ClientResponse;

public class RestConnector  {

    private final int port ;
    private final String host ;

    RestTemplate restTemplate ;



    public RestConnector(String host, int port)
    {
        this.port = port ;
        this.host = host ;
     //   this.protocol = protocol;

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

    public ClientResponse send(ClientRequest request)
    {
        HttpEntity<ClientRequest> requestEntity = new HttpEntity<>(request);
        ResponseEntity<ClientResponse> response1 = restTemplate.exchange("http://" + host + ":" + port + "/sample", HttpMethod.POST, requestEntity, ClientResponse.class);

        return response1.getBody();
    }

    public App1Response send(App1Request request)
    {
        HttpEntity<App1Request> requestEntity = new HttpEntity<>(request);
        ResponseEntity<App1Response> response1 = restTemplate.exchange("http://" + host + ":" + port + "/app1", HttpMethod.POST, requestEntity, App1Response.class);

        return response1.getBody();
    }

    public App2Response send(App2Request request)
    {
        HttpEntity<App2Request> requestEntity = new HttpEntity<>(request);
        ResponseEntity<App2Response> response1 = restTemplate.exchange("http://" + host + ":" + port + "/app2", HttpMethod.POST, requestEntity, App2Response.class);

        return response1.getBody();
    }

}
