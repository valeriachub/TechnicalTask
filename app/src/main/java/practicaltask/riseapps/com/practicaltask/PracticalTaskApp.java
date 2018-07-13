package practicaltask.riseapps.com.practicaltask;

import android.app.Application;

import practicaltask.riseapps.com.practicaltask.dagger.AppComponent;
import practicaltask.riseapps.com.practicaltask.dagger.DaggerAppComponent;
import practicaltask.riseapps.com.practicaltask.dagger.module.AppModule;
import practicaltask.riseapps.com.practicaltask.dagger.module.GlobalModule;
import practicaltask.riseapps.com.practicaltask.dagger.module.NetworkModule;

public class PracticalTaskApp extends Application {
    private static PracticalTaskApp instance;
    private AppComponent appComponent;

    public static PracticalTaskApp getInstance() {
        return instance;
    }

    public AppComponent getApplicationComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initializeDagger();
    }

    private void initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .globalModule(new GlobalModule())
                .build();
    }
}