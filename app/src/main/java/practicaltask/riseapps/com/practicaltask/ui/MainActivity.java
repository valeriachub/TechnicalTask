package practicaltask.riseapps.com.practicaltask.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.ui.adapter.RegionAdapter;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity;
import practicaltask.riseapps.com.practicaltask.ui.callback.RegionCallback;
import practicaltask.riseapps.com.practicaltask.ui.model.Region;

public class MainActivity extends BaseActivity implements MainView, RegionCallback {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private final MainPresenter mainPresenter = new MainPresenter(this);

    private Unbinder unbinder;
    private RegionAdapter regionAdapter;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        mainPresenter.setView(this);
        unbinder = ButterKnife.bind(this);

        initUI();
    }

    private void initUI() {
        setActionBar();
        mainPresenter.getRegions();
    }

    private void setActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        setTitle(getString(R.string.main));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.setView(null);
        unbinder.unbind();
    }

    @Override
    public void setRegions(List<Region> list) {
        List<Region> regions = list;
        if (regionAdapter == null) regionAdapter = new RegionAdapter(this, regions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(regionAdapter);
    }

    @Override
    public void onRegionClicked(Region region) {
        RegionActivity.start(this, region.getTitle());
    }
}