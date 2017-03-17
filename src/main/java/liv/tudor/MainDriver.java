package liv.tudor;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netflix.governator.InjectorBuilder;
import com.netflix.governator.LifecycleInjector;
import com.netflix.governator.LifecycleManager;
import com.netflix.governator.guice.LifecycleInjectorBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by ltudor on 3/16/17.
 */
public class MainDriver {
    public static void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        try {
            log("Starting program");

            log("Starting injection");
            // this is regular Guice
            //Injector injector = Guice.createInjector(new PreDestroyTestModule());
            // this is Governator
            Injector injector = InjectorBuilder.fromModule(new PreDestroyTestModule()).createInjector();
            LifecycleManager manager = injector.getInstance(LifecycleManager.class);
            log("Finished injection startup");

            log("Retrieving StartApp instance");
            StartApp app = injector.getInstance(StartApp.class);
            log("StartApp instance created");
            app.run();
            log("StartApp finished running");

            app = null;
            log("Suggesting GC");
            System.gc();
            log("Suggesting GC finished");
            TimeUnit.SECONDS.sleep(5);
            log("Wait finished");
        } catch (Throwable e) {
            e.printStackTrace();
        }

        log("Ending program");
    }
}
