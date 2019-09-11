package com.anuj.demosearch.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.anuj.demosearch.R;
import com.anuj.demosearch.ui.viewmodel.TrackViewModel;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment to display details of the track,
 * when it's selected from list view.
 */
public class SearchItemDetailsFragment extends BaseFragment {

    private static final String KEY_DATA = "KEY_DATA";
    private static final int IMG_LARGE = 2;

    @BindView(R.id.detailsImageView) ImageView mDetailsImage;
    @BindView(R.id.detailsTitle) TextView mDetailsTitle;
    @BindView(R.id.detailsSubTitle) TextView mDetailsSubTitle;
    @BindView(R.id.detailsSubTitleTwo) TextView mDetailsSubTitleTwo;
    @BindView(R.id.detailsSubTitleThree) TextView mDetailsSubTitleThree;
    @BindView(R.id.detailsSubTitleFour) TextView mDetailsSubTitleFour;

    static SearchItemDetailsFragment newInstance(@NonNull final TrackViewModel trackViewModel) {
        final SearchItemDetailsFragment fragment = new SearchItemDetailsFragment();
        final Bundle args = new Bundle();
        args.putParcelable(KEY_DATA, trackViewModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_item_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        displayBackButton();
        bindViewDetails();
    }

    private void bindViewDetails() {
        assert getArguments() != null;
        final TrackViewModel trackViewModel = getArguments().getParcelable(KEY_DATA);
        assert trackViewModel != null;
        Glide.with(this)
                .load(trackViewModel.getLargeImage())
                .placeholder(R.drawable.ic_image_placeholder)
                .centerCrop()
                .into(mDetailsImage);
        mDetailsTitle.setText(String.format(getString(R.string.details_track_name), trackViewModel.getName()));
        mDetailsSubTitle.setText(String.format(getString(R.string.details_artist_name), trackViewModel.getArtistName()));
        mDetailsSubTitleTwo.setText(String.format(getString(R.string.details_listeners), trackViewModel.getListeners()));
        mDetailsSubTitleThree.setText(String.format(getString(R.string.details_streamable), trackViewModel.getStreamable()));
        mDetailsSubTitleFour.setText(String.format(getString(R.string.details_url), trackViewModel.getUrl()));
    }
}
