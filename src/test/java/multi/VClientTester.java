package multi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by mkhanwalkar on 10/11/15.
 */
public class VClientTester {

    public static void main(String[] args) throws Exception {

        final VClient client = VClientFactory.getInstance().getVClient("tester");
        ExecutorService service = Executors.newFixedThreadPool(10);


        for (int i=0;i<100;i++) {
            service.submit(() -> {

                client.send("Hello World from " + Thread.currentThread().getName());
                System.out.println(client.recv());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

        service.shutdown();
        service.awaitTermination(10, TimeUnit.DAYS);

    }

}
