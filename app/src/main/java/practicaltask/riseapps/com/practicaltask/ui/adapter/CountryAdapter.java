package practicaltask.riseapps.com.practicaltask.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.ui.model.Country;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private Context context;
    private List<Country> countries;

    public CountryAdapter(List<Country> list) {
        this.countries = list;
    }

    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.li_country, parent, false);
        return new CountryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryAdapter.ViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.titleView.setText(country.getTitle());
        holder.capitalView.setText(country.getCapital());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_country)
        TextView titleView;
        @BindView(R.id.text_capital)
        TextView capitalView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
