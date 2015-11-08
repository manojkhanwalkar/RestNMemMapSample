package flow.workflow.steps;

import flow.util.HMACValidator;
import flow.workflow.Decision;
import query.ClientRequest;
import query.Envelope;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 11/6/15.
 */
public class HMACValidityDecision implements Decision {

    @Override
    public boolean execute(Request req, Response response) {

       try {
            ClientRequest request = (ClientRequest) req;
            Envelope envelope = request.getEnvelope();
            String hmacSrc = envelope.getHmac();
            String hmacTgt = HMACValidator.encode("KEY1", envelope.getCliendId() + envelope.getRequestType());
            //TODO - get key via HMAC key manager
            if (hmacSrc.equals(hmacTgt))
                return true;
            else
                return false;
        } catch (Exception e) {
           e.printStackTrace();
           return false;
       }

       // return false;

        //     envelope.setHmac(HMACValidator.encode("KEY1", envelope.getCliendId() + envelope.getRequestType()));


    }
}
