package flow.app2;

import server.Service;

public class App2Service implements Service {



    String name ;

    String restConfigName;

    public String getRestConfigName() {
        return restConfigName;
    }

    public void setRestConfigName(String restConfigName) {
        this.restConfigName = restConfigName;
    }

    @Override
    public void init() {

        try {
            new SampleApplication().run("server", restConfigName);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void destroy() {




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
