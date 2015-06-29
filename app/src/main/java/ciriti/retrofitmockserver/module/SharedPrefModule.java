package ciriti.retrofitmockserver.module;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import ciriti.retrofitmockserver.App;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ciriti on 28/06/15.
 */
@Module
@Singleton
public class SharedPrefModule {

    public static final String SHARED_P_NAME = "damr";


    @Provides
    public SharedPreferences providePreferences(App app){
        return app.getSharedPreferences(SHARED_P_NAME, Context.MODE_PRIVATE);
    }

}
