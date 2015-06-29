package ciriti.retrofitmockserver.module;

import javax.inject.Singleton;

import ciriti.retrofitmockserver.App;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ciriti on 29/06/15.
 */
@Module
@Singleton
public class AppModule {

    App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public App provideApplication(){
        return  app;
    }
}
