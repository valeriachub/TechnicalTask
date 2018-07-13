package practicaltask.riseapps.com.practicaltask.dagger.module;

import dagger.Module;
import dagger.Provides;
import practicaltask.riseapps.com.practicaltask.PracticalTaskApp;
import practicaltask.riseapps.com.practicaltask.dagger.PerApp;
import practicaltask.riseapps.com.practicaltask.storage.preferences.Preferences;
import practicaltask.riseapps.com.practicaltask.storage.preferences.PreferencesImpl;

@Module
public class GlobalModule {
    @Provides
    @PerApp
    Preferences providePreferencesImpl(PracticalTaskApp practicalTaskApp) {
        return new PreferencesImpl(practicalTaskApp);
    }
}