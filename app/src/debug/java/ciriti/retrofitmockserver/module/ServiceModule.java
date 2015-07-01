package ciriti.retrofitmockserver.module;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import ciriti.retrofitmockserver.api.ApiService;
import ciriti.retrofitmockserver.api.MockService;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

/**
 * Created by ciriti on 28/06/15.
 */
@Module(includes = {ApiModule.class})
public class ServiceModule {

    public static final String URL_ENDPOINT = "https://api.stackexchange.com";

    public static final String HAS_MOCK = "has_mock";

    @Provides
    Endpoint provideEndpoint(){
        return Endpoints.newFixedEndpoint(URL_ENDPOINT);
    }

    @Singleton
    @Provides
    public ApiService provideStackExchangeService(RestAdapter restAdapter, SharedPreferences sharedPreferences, MockRestAdapter mockRestAdapter){
        if(sharedPreferences.getBoolean(HAS_MOCK, false)){
            return mockRestAdapter.create(ApiService.class, new MockService());
        }
        return restAdapter.create(ApiService.class);
    }

    @Provides
    MockRestAdapter provideMockRestAdapter(RestAdapter restAdapter){
        return MockRestAdapter.from(restAdapter);
    }

}
