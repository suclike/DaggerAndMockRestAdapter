package ciriti.retrofitmockserver.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import ciriti.retrofitmockserver.App;
import ciriti.retrofitmockserver.R;
import ciriti.retrofitmockserver.api.ApiService;
import ciriti.retrofitmockserver.bean.RespBean;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.Intent.ACTION_MAIN;
import static android.content.Intent.CATEGORY_LAUNCHER;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class MainActivity extends BaseActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    @InjectView(R.id.resp)
    TextView responseTv;

    @Inject
    ApiService apiService;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        ((App)getApplication()).getApiComponent().inject(this);

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        executeCallWithRetrofitCallback();
    }

    /**
     * Service call using RxAndroid
     * @param isMock
     */
    public void executeCallWithRxAndroid(boolean isMock) {
        fetchUsers(isMock).subscribe(new Observer<RespBean>() {
            @Override
            public void onCompleted() {
                Toast.makeText(getApplicationContext(), "Completed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(RespBean respBean) {
                String json = new Gson().toJson(respBean);
                responseTv.setText(json);
            }
        });

    }

    /**
     * Service call using retrofit callback
     */
    public void executeCallWithRetrofitCallback() {

        apiService.getUsers(10, new Callback<RespBean>() {
            @Override
            public void success(RespBean respBean, Response response) {
                String json = new Gson().toJson(respBean);
                responseTv.setText(json);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    private Observable<RespBean> fetchUsers(final boolean isMock) {
        Observable<RespBean> observable = Observable
                .create(new Observable.OnSubscribe<RespBean>() {
                    @Override
                    public void call(Subscriber<? super RespBean> subscriber) {
                        try{
                            subscriber.onNext(apiService.getUsers(10));
                            subscriber.onCompleted();
                        }catch (Exception e){
                            subscriber.onError(e);
                        }
                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());

        return observable;
    }

    @OnClick(R.id.button)
    public void click(){
        responseTv.setText("");
        executeCallWithRetrofitCallback();
    }

    public static void restartApp(Context context){
        Intent defaultIntent = new Intent(ACTION_MAIN);
        defaultIntent.addFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK);
        defaultIntent.addCategory(CATEGORY_LAUNCHER);
        defaultIntent.setComponent(new ComponentName(context.getPackageName(), MainActivity.class.getName()));

        Runtime.getRuntime().exit(0);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }
}
