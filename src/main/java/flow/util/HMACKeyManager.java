package flow.util;

import flow.transform.Transform;

import java.util.HashMap;
import java.util.Map;

public class HMACKeyManager {

    private HMACKeyManager()
    {

    }

    Map<String,String> keys = new HashMap<>();

    public void setKeys(Map<String, String> keys) {
        // Entries whose value is missing (e.g. the env var is unset) are dropped, so that client fails closed.
        Map<String, String> copy = new HashMap<>();
        if (keys != null) {
            keys.forEach((k, v) -> {
                if (k != null && v != null && !v.isEmpty()) {
                    copy.put(k, v);
                }
            });
        }
        this.keys = copy;
    }

    public void register(String clientId, String key)
    {
        keys.put(clientId,key);
    }


    public String getKey(String clientId)
    {

        return keys.get(clientId);

    }









    static class Holder
    {
        static HMACKeyManager factory = new HMACKeyManager();
    }

    public static HMACKeyManager getInstance()
    {
        return Holder.factory;

    }






}
