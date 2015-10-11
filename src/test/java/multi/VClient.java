package multi;

import java.lang.ref.WeakReference;

/**
 * Created by mkhanwalkar on 10/11/15.
 */
public class VClient {

    ThreadLocal<WeakReference<VConnection>> connections = new ThreadLocal<>();

    public VClient()
    {

    }

    public void send(String s)
    {
        WeakReference<VConnection> refconnection = connections.get();
        if (refconnection==null)
        {
            VConnection connection = new VConnection();
            connections.set(new WeakReference<VConnection>(connection));
            connection.send(s);

        }

        refconnection.get().send(s);

    }

    public String recv()
    {
        WeakReference<VConnection> refconnection = connections.get();
        if (refconnection==null)
        {
            VConnection connection = new VConnection();
            connections.set(new WeakReference<VConnection>(connection));
            connection.recv();

        }

        return refconnection.get().recv();

    }



}
