package practicaltask.riseapps.com.practicaltask.dagger.module;

import dagger.Module;
import dagger.Provides;
import practicaltask.riseapps.com.practicaltask.PracticalTaskApp;
import practicaltask.riseapps.com.practicaltask.dagger.PerApp;

@Module
public class AppModule {
    private PracticalTaskApp practicalTaskApp;

    public AppModule(PracticalTaskApp practicalTaskApp) {
        this.practicalTaskApp = practicalTaskApp;
    }

    @Provides
    @PerApp
    PracticalTaskApp providePracticalTaskApp() {
        return practicalTaskApp;
    }
}