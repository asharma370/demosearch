package com.anuj.demosearch.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.anuj.demosearch.R;
import com.anuj.demosearch.ui.viewmodel.TrackViewModel;
import com.bumptech.glide.Glide;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Item view holder class for displaying the search results in adapter.
 * @see SearchListAdapter
 */
class SearchItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.searchItemTitle) TextView searchItemTitle;
    @BindView(R.id.searchItemSubTitle) TextView searchItemSubTitle;
    @BindView(R.id.searchItemImage) ImageView searchItemImage;

    SearchItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull final TrackViewModel track,
                  @Nullable final SearchListAdapter.ItemClickListener listener) {
        searchItemTitle.setText(track.getName());
        searchItemSubTitle.setText(track.getArtistName());
        Glide.with(itemView.getContext())
                .load(track.getSmallImage())
                .centerCrop()
                .into(searchItemImage);
        itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onListItemClick(track);
            }
        });
    }
}
