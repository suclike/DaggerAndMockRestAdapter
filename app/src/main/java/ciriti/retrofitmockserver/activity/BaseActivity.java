package ciriti.retrofitmockserver.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ciriti.retrofitmockserver.R;

/**
 * Created by ciriti on 28/06/15.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
    }
}
