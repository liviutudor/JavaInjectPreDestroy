package liv.tudor;

import com.google.inject.AbstractModule;

/**
 * Created by ltudor on 3/16/17.
 */
public class PreDestroyTestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MyService.class);
    }

}
