package query;


import java.util.ArrayList;
import java.util.List;

public class ClientResponse implements Response {

    Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
