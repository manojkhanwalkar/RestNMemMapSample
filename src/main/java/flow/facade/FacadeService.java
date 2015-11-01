package flow.facade;

import flow.adapter.Adapter;
import flow.adapter.AdapterManager;
import flow.transform.Transform;
import flow.transform.TransformManager;
import flow.transport.Transport;
import flow.transport.TransportManager;
import flow.workflow.Workflow;
import flow.workflow.WorkflowManager;
import server.Service;

import java.util.List;

public class FacadeService implements Service {



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

            WorkflowManager manager = WorkflowManager.getInstance();

            workflows.forEach((l)->{
                manager.register(l.getKey(), l);

            });

           AdapterManager adaptermanager = AdapterManager.getInstance();

            adapters.forEach((l) -> {
                adaptermanager.register(l.getKey(), l);
            });

            TransformManager transformManager = TransformManager.getInstance();

            transforms.forEach((l)->{
                transformManager.register(l.getKey(),l);
            });

            TransportManager transportManager = TransportManager.getInstance();
            transports.forEach((l)->{

                transportManager.register(l.getKey(),l);
            });


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


    List<Workflow> workflows;

    public List<Workflow> getWorkflows() {
        return workflows;
    }

    public void setWorkflows(List<Workflow> workflows) {
        this.workflows = workflows;
    }

    List<Adapter> adapters;

    public List<Adapter> getAdapters() {
        return adapters;
    }

    public void setAdapters(List<Adapter> adapters) {
        this.adapters = adapters;
    }

    List<Transform> transforms ;

    public List<Transform> getTransforms() {
        return transforms;
    }

    public void setTransforms(List<Transform> transforms) {
        this.transforms = transforms;
    }

    List<Transport> transports;

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }
}
