package practicaltask.riseapps.com.practicaltask.ui;

import android.os.Bundle;
import android.widget.ProgressBar;

import butterknife.BindView;
import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity;

public class SplashActivity extends BaseActivity implements SplashView {
    private final SplashPresenter splashPresenter = new SplashPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_splash);
        splashPresenter.setView(this);

        splashPresenter.startMainActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.setView(null);
    }

    @Override
    public void showMainActivity() {
        MainActivity.start(this);
        finish();
    }
}