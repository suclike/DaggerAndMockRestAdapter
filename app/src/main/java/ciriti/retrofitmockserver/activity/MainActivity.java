package ciriti.retrofitmockserver.activity;

import android.os.Bundle;

import ciriti.retrofitmockserver.R;
import ciriti.retrofitmockserver.fragment.FragUsers;

public class MainActivity extends BaseActivity /*implements SharedPreferences.OnSharedPreferenceChangeListener*/{


//    @InjectView(R.id.resp)
//    TextView responseTv;
//
//    @InjectView(R.id.switch1)
//    SwitchCompat switchCompat;
//
//    @InjectView(R.id.progressBar)
//    ProgressBar progressBar;
//
//    @Inject
//    ApiService apiService;
//
//    @Inject
//    SharedPreferences sharedPreferences;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, FragUsers.newInstance())
                    .commit();
        }
//        ButterKnife.inject(this);
//
//        ((App)getApplication()).getApiComponent().inject(this);
//
//        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
//
//        switchCompat.setChecked(sharedPreferences.getBoolean(ServiceModule.HAS_MOCK, false));
//        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(getApplicationContext(), "" + isChecked, Toast.LENGTH_SHORT).show();
//                responseTv.setText("");
//                sharedPreferences.edit().putBoolean(ServiceModule.HAS_MOCK, isChecked).commit();
//            }
//        });
    }
//
//    /**
//     * Service call using RxAndroid
//     * @param isMock
//     */
//    public void executeCallWithRxAndroid(boolean isMock) {
//        fetchUsers(isMock).subscribe(new Observer<RespBean>() {
//            @Override
//            public void onCompleted() {
//                Toast.makeText(getApplicationContext(), "Completed!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onNext(RespBean respBean) {
//                String json = new Gson().toJson(respBean);
//                responseTv.setText(json);
//            }
//        });
//
//    }
//
//    /**
//     * Service call using retrofit callback
//     */
//    public void executeCallWithRetrofitCallback() {
//
//        progressBar.setVisibility(View.VISIBLE);
//        responseTv.setText("");
//
//        apiService.getUsers(10, new Callback<RespBean>() {
//            @Override
//            public void success(RespBean respBean, Response response) {
//                String json = new Gson().toJson(respBean);
//                responseTv.setText(json);
//                progressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                progressBar.setVisibility(View.GONE);
//            }
//        });
//    }
//
//
//    private Observable<RespBean> fetchUsers(final boolean isMock) {
//        Observable<RespBean> observable = Observable
//                .create(new Observable.OnSubscribe<RespBean>() {
//                    @Override
//                    public void call(Subscriber<? super RespBean> subscriber) {
//                        try{
//                            subscriber.onNext(apiService.getUsers(10));
//                            subscriber.onCompleted();
//                        }catch (Exception e){
//                            subscriber.onError(e);
//                        }
//                    }
//                })
//                .subscribeOn(Schedulers.computation())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        return observable;
//    }
//
//    @OnClick(R.id.button)
//    public void click(){
//        responseTv.setText("");
//        executeCallWithRetrofitCallback();
//    }
//
//    @Override
//    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
//        ProcessPhoenix.triggerRebirth(getApplicationContext());
//    }
}
