package query;


import java.util.ArrayList;
import java.util.List;

public class ClientRequest
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
}
