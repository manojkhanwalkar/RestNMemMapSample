package query;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class Envelope {

    String cliendId;
    long requestId;
    String requestType;
    String version ;
    String hmac;

    public String getCliendId() {
        return cliendId;
    }

    public void setCliendId(String cliendId) {
        this.cliendId = cliendId;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "cliendId='" + cliendId + '\'' +
                ", requestId=" + requestId +
                ", requestType='" + requestType + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public void setHmac(String hmac) {
        this.hmac = hmac;
    }

    public String getHmac() {
        return hmac;
    }
}
