package flow.util;

import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 11/8/15.
 */
public interface Persistor {

    public void init();

    public void persist(long id, String request);

    public void persist(Response response);

    public void destroy();
}
