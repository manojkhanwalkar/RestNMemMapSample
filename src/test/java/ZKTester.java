import org.apache.zookeeper.*;

/**
 * Created by mkhanwalkar on 10/4/15.
 */
public class ZKTester implements Watcher {


    public void test() throws Exception
    {
        ZooKeeper zk = new ZooKeeper("localhost:2181",10000, this);

        zk.create("/new_znode", "new znode".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        Thread.sleep(10000);

    }

    public static void main(String[] args) throws Exception {

        ZKTester test = new ZKTester();

        test.test();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }
}
