package practicaltask.riseapps.com.practicaltask.ui;

import java.util.List;

import practicaltask.riseapps.com.practicaltask.ui.base.BaseView;
import practicaltask.riseapps.com.practicaltask.ui.model.Country;

public interface RegionView extends BaseView {

    void setCountries(List<Country> list);

    void setInternetConnectionError();

    void setInternetConnectionSuccess();
}
