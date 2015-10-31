package client;

import client.SampleClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import query.Request;
import query.Response;

/**
 * Created by mkhanwalkar on 7/26/15.
 */
public class ClientTester {



    public static void main(String[] args)  throws Exception {

        SampleClient client = SampleClient.getInstance();

        ObjectMapper mapper = new ObjectMapper();

        client.setHost("localhost");
        client.setPort(10025);


                Request request = new Request();
                Response response = client.send(request);
                System.out.println(mapper.writeValueAsString(response));


    }

}
