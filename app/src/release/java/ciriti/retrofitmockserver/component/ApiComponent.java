package ciriti.retrofitmockserver.component;

import javax.inject.Singleton;

import ciriti.retrofitmockserver.module.AppModule;
import ciriti.retrofitmockserver.module.ServiceModule;
import dagger.Component;

/**
 * Created by ciriti on 28/06/15.
 */
@Singleton
@Component(modules = {AppModule.class, SharedPrefModule.class, ServiceModule.class})
public interface ApiComponent extends ParentApiComponent{

}
