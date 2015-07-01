package ciriti.retrofitmockserver.component;

import javax.inject.Singleton;

import ciriti.retrofitmockserver.module.AppModule;
import ciriti.retrofitmockserver.module.ServiceModule;
import ciriti.retrofitmockserver.module.SharedPrefModule;
import dagger.Component;

/**
 * Created by carmelo.iriti on 01/07/2015.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        SharedPrefModule.class,
        ServiceModule.class
}
)
public interface ApplicationComponent  extends ParentApiComponent{
}

