package flow.workflow.steps;

import flow.util.HMACKeyManager;
import flow.util.HMACValidator;
import flow.workflow.Decision;
import query.ClientRequest;
import query.Envelope;
import query.Request;
import query.Response;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Created by mkhanwalkar on 11/6/15.
 */
public class HMACValidityDecision implements Decision {

    @Override
    public boolean execute(Request req, Response response) {
        if (!(req instanceof ClientRequest)) {
            return false;
        }
        return isValid(((ClientRequest) req).getEnvelope());
    }

    /**
     * Fails closed: an unknown client, a client with no configured key, or a missing HMAC is
     * rejected. The comparison is constant-time so the expected value can't be recovered by timing.
     */
    public static boolean isValid(Envelope envelope) {
        if (envelope == null || envelope.getCliendId() == null || envelope.getHmac() == null) {
            return false;
        }
        String key = HMACKeyManager.getInstance().getKey(envelope.getCliendId());
        if (key == null || key.isEmpty()) {
            return false;
        }
        try {
            String hmacTgt = HMACValidator.encode(key, envelope.getCliendId() + envelope.getRequestType());
            return MessageDigest.isEqual(hmacTgt.getBytes(StandardCharsets.UTF_8),
                    envelope.getHmac().getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            return false;
        }
    }
}
