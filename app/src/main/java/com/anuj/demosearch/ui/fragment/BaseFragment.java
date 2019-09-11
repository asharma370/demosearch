package com.anuj.demosearch.ui.fragment;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.anuj.demosearch.R;
import com.anuj.demosearch.ui.presenter.contract.BaseViewContract;

/**
 * BaseFragment class should be used by all fragments,
 * also provides some handy methods.
 */
class BaseFragment extends Fragment implements BaseViewContract {

    /**
     * Method to load fragment.
     * It uses replace with no back stack option.
     *
     * @param fragment Fragment to be displayed.
     * @param tag      Tag to used for fragment.
     */
    void loadFragment(@NonNull final Fragment fragment,
                      @NonNull final String tag) {
        loadFragment(fragment, tag, false);
    }

    /**
     * Method to load fragment.
     *
     * @param fragment       Fragment to be displayed.
     * @param tag            Tag to used for fragment.
     * @param addToBackStack Should add to back stack.
     */
    void loadFragment(@NonNull final Fragment fragment,
                      @NonNull final String tag,
                      final boolean addToBackStack) {
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.replace(R.id.viewContainer, fragment, tag).commit();
    }

    /**
     * Method to add fragment.
     *
     * @param fragment Fragment to be displayed.
     * @param tag      Tag to used for fragment.
     */
    void addFragment(@NonNull final Fragment fragment,
                     @NonNull final String tag) {
        addFragment(fragment, tag, false);
    }

    /**
     * Method to add fragment.
     *
     * @param fragment       Fragment to be displayed.
     * @param tag            Tag to used for fragment.
     * @param addToBackStack Should add to back stack.
     */
    void addFragment(@NonNull final Fragment fragment,
                     @NonNull final String tag,
                     final boolean addToBackStack) {
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.add(R.id.viewContainer, fragment, tag).commit();
    }

    /**
     * Method to display back button on action bar.
     */
    void displayBackButton() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * Method to hide back button from action bar.
     */
    void hideBackButton() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    public void showMessage(int errorMsg) {
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        //Can be implemented by the fragment class.
    }

    @Override
    public void showLoading() {
        //Can be implemented by the fragment class.
    }
}
