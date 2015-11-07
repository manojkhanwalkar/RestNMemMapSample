package client;

import com.fasterxml.jackson.databind.ObjectMapper;
import query.ClientRequest;
import query.ClientResponse;
import query.Envelope;
import query.Payload;

/**
 * Created by mkhanwalkar on 7/26/15.
 */
public class ClientTester {



    public static void main(String[] args)  throws Exception {

        SampleClient client = SampleClient.getInstance();

        ObjectMapper mapper = new ObjectMapper();

        client.setHost("localhost");
        client.setPort(10025);

        {
            ClientRequest request = new ClientRequest();
            Envelope envelope = new Envelope();
            envelope.setCliendId("C1");
            envelope.setRequestType("APP1");
            request.setEnvelope(envelope);
            Payload payload = new Payload();
            payload.set("Prop1", "Value1");
            payload.set("Prop2", "Value2");
            payload.set("Prop3", "Value3");
            request.setPayload(payload);
            ClientResponse response = client.send(request);
            System.out.println(mapper.writeValueAsString(response));
        }

        {
            ClientRequest request = new ClientRequest();
            Envelope envelope = new Envelope();
            envelope.setCliendId("C1");
            envelope.setRequestType("APP12");
            request.setEnvelope(envelope);
            ClientResponse response = client.send(request);
            System.out.println(mapper.writeValueAsString(response));
        }

    }

}
