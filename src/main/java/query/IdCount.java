package query;

/**
 * Created by mkhanwalkar on 7/30/15.
 */
public class IdCount {

    Identifier identifier;
    int score ;

    public IdCount()
    {

    }

    public IdCount(Identifier identifier, int score) {
        this.identifier = identifier;
        this.score = score;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
