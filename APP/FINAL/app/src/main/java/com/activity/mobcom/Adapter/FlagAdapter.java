package com.activity.mobcom.Adapter;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.activity.mobcom.Domain.FlagDomain;
import com.activity.mobcom.R;
import java.util.List;

public class FlagAdapter extends RecyclerView.Adapter<FlagAdapter.ViewHolder> {

    private List<FlagDomain> countries;
    private Context context;

    public FlagAdapter(Context context, List<FlagDomain> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FlagDomain country = countries.get(position);
        holder.countryName.setText(country.getName());
        holder.countryFlag.setImageResource(country.getFlagResId());

        holder.countryFlag.setOnClickListener(v -> showFlagPopup(country.getFlagResId()));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        ImageView countryFlag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.country_name);
            countryFlag = itemView.findViewById(R.id.country_flag);
        }
    }

    private void showFlagPopup(int flagResId) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.show_dialogflag);
        ImageView flagImage = dialog.findViewById(R.id.dialog_flag_image);
        flagImage.setImageResource(flagResId);
        dialog.show();
    }
}
