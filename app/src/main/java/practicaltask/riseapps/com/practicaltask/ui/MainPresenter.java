package practicaltask.riseapps.com.practicaltask.ui;

import java.util.ArrayList;
import java.util.List;

import practicaltask.riseapps.com.practicaltask.ui.base.BasePresenter;
import practicaltask.riseapps.com.practicaltask.ui.model.Region;

public class MainPresenter extends BasePresenter<MainView> {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void getRegions() {
        List<Region> regions = new ArrayList<>();
        regions.add(new Region(1, "Africa"));
        regions.add(new Region(2, "Americas"));
        regions.add(new Region(3, "Asia"));
        regions.add(new Region(4, "Europe"));
        regions.add(new Region(5, "Oceania"));

        mainView.setRegions(regions);
    }
}
