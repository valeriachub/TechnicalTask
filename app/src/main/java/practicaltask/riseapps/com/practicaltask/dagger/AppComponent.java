package practicaltask.riseapps.com.practicaltask.dagger;

import dagger.Component;
import practicaltask.riseapps.com.practicaltask.dagger.module.AppModule;
import practicaltask.riseapps.com.practicaltask.dagger.module.GlobalModule;
import practicaltask.riseapps.com.practicaltask.dagger.module.NetworkModule;

@PerApp
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        GlobalModule.class
})
public interface AppComponent {
}