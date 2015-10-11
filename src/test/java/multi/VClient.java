package multi;

/**
 * Created by mkhanwalkar on 10/11/15.
 */
public class VClient {

    ThreadLocal<VConnection> connections = new ThreadLocal<>();

    public VClient()
    {

    }

    public void send(String s)
    {
        VConnection connection = connections.get();
        if (connection==null)
        {
            connection = new VConnection();
            connections.set(connection);
        }

        connection.send(s);
    }

    public String recv()
    {
        VConnection connection = connections.get();
        if (connection==null)
        {
            connection = new VConnection();
            connections.set(connection);
        }

        return connection.recv();

    }



}
