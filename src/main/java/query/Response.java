package query;


import java.util.ArrayList;
import java.util.List;

public class Response {

    String clientId ;

    List<IdCount> scores = new ArrayList<>();

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<IdCount> getScores() {
        return scores;
    }

    public void setScores(List<IdCount> scores) {
        this.scores = scores;
    }

    public void addScore(IdCount score)
    {
        scores.add(score);
    }
}
