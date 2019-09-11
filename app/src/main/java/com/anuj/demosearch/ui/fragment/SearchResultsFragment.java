package com.anuj.demosearch.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anuj.demosearch.R;
import com.anuj.demosearch.business.di.AppInjector;
import com.anuj.demosearch.ui.adapter.SearchListAdapter;
import com.anuj.demosearch.ui.adapter.SearchListAdapterItemDecorator;
import com.anuj.demosearch.ui.viewmodel.TrackViewModel;
import com.anuj.demosearch.ui.presenter.contract.SearchResultsContract;
import com.anuj.demosearch.ui.presenter.SearchResultsPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment to display search results.
 */
public class SearchResultsFragment extends BaseFragment implements SearchResultsContract.View,
        SearchListAdapter.ItemClickListener {

    private static final String KEY_KEYWORD = "KEY_KEYWORD";

    @BindView(R.id.progressViewGroup) View progressView;
    @BindView(R.id.searchListRecyclerView) RecyclerView mSearchList;

    private SearchListAdapter mSearchListAdapter;

    @Inject
    SearchResultsPresenter mPresenter;

    static SearchResultsFragment getInstance(@NonNull final String keyword) {
        final SearchResultsFragment searchResultsFragment = new SearchResultsFragment();
        final Bundle args = new Bundle();
        args.putString(KEY_KEYWORD, keyword);
        searchResultsFragment.setArguments(args);
        return searchResultsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppInjector.getInstance().inject(this);
        mPresenter.onAttach(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_results, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        displayBackButton();
        assert getArguments() != null;
        final String searchKeyword = getArguments().getString(KEY_KEYWORD);
        setupListViewAndAdapter();
        mPresenter.searchData(searchKeyword);
    }

    @Override
    public void showMessage(@StringRes final int errorMsg) {
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displaySearchResults(@NonNull final List<TrackViewModel> results) {
        mSearchListAdapter.setData(results);
    }

    @Override
    public void hideLoading() {
        progressView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDetach() {
        hideBackButton();
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onListItemClick(@NonNull TrackViewModel trackViewModel) {
        addFragment(SearchItemDetailsFragment.newInstance(trackViewModel),
                SearchResultsFragment.class.getSimpleName(), true);
    }

    /**
     * Setup list view and it's adapter.
     */
    private void setupListViewAndAdapter() {
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mSearchList.setLayoutManager(mLayoutManager);
        mSearchListAdapter = new SearchListAdapter();
        mSearchListAdapter.setItemClickListener(this);
        mSearchList.setAdapter(mSearchListAdapter);
        mSearchList.addItemDecoration(new SearchListAdapterItemDecorator());
    }
}
