package com.erefem.stargazing;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_object_name,tv_observer,tv_coordinate,tv_date,tv_time,tv_seeing,tv_instrument,tv_magnification,tv_filter,tv_description_object;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_object_name = itemView.findViewById(R.id.tv_object_name);
        tv_observer = itemView.findViewById(R.id.tv_observer);
        tv_coordinate = itemView.findViewById(R.id.tv_coordinate);
        tv_date = itemView.findViewById(R.id.tv_date);
        tv_time = itemView.findViewById(R.id.tv_time);
        tv_seeing = itemView.findViewById(R.id.tv_seeing);
        tv_instrument = itemView.findViewById(R.id.tv_instrument);
        tv_magnification = itemView.findViewById(R.id.tv_magnification);
        tv_filter = itemView.findViewById(R.id.tv_filter);
        tv_description_object = itemView.findViewById(R.id.tv_description_object);
    }
}
