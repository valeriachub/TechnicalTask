package practicaltask.riseapps.com.practicaltask.storage.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferencesImpl extends BasePreferences implements Preferences {
    private interface Keys {
    }

    private interface DefaultValues {
    }

    private SharedPreferences sharedPreferences;

    public PreferencesImpl(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    protected SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    @Override
    public void test() {
    }
}