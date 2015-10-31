package flow.transform;

import flow.transport.Transport;

import java.util.HashMap;
import java.util.Map;

public class TransformManager {

    private TransformManager()
    {

    }

    Map<String,Transform> transforms = new HashMap<>();

    public void register(String key, Transform transform)
    {
        transforms.put(key,transform);
    }


    public Transform getTransform(String key)
    {

        Transform wf = transforms.get(key);


        return wf;

    }









    static class Holder
    {
        static TransformManager factory = new TransformManager();
    }

    public static TransformManager getInstance()
    {
        return Holder.factory;

    }






}
