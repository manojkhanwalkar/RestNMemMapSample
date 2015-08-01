package sample;

/**
 * Created by mkhanwalkar on 7/30/15.
 */
public class CumNCount implements Comparable<CumNCount>{

    public static final int INVALID_LOCATION = -1;

    int count ;
    int cumulativeCount;

    @Override
    public String toString() {
        return "CumNCount{" +
                "count=" + count +
                ", cumulativeCount=" + cumulativeCount +
                '}';
    }

    @Override
    public int compareTo(CumNCount o) {
        return o.count- this.count;
    }

    public int getCumulativeCount() {
        return cumulativeCount;
    }

    public void setCumulativeCount(int cumulativeCount) {
        this.cumulativeCount = cumulativeCount;
    }

    public CumNCount(int count)
    {
        this.count=count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public void addCount(int value) {
        count+=value;
    }
}
