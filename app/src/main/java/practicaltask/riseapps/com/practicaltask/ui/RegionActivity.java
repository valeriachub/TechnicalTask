package practicaltask.riseapps.com.practicaltask.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.ui.adapter.CountryAdapter;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity;
import practicaltask.riseapps.com.practicaltask.ui.model.Country;
import practicaltask.riseapps.com.practicaltask.utils.Const;

public class RegionActivity extends BaseActivity implements RegionView {

    @BindView(R.id.content)
    LinearLayout content;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.text_no_internet)
    TextView noInternetView;

    private final RegionPresenter regionPresenter = new RegionPresenter(this);

    private Unbinder unbinder;
    private CountryAdapter countryAdapter;
    private String region;

    public static void start(Context context, String region) {
        Intent intent = new Intent(context, RegionActivity.class);
        intent.putExtra(Const.EXTRA_REGION, region);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_region);
        regionPresenter.setView(this);
        unbinder = ButterKnife.bind(this);

        getExtras();
        initUI();
    }

    private void getExtras() {
        Bundle args = getIntent().getExtras();
        if (args != null && args.containsKey(Const.EXTRA_REGION)) {
            region = args.getString(Const.EXTRA_REGION);
        }
    }

    private void initUI() {
        setActionBar();
        regionPresenter.checkInternetConnection(this);
    }

    private void setActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        setTitle(getString(R.string.region_countries));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }

        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        regionPresenter.setView(null);
        unbinder.unbind();
        regionPresenter.destroy();
    }

    @Override
    public void setCountries(List<Country> list) {
        List<Country> countries = list;
        if (countryAdapter == null) countryAdapter = new CountryAdapter(countries);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(countryAdapter);
    }

    @Override
    public void setInternetConnectionError() {
        Snackbar.make(content, getString(R.string.check_connection), Snackbar.LENGTH_INDEFINITE).show();
        noInternetView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setInternetConnectionSuccess() {
        noInternetView.setVisibility(View.GONE);
        if (region != null && !region.isEmpty()) {
            regionPresenter.getCountries(region);
        }
    }
}