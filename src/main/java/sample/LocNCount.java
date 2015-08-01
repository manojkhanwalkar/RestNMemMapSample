package sample;

/**
 * Created by mkhanwalkar on 7/30/15.
 */
public class LocNCount implements Comparable<LocNCount>{

    public static final int INVALID_LOCATION = -1;

    int count ;
    int location = -1;


    @Override
    public String toString() {
        return "LocNCount{" +
                "count=" + count +
                ", location=" + location +
                '}';
    }

    @Override
    public int compareTo(LocNCount o) {
        return o.count- this.count;
    }


    public LocNCount(int count , int location)
    {
        this.count=count;
        this.location = location ;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void addCount(int value) {
        count+=value;
    }
}
