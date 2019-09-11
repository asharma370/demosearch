package com.anuj.demosearch.ui.adapter;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anuj.demosearch.R;

/**
 * Search list adapter decorator to
 * show some space between rows.
 * @see com.anuj.demosearch.ui.fragment.SearchResultsFragment for more details.
 */
public class SearchListAdapterItemDecorator extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(@NonNull Rect outRect,
                               @NonNull View view,
                               @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        outRect.bottom = (int) view.getContext().getResources().getDimension(R.dimen.list_item_bottom_margin);
    }
}
