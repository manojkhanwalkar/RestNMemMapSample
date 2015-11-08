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
        this.keys = keys;
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
