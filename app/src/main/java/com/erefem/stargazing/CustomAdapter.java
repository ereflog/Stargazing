package com.erefem.stargazing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<MyModel> list;

    public CustomAdapter(Context context, List<MyModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_log_book,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_object_name.setText(list.get(position).getObject_name());
        holder.tv_observer.setText(list.get(position).getObserver());
        holder.tv_coordinate.setText(list.get(position).getCoordinate());
        holder.tv_date.setText(list.get(position).getDate());
        holder.tv_time.setText(list.get(position).getTime());
        holder.tv_seeing.setText(list.get(position).getSeeing());
        holder.tv_instrument.setText(list.get(position).getInstrument());
        holder.tv_magnification.setText(list.get(position).getMagnification());
        holder.tv_filter.setText(list.get(position).getFilter());
        holder.tv_description_object.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
