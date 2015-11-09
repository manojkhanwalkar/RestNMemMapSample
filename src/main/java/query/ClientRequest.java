package query;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ClientRequest implements Request
{

Envelope envelope;

    Payload payload;

    public Envelope getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "envelope=" + envelope +
                ", payload=" + payload +
                '}';
    }

    static ObjectMapper mapper = new ObjectMapper();


    public static String jsonString(ClientRequest request) {
        try {
            return mapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
