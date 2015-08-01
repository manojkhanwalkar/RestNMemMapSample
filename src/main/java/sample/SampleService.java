package sample;

import server.Service;

public class SampleService implements Service {



    String name ;



    @Override
    public void init() {



        Sample sample = Sample.getInstance();

        sample.init();

        sample.incrementAndGetCount("client1","SC","CK2",100);

        System.out.println("Restoring files and building stats ");

    }





    @Override
    public void destroy() {
        Sample sample = Sample.getInstance();

        sample.close();


    }

    @Override
    public void setName(String s) {

        name = s;

    }

    @Override
    public String getName() {
        return name;
    }
}
