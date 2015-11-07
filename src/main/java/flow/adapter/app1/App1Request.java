package flow.adapter.app1;

import query.Request;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class App1Request implements Request {

    String dummy ;

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }

    @Override
    public String toString() {
        return "App1Request{" +
                "dummy='" + dummy + '\'' +
                '}';
    }
}
