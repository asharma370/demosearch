package com.anuj.demosearch.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.anuj.demosearch.R;
import com.anuj.demosearch.ui.fragment.SearchFragment;

import butterknife.ButterKnife;

/**
 * Main activity class which is responsible
 * for displaying search fragment.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            loadSearchFragment();
        }
    }

    /**
     * Display the search fragment once the activity is created.
     */
    private void loadSearchFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.viewContainer, SearchFragment.getInstance(),
                        SearchFragment.class.getSimpleName())
                .commit();
    }

    /**
     * Used to provide back button pressed functionality from action bar.
     * @param item Menu
     * @return If handled.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
