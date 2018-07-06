package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syberianguys.srggrch.eventsgaring.R;

import java.util.ArrayList;

public final class AdapterTag extends RecyclerView.Adapter<AdapterTag.ViewHolder> {
    private final ArrayList<String> tags;
    private final TagListerner tagListerner;

    public AdapterTag(ArrayList<String> tags, TagListerner tagListerner) {
        this.tags = tags;
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
        holder.bind(tags.get(position),position);
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

        void bind(final String tagName, final int tagId) {
            tagText.setText(tagName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tagListerner.onTagSelected(tagId);
                    tagText.setBackgroundColor(Color.CYAN);
                }
            });

        }
    }

    public interface TagListerner {
        void onTagSelected(int tagId);
    }
}
