package tech.blur.eventhub.features.event.full.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tech.blur.eventhub.R;
import tech.blur.eventhub.features.event.add.presentation.Tag;

import java.util.ArrayList;
import java.util.List;

public final class AdapterTagFullEvent extends RecyclerView.Adapter<AdapterTagFullEvent.ViewHolder> {
    private final ArrayList<Tag> tags = new ArrayList<>();

    public AdapterTagFullEvent(List<Tag> tags) {
//        this.tags.clear();
//        this.tags.addAll(tags);
    }


    public void setTags(List<Tag> tagsList){
        tags.clear();
        if(tagsList != null) tags.addAll(tagsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tagView = LayoutInflater.from(parent.getContext()).
                inflate(tech.blur.eventhub.R.layout.item_tag, parent, false);
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
            tagText = itemView.findViewById(tech.blur.eventhub.R.id.item_text);
        }

        void bind(final Tag tag) {
            tagText.setText(tag.getName());
        }
    }
}
