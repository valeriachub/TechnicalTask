package practicaltask.riseapps.com.practicaltask.storage.preferences;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.Map;
import java.util.Set;

public abstract class BasePreferences {
    private SharedPreferences.Editor getEditor() {
        return getSharedPreferences().edit();
    }

    protected abstract SharedPreferences getSharedPreferences();

    protected boolean contains(String key) {
        return getSharedPreferences().contains(key);
    }

    protected Map<String, ?> getAll() {
        return getSharedPreferences().getAll();
    }

    protected boolean getBoolean(@NonNull String key, boolean defaultValue) {
        return getSharedPreferences().getBoolean(key, defaultValue);
    }

    protected void putBoolean(@NonNull String key, boolean value) {
        getEditor().putBoolean(key, value).apply();
    }

    protected float getFloat(@NonNull String key, float defaultValue) {
        return getSharedPreferences().getFloat(key, defaultValue);
    }

    protected void putFloat(@NonNull String key, float value) {
        getEditor().putFloat(key, value).apply();
    }

    protected int getInt(@NonNull String key, int defaultValue) {
        return getSharedPreferences().getInt(key, defaultValue);
    }

    protected void putInt(@NonNull String key, int value) {
        getEditor().putInt(key, value).apply();
    }

    protected long getLong(@NonNull String key, long defaultValue) {
        return getSharedPreferences().getLong(key, defaultValue);
    }

    protected void putLong(@NonNull String key, long value) {
        getEditor().putLong(key, value).apply();
    }

    protected String getString(@NonNull String key, String defaultValue) {
        return getSharedPreferences().getString(key, defaultValue);
    }

    protected void putString(@NonNull String key, String value) {
        getEditor().putString(key, value).apply();
    }

    protected Set<String> getStringSet(@NonNull String key, Set<String> defaultValue) {
        return getSharedPreferences().getStringSet(key, defaultValue);
    }

    protected void putStringSet(@NonNull String key, Set<String> value) {
        getEditor().putStringSet(key, value).apply();
    }

    protected double getDouble(@NonNull String key, double defaultValue) {
        return Double.longBitsToDouble(getSharedPreferences()
                .getLong(key, Double.doubleToLongBits(defaultValue)));
    }

    protected void putDouble(@NonNull String key, double value) {
        getEditor().putLong(key, Double.doubleToRawLongBits(value)).apply();
    }

    protected void registerOnSharedPreferencesChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        getSharedPreferences().registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    protected void unregisterOnSharedPreferencesChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        getSharedPreferences().unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    protected void remove(@NonNull String key) {
        getEditor().remove(key).apply();
    }

    protected void clearAll() {
        getEditor().clear().apply();
    }
}