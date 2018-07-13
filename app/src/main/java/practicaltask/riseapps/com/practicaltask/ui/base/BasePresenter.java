package practicaltask.riseapps.com.practicaltask.ui.base;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseView> {
    @Nullable
    private WeakReference<V> viewWeakReference;

    protected void onViewAttached() {
    }

    protected void onViewDetached() {
    }

    public final void setView(@Nullable V view) {
        if (view != null) {
            viewWeakReference = new WeakReference<>(view);
            onViewAttached();
        } else {
            if (viewWeakReference != null && viewWeakReference.get() != null) {
                viewWeakReference.clear();
            }
            viewWeakReference = null;
            onViewDetached();
        }
    }

    @Nullable
    @CheckResult
    protected V getView() {
        if (viewWeakReference != null) {
            return viewWeakReference.get();
        } else {
            return null;
        }
    }
}