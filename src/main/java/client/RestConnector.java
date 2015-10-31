package client;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import flow.adapter.app1.App1Request;
import flow.adapter.app1.App1Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import query.Request;
import query.Response;

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

    public Response send(Request request)
    {
        HttpEntity<Request> requestEntity = new HttpEntity<>(request);
        ResponseEntity<Response> response1 = restTemplate.exchange("http://" + host + ":" + port + "/sample", HttpMethod.POST, requestEntity, Response.class);

        return response1.getBody();
    }

    public App1Response send(App1Request request)
    {
        HttpEntity<App1Request> requestEntity = new HttpEntity<>(request);
        ResponseEntity<App1Response> response1 = restTemplate.exchange("http://" + host + ":" + port + "/app1", HttpMethod.POST, requestEntity, App1Response.class);

        return response1.getBody();
    }


}
