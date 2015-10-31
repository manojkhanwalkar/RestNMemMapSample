package flow.transform;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App1Transform implements Transform {


    public App1Transform(String key)
    {
        TransformManager.getInstance().register(key,this);
    }



}
