package practicaltask.riseapps.com.practicaltask.ui;

import java.util.List;

import practicaltask.riseapps.com.practicaltask.ui.base.BaseView;
import practicaltask.riseapps.com.practicaltask.ui.model.Region;

public interface MainView extends BaseView {

    void setRegions(List<Region> list);
}