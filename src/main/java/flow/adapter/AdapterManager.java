package flow.adapter;

import flow.transform.Transform;

import java.util.HashMap;
import java.util.Map;

public class AdapterManager {

    private AdapterManager()
    {

    }

    Map<String,Adapter> adapters = new HashMap<>();

    public void register(String key, Adapter adapter)
    {
        adapters.put(key,adapter);
    }


    public Adapter getAdapter(String key)
    {

        Adapter wf = adapters.get(key);


        return wf;

    }









    static class Holder
    {
        static AdapterManager factory = new AdapterManager();
    }

    public static AdapterManager getInstance()
    {
        return Holder.factory;

    }






}
