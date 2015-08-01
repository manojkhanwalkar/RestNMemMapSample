import client.SampleClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import query.Identifier;
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

            {

                Request relation = new Request();
                relation.setClientId("client2");
                relation.addIdentifier(new Identifier("SC", "CK3"));
                relation.addIdentifier(new Identifier("IP", "IP2"));
                Response response = client.send(relation);
                System.out.println(mapper.writeValueAsString(response));

            }

        {

            Request relation = new Request();
            relation.setClientId("client1");
            relation.addIdentifier(new Identifier("SC", "CK1"));
            relation.addIdentifier(new Identifier("IP", "IP1"));
            Response response = client.send(relation);
            System.out.println(mapper.writeValueAsString(response));

        }

        {

            Request relation = new Request();
            relation.setClientId("client2");
            relation.addIdentifier(new Identifier("SC", "CK1"));
            relation.addIdentifier(new Identifier("IP", "IP1"));
            Response response = client.send(relation);
            System.out.println(mapper.writeValueAsString(response));

        }



    }

}
