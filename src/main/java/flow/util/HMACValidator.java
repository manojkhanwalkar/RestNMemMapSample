package flow.util;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

public class HMACValidator {


    public static String encode(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
    }

    public static void main(String [] args) throws Exception {
        System.out.println(encode("key", "The quick brown fox jumps over the lazy dog"));
    }

    //TODO - HMAC configuration manager (client id / secret )
    //TODO - Client sends hmac in envelope
    //TODO - Activity to validate HMAC
    //TODO - Decision based on HMAC validity
    // TODO - Persist request to Aerospike , might need a unique request id as key , persist both envelope and payload .


}
