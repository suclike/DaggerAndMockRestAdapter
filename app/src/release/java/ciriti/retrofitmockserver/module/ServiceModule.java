package ciriti.retrofitmockserver.module;

import javax.inject.Singleton;

import ciriti.retrofitmockserver.api.ApiService;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;

/**
 * Created by ciriti on 28/06/15.
 */
@Singleton
@Module(includes = {ApiModule.class})
public class ServiceModule {

    public static final String URL_ENDPOINT = "https://api.stackexchange.com";

    @Provides
    Endpoint provideEndpoint(){
        return Endpoints.newFixedEndpoint(URL_ENDPOINT);
    }

    @Provides
    public ApiService provideStackExchangeService(RestAdapter restAdapter){
        return restAdapter.create(ApiService.class);
    }

}
