package ciriti.retrofitmockserver;

import android.app.Application;

import ciriti.retrofitmockserver.component.DaggerApplicationComponent;
import ciriti.retrofitmockserver.component.ParentApiComponent;
import ciriti.retrofitmockserver.module.AppModule;

/**
 * Created by ciriti on 28/06/15.
 */
public class App extends Application {

    ParentApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        apiComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public ParentApiComponent getApiComponent() {
        return apiComponent;
    }

    public void setApiComponent(ParentApiComponent apiComponent) {
        this.apiComponent = apiComponent;
    }
}
