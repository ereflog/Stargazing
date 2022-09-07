package com.erefem.stargazing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erefem.stargazing.R;
import com.erefem.stargazing.database.entitas.Logbook;

import java.util.List;

public class LogbookAdapter extends RecyclerView.Adapter<LogbookAdapter.ViewAdapter> {
    private List<Logbook> list;
    private Context context;
    private Dialog dialog;

    public interface Dialog {
        void onClick(int position);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public LogbookAdapter(Context context, List<Logbook> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_log_book, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.object.setText(list.get(position).object);
        holder.observer.setText(list.get(position).observer);
        //holder.latitude.setText(String.valueOf(position));
        //holder.longitude.setText(String.valueOf(position));
        holder.longitude.setText(list.get(position).longitude);
        holder.latitude.setText((list.get(position).latitude));
        holder.date.setText(list.get(position).date);
        holder.time.setText(list.get(position).time);
        holder.seeing.setText(list.get(position).seeing);
        holder.instrument.setText(list.get(position).instrument);
        holder.magnification.setText(list.get(position).magnification);
        holder.filter.setText(list.get(position).filter);
        holder.comment.setText(list.get(position).comment);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView object, observer, longitude, latitude, date, time, seeing, instrument, magnification, filter, comment;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            object = itemView.findViewById(R.id.tv_object_name);
            observer = itemView.findViewById(R.id.tv_observer);
            longitude = itemView.findViewById(R.id.tv_longitude);
            latitude = itemView.findViewById(R.id.tv_latitude);
            date = itemView.findViewById(R.id.tv_date);
            time = itemView.findViewById(R.id.tv_time);
            seeing = itemView.findViewById(R.id.tv_seeing);
            instrument = itemView.findViewById(R.id.tv_instrument);
            magnification = itemView.findViewById(R.id.tv_magnification);
            filter = itemView.findViewById(R.id.tv_filter);
            comment = itemView.findViewById(R.id.tv_description_object);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}
