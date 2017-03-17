package liv.tudor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ltudor on 3/16/17.
 */
public class MyService {
    public MyService() {
        System.out.println("MyService constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("MyService PostConstruct");
    }

    public void doStuff() {
        System.out.println("MyService.doStuff");
    }

    @PreDestroy
    public void deregister() {
        System.out.println("MyService PreDestroy");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("MyService finalize");
    }
}
