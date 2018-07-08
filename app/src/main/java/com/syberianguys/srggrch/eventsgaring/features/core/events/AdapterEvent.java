package com.syberianguys.srggrch.eventsgaring.features.core.events;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;

import java.util.ArrayList;

public class AdapterEvent extends RecyclerView.Adapter<AdapterEvent.ViewHolder> {

    ArrayList<Event> events;

    public AdapterEvent (ArrayList<Event> Events){
        this.events = Events;
    }

    @NonNull
    @Override
    public AdapterEvent.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEvent.ViewHolder holder, int position) {
        holder.eventName.setText(events.get(position).getName());
//        holder.eventHost.setText(events.get(position).getHost());
        holder.shortDesription.setText(events.get(position).getDescription());
        holder.eventDate.setText(events.get(position).getStart());
        holder.eventMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // something happening
            }
        });

    }

    @Override
    public int getItemCount() {
        return events.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eventName;
        public TextView eventHost;
        public TextView shortDesription;
        public TextView eventDate;
        public Button eventMore;

        public ViewHolder(View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.item_element_textView_eventName);
            eventDate = itemView.findViewById(R.id.item_element_textView_eventDate);
            eventHost = itemView.findViewById(R.id.item_element_textView_eventHost);
            shortDesription = itemView.findViewById(R.id.item_element_textView_shortDescription);
            eventMore = itemView.findViewById(R.id.item_element_eventMore);
        }
    }
}
