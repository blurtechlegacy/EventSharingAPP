package com.syberianguys.srggrch.eventsgaring.features.Events.add.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syberianguys.srggrch.eventsgaring.R;

import java.util.ArrayList;

public final class AdapterTag extends RecyclerView.Adapter<AdapterTag.ViewHolder>{
    ArrayList<String> tags;

    public AdapterTag(ArrayList<String> tags) {
        this.tags = tags;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tagView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_tag,parent,false);
        ViewHolder tagViewHolder = new ViewHolder(tagView);
        return tagViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tagText.setText(tags.get(position));
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tagText;
        public ViewHolder(View itemView) {
            super(itemView);
            tagText = itemView.findViewById(R.id.item_text);
        }
    }
}
