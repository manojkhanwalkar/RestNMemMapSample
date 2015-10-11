package multi;

/**
 * Created by mkhanwalkar on 10/11/15.
 * Mock connection object
 */
public class VConnection {

    public void init()
    {
        System.out.println("VConection created");
    }

    public void destroy()
    {
        System.out.println("VConnection destroyed");

    }

    public void send(String s)
    {

        System.out.println("Sent to server " + s);

    }

    public String recv()
    {
        return "Response from server " + System.nanoTime();
    }

    public void finalize()
    {
        destroy();
    }

}
