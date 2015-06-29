package ciriti.retrofitmockserver.module;

import android.util.Log;

import com.jakewharton.byteunits.DecimalByteUnit;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import javax.inject.Singleton;

import ciriti.retrofitmockserver.App;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by ciriti on 28/06/15.
 */
@Module
@Singleton
public class ApiModule {

    static final int DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB

    @Singleton
    @Provides
    public RestAdapter provideRestAdapter(OkHttpClient okHttpClient, Endpoint endpoint){
        Log.i("", "");
        return new RestAdapter.Builder()
                .setClient(new OkClient(okHttpClient))
                .setEndpoint(endpoint)
                .build();
    }

    /**
     *
     * OkHttp supports the SPDY protocol. SPDY is the basis for HTTP 2.0 and allows multiple HTTP requests
     * to be multiplexed over one socket connection.
     *
     * https://it.wikipedia.org/wiki/SPDY
     * @return
     */
    @Singleton
    @Provides
    OkHttpClient provideClient(App app){

        OkHttpClient client = new OkHttpClient();

        client.setConnectTimeout(10, SECONDS);
        client.setReadTimeout(10, SECONDS);
        client.setWriteTimeout(10, SECONDS);

        // Install an HTTP cache in the application cache directory.
        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = null;
        try{
            cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(cache != null)
        client.setCache(cache);

        return client;
    }

}
