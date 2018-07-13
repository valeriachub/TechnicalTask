package practicaltask.riseapps.com.practicaltask.ui;


import android.os.Handler;

import practicaltask.riseapps.com.practicaltask.ui.base.BasePresenter;

public class SplashPresenter extends BasePresenter<SplashView> {

    private SplashView splashView;

    public  SplashPresenter(SplashView splashView) {
        this.splashView = splashView;
    }

    public void startMainActivity() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            splashView.showMainActivity();
        }, 2000);
    }
}