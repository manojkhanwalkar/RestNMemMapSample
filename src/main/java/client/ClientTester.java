package client;

import com.fasterxml.jackson.databind.ObjectMapper;
import query.ClientRequest;
import query.ClientResponse;
import query.Envelope;

/**
 * Created by mkhanwalkar on 7/26/15.
 */
public class ClientTester {



    public static void main(String[] args)  throws Exception {

        SampleClient client = SampleClient.getInstance();

        ObjectMapper mapper = new ObjectMapper();

        client.setHost("localhost");
        client.setPort(10025);


        ClientRequest request = new ClientRequest();
        Envelope envelope = new Envelope();
        envelope.setCliendId("C1");
        envelope.setRequestType("APP12");
        request.setEnvelope(envelope);
        ClientResponse response = client.send(request);
        System.out.println(mapper.writeValueAsString(response));


    }

}
