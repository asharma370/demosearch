package com.anuj.demosearch.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.anuj.demosearch.R;
import com.anuj.demosearch.ui.viewmodel.TrackViewModel;

import java.util.List;

/**
 * Adapter for search results list.
 *
 * @see com.anuj.demosearch.ui.fragment.SearchResultsFragment for details.
 */
public class SearchListAdapter extends RecyclerView.Adapter<SearchItemViewHolder> {

    @Nullable private List<TrackViewModel> mTracks;

    /**
     * Item callback for list.
     */
    public interface ItemClickListener {
        void onListItemClick(@NonNull final TrackViewModel trackViewModel);
    }

    private ItemClickListener mListener;

    /**
     * Method to set item click callback.
     *
     * @param mListener Listener for item.
     */
    public void setItemClickListener(@Nullable final ItemClickListener mListener) {
        this.mListener = mListener;
    }

    /**
     * Method to set data to adapter.
     *
     * @param tracks Tracks data.
     */
    public void setData(@NonNull final List<TrackViewModel> tracks) {
        mTracks = tracks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_search_list, parent, false);
        return new SearchItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchItemViewHolder holder, int position) {
        holder.bindData(mTracks.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mTracks == null ? 0 : mTracks.size();
    }
}
