package practicaltask.riseapps.com.practicaltask.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.ui.callback.RegionCallback;
import practicaltask.riseapps.com.practicaltask.ui.model.Region;

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.ViewHolder> {

    private Context context;
    private List<Region> regions;
    private RegionCallback callback;

    public RegionAdapter(RegionCallback callback, List<Region> list) {
        this.callback = callback;
        this.regions = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.li_region, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String region = regions.get(position).getTitle();
        holder.titleView.setText(region);
    }

    @Override
    public int getItemCount() {
        return regions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item)
        LinearLayout itemView;
        @BindView(R.id.text_title)
        TextView titleView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item)
        void onItemClicked() {
            if (callback != null) {
                callback.onRegionClicked(regions.get(getAdapterPosition()));
            }
        }
    }
}
