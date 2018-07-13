package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;

import java.util.ArrayList;
import java.util.List;

public final class AdapterTag extends RecyclerView.Adapter<AdapterTag.ViewHolder> {
    private final ArrayList<Tag> tags=new ArrayList<>();
    private final TagListerner tagListerner;

    public AdapterTag( TagListerner tagListerner) {

        this.tagListerner = tagListerner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tagView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_tag, parent, false);
        ViewHolder tagViewHolder = new ViewHolder(tagView);
        return tagViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(tags.get(position));
    }
    public void setEvents(List<Tag> t){
        tags.clear();
        if(t != null)        tags.addAll(t);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return tags.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tagText;
        public CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            tagText = itemView.findViewById(R.id.item_text);
            cardView = itemView.findViewById(R.id.card_tag);
        }

        void bind(final Tag tag) {
            tagText.setText(tag.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tagListerner.onTagSelected(tag.getId());
                    if(!tag.isTagSelected()) {
                        cardView.setBackgroundColor(Color.parseColor("#ffb74d"));
                        tag.setTagSelected(true);
                    }
                    else{
                        cardView.setBackgroundColor(Color.WHITE);
                        tag.setTagSelected(false);
                    }
                }
            });

        }
    }

    public interface TagListerner {
        void onTagSelected(String tagText);
    }
}
