package com.activity.mobcom.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.activity.mobcom.Activity.Activities.Calculator;
import com.activity.mobcom.Activity.Activities.LoginActivity;
import com.activity.mobcom.Activity.Activities.RegForm;
import com.activity.mobcom.Activity.Activities.WelcomeMsg;
import com.activity.mobcom.Domain.ActivitiesDomain;
import com.activity.mobcom.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.Viewholder> {
    ArrayList<ActivitiesDomain> items;
    Context context;

    public ActivitiesAdapter(ArrayList<ActivitiesDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflator = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_list, parent, false);
        context = parent.getContext();
        return new Viewholder(inflator);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(items.get(position).getTitle());

        int drawableResourceId = holder.itemView.getResources()
                        .getIdentifier(items.get(position).getPicPath(), "drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);

        holder.layout.setBackgroundResource(R.drawable.list_background);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(context, WelcomeMsg.class);
                        break;
                    case 1:
                        intent = new Intent(context, RegForm.class);
                        break;
                    case 2:
                        intent = new Intent(context, LoginActivity.class);
                        break;
                    case 3:
                        intent = new Intent(context, Calculator.class);
                        break;
                    case 4:
                        //intent = new Intent(context, Activity.class);
                        break;
                    default:
                        return;
                }
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView pic, background_img;
        ConstraintLayout layout;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            layout = itemView.findViewById(R.id.mail_layout);
        }
    }
};