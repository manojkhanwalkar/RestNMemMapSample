package sample;

import query.IdCount;
import query.Request;
import query.Response;
import sample.persistence.PersistenceService;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Sample {

    private Sample()
    {

    }

    // first map is clientid , map .
    // second map is Identifier type , map
    // third map is identifier value , LocNCount .

   Map<String,Map<String,Map<String,CumNCount>>> clients = new ConcurrentHashMap<>();
    Map<String,Map<String,Map<String,LocNCount>>> newclients = new ConcurrentHashMap<>();

    // first map is client , map
    // second map is it type and cumualtive count for that type .

   Map<String,Map<String,Integer>> maxCount = new ConcurrentHashMap<>();

  /*
    public  void restore(String clientId, String idType, String id, int value, int location)
    {
        Map<String,Integer> clientCount = maxCount.get(clientId);
        if (clientCount==null) {
            clientCount = new HashMap<>();
            maxCount.put(clientId,clientCount );
        }

        Integer typeCount = clientCount.get(idType);
        if (typeCount==null) {
            typeCount = 0;
            clientCount.put(idType,typeCount);

        }

        clientCount.put(idType,typeCount+value);

    } */

    public void processCumulativeCount()
    {
        clients.values().stream().forEach(client->{

            client.values().stream().forEach(idType-> {


                List<CumNCount> list = idType.values().stream().sorted().collect(Collectors.toList());
                int cumCount = 0;
                for (CumNCount loc : list)
                {
                    cumCount = cumCount + loc.getCount();
                    loc.setCumulativeCount(cumCount);
                }

                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++") ;

            });

           // System.out.println(client);

        });
    }


  public  void restore(String clientId, String idType, String id, int value, int location)
    {
        Map<String,Map<String,CumNCount>> client = clients.get(clientId);
        if (client==null)
        {
            client = new HashMap<>();
            clients.put(clientId,client);
            maxCount.put(clientId,new HashMap<>());
        }

        Map<String,CumNCount> ids = client.get(idType);


        if (ids==null)
        {
            ids = new HashMap<>();
            client.put(idType,ids);
            maxCount.get(clientId).put(idType,0);
        }

        CumNCount locNCount  = ids.get(id);
        if (locNCount==null)
        {
            locNCount = new CumNCount(value);
            ids.put(id,locNCount);
        }
        else
        {
            locNCount.addCount(value);
            ids.put(id,locNCount);
        }

        Map<String,Integer> clientCount = maxCount.get(clientId);
        Integer typeCount = clientCount.get(idType);
        clientCount.put(idType,typeCount+value);


    }





    //TODO - Fat lock - needs to be optimized for better concurrency .

    public synchronized int incrementAndGetCount(String clientId, String idType, String id, int value)
    {
        Map<String,Map<String,LocNCount>> client = newclients.get(clientId);
        if (client==null)
        {
            client = new HashMap<>();
            newclients.put(clientId,client);
        }

        Map<String,Integer> clientCount = maxCount.get(clientId);
        if (clientCount==null) {
            clientCount = new HashMap<>();
            maxCount.put(clientId,clientCount );
        }


        Map<String,LocNCount> ids = client.get(idType);


        if (ids==null)
        {
            ids = new HashMap<>();
            client.put(idType, ids);
        }

        Integer typeCount = clientCount.get(idType);
        if (typeCount==null) {
            typeCount = 0;
            clientCount.put(idType,typeCount);

        }




        LocNCount locNCount  = ids.get(id);
        if (locNCount==null)
        {
            locNCount = new LocNCount(value,-1);
            ids.put(id,locNCount);
        }
        else
        {
            locNCount.addCount(value);
            ids.put(id,locNCount);
        }

       // Map<String,Integer> clientCount = maxCount.get(clientId);
       // Integer typeCount = clientCount.get(idType);
        clientCount.put(idType,typeCount+value);

            PersistenceService service = PersistenceService.getInstance();

            service.update(clientId, idType, id, locNCount);

        return locNCount.getCount();

    }


    public Response getScore(Request request) {
        Response response=new Response();
        response.setClientId(request.getClientId());
        request.getIdentifiers().stream().forEach(id->{

            int count = incrementAndGetCount(request.getClientId(), id.getType(), id.getValue(),1);
            int max =  getMaxCount(request.getClientId(), id.getType());
            int cumCount = getCumCount(request.getClientId(),id.getType(),id.getValue());

            IdCount score = new IdCount(id,(count+cumCount)*100/max);
            response.addScore(score);

        });

        return response;

    }

    private int getMaxCount(String clientId, String type) {
        return maxCount.get(clientId).get(type);
    }

    private int getCumCount(String clientId, String idType,String id) {

        Map<String,Map<String,CumNCount>> client = clients.get(clientId);
        if (client==null)
        {
            return 0;
        }

        Map<String,CumNCount> ids = client.get(idType);


        if (ids==null)
        {
            return 0;
        }

        CumNCount locNCount  = ids.get(id);
        if (locNCount==null)
        {
            return 0;
        }
        else
        {
            return locNCount.getCumulativeCount();
        }



    }



    static class Holder
    {
        static Sample factory = new Sample();
    }

    public static Sample getInstance()
    {
        return Holder.factory;

    }

    public void init()
    {
        PersistenceService service = PersistenceService.getInstance();
        service.restore();
        printState();
        processCumulativeCount();
    }

    public void close()
    {
        PersistenceService service = PersistenceService.getInstance();
        service.close();
        printState();

    }

    public void printState()
    {
        System.out.println(clients);
        System.out.println(newclients);
        System.out.println(maxCount);

    }





}
