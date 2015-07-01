package ciriti.retrofitmockserver.activity;

import android.os.Bundle;

import ciriti.retrofitmockserver.R;
import ciriti.retrofitmockserver.fragment.FragUsers;

public class MainActivity extends BaseActivity /*implements SharedPreferences.OnSharedPreferenceChangeListener*/{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, FragUsers.newInstance())
                    .commit();
        }
    }
}
