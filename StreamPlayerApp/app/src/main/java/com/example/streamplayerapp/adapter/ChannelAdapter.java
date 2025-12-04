package com.example.streamplayerapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.streamplayerapp.R;
import com.example.streamplayerapp.model.Channel;
import java.util.List;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder> {
    private List<Channel> channels;
    private OnChannelClickListener listener;

    public interface OnChannelClickListener {
        void onChannelClick(Channel channel);
        void onFavoriteClick(Channel channel, int position);
    }

    public ChannelAdapter(List<Channel> channels, OnChannelClickListener listener) {
        this.channels = channels;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_channel, parent, false);
        return new ChannelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, int position) {
        Channel channel = channels.get(position);
        holder.bind(channel, position);
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    public void updateChannels(List<Channel> newChannels) {
        this.channels = newChannels;
        notifyDataSetChanged();
    }

    public class ChannelViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private ImageView favoriteIcon;
        private ImageView logoImageView;

        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.channel_name);
            favoriteIcon = itemView.findViewById(R.id.favorite_icon);
            logoImageView = itemView.findViewById(R.id.channel_logo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onChannelClick(channels.get(position));
                    }
                }
            });

            favoriteIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        Channel channel = channels.get(position);
                        channel.setFavorite(!channel.isFavorite());
                        listener.onFavoriteClick(channel, position);
                        updateFavoriteIcon();
                    }
                }
            });
        }

        public void bind(Channel channel, int position) {
            nameTextView.setText(channel.getName());
            updateFavoriteIcon();
        }

        private void updateFavoriteIcon() {
            Channel channel = channels.get(getAdapterPosition());
            if (channel.isFavorite()) {
                favoriteIcon.setImageResource(R.drawable.ic_favorite);
            } else {
                favoriteIcon.setImageResource(R.drawable.ic_favorite_border);
            }
        }
    }
}