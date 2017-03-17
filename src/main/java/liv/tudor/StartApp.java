package liv.tudor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

/**
 * Created by ltudor on 3/16/17.
 */
public class StartApp {
    private final MyService service;

    @Inject
    public StartApp(MyService service) {
        System.out.println("StartApp constructor");
        this.service = service;
        System.out.println("StartApp constructor finished");
    }

    @PostConstruct
    public void init() {
        System.out.println("StartApp PostConstruct");
    }

    public void run() {
        System.out.println("StartApp run start");
        service.doStuff();
        System.out.println("StartApp run end");
    }

    @PreDestroy
    public void deregister() {
        System.out.println("StartApp PreDestroy");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("StartApp finalize");
    }
}
