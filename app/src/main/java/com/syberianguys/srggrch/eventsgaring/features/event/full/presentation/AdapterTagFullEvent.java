package com.syberianguys.srggrch.eventsgaring.features.event.full.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.Tag;

import java.util.ArrayList;
import java.util.List;

public final class AdapterTagFullEvent extends RecyclerView.Adapter<AdapterTagFullEvent.ViewHolder> {
    private final ArrayList<Tag> tags;

    public AdapterTagFullEvent(ArrayList<Tag> tags) {
        this.tags = tags;
    }


    public void setTags(List<Tag> tagsList){
        //tags.clear();
        if(tagsList != null) tags.addAll(tagsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tagView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_tag, parent, false);
        return new ViewHolder(tagView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(tags.get(position));
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

        void bind(final Tag tag) {
            tagText.setText(tag.getName());
        }
    }
}
