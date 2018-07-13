package practicaltask.riseapps.com.practicaltask.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import practicaltask.riseapps.com.practicaltask.data.Client;
import practicaltask.riseapps.com.practicaltask.data.model.Country;
import practicaltask.riseapps.com.practicaltask.ui.base.BasePresenter;

public class RegionPresenter extends BasePresenter<RegionView> {

    private RegionView regionView;
    private CompositeDisposable compositeDisposable;

    public RegionPresenter(RegionView regionView) {
        this.regionView = regionView;
        compositeDisposable = new CompositeDisposable();
    }

    public void getCountries(String region) {
        Disposable disposable = Client.getAPI().loadCountries(region.toLowerCase())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                            if (result != null && result.size() > 0) {
                                prepareCountryList(result);
                            }
                        },
                        throwable -> {
                            regionView.setInternetConnectionError();
                            throwable.printStackTrace();
                        });

        compositeDisposable.add(disposable);
    }

    private void prepareCountryList(List<Country> list) {
        List<practicaltask.riseapps.com.practicaltask.ui.model.Country> countries = new ArrayList<>(list.size());
        for (Country country : list) {
            countries.add(new practicaltask.riseapps.com.practicaltask.ui.model.Country(country.name, country.capital));
        }
        regionView.setCountries(countries);
    }

    public void checkInternetConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            regionView.setInternetConnectionSuccess();
        } else {
            regionView.setInternetConnectionError();
        }
    }

    public void destroy() {
        compositeDisposable.dispose();
    }
}
