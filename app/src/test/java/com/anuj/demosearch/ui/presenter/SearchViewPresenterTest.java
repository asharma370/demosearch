package com.anuj.demosearch.ui.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.anuj.demosearch.R;
import com.anuj.demosearch.ui.presenter.contract.SearchViewContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchViewPresenterTest {

    private static final String KEYWORD = "Keyword";
    @Mock SearchViewContract.View mView;
    @Mock Context mContext;

    private SearchViewPresenter mPresenter;

    @Before
    public void setup() {
        mPresenter = new SearchViewPresenter();
        mPresenter.onAttach(mView);
    }

    @Test
    public void onClickSearchButton_whenEmptyString_shouldShowMessage() {
        when(mContext.getString(anyInt())).thenReturn("Some message");

        mPresenter.onClickSearchButton(true, KEYWORD);

        verify(mView).showMessage(R.string.error_search_keyword_empty);
    }

    @Test
    public void onClickSearchButton_whenNonEmpty_shouldSearchKeyword() {
        mPresenter.onClickSearchButton(false, KEYWORD);

        verify(mView).displaySearchResultsView(KEYWORD);
    }
}