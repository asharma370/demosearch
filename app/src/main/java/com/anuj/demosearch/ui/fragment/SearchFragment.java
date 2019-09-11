package com.anuj.demosearch.ui.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anuj.demosearch.R;
import com.anuj.demosearch.business.di.AppInjector;
import com.anuj.demosearch.business.utils.AppUtils;
import com.anuj.demosearch.ui.presenter.contract.SearchViewContract;
import com.anuj.demosearch.ui.presenter.SearchViewPresenter;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment to display view to search keyword.
 */
public class SearchFragment extends BaseFragment implements SearchViewContract.View {

    @BindView(R.id.searchEditText) EditText mSearchEditText;
    @BindView(R.id.searchButton) View mSearchBtn;

    @Inject SearchViewPresenter mPresenter;

    public static SearchFragment getInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        AppInjector.getInstance().inject(this);
        mPresenter.onAttach(this);
    }

    @Override
    public void displaySearchResultsView(@NonNull final String searchKeyword) {
        loadFragment(SearchResultsFragment.getInstance(searchKeyword),
                SearchFragment.class.getSimpleName(), true);
    }

    @OnClick(R.id.searchButton)
    void handleSearchClick() {
        final ConnectivityManager connectivityManager = (ConnectivityManager) getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        final String searchKeyword = mSearchEditText.getText().toString();
        mPresenter.onClickSearchButton(AppUtils.isConnectedToInternet(connectivityManager),
                TextUtils.isEmpty(searchKeyword),
                searchKeyword);
    }

}
