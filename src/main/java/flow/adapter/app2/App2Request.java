package flow.adapter.app2;

import query.Request;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App2Request implements Request {

    String dummy ;

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }
}
