package com.anuj.demosearch;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.anuj.demosearch.ui.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class SearchTrackAppUiTests {

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testSearchKeywordValidation_whenNoKeywordIsEntered() {
        onView(withId(R.id.searchButton)).perform(click());

        onView(withText(R.string.error_search_keyword_empty))
                .inRoot(withDecorView(not(is(activityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testSearchKeyword_withValidKeyword_should_launchSearch() {
        onView(withId(R.id.searchEditText)).perform(typeText("World"));
        onView(withId(R.id.searchButton)).perform(click());

        onView(withId(R.id.searchListLabel)).check(matches(isDisplayed()));
    }

    @Test
    public void testDetailsView_whenListItemSelected_shouldDisplayDetailsView()
            throws InterruptedException{
        onView(withId(R.id.searchEditText)).perform(typeText("World"));
        onView(withId(R.id.searchButton)).perform(click());

        Thread.sleep(5000);

        onView(withId(R.id.searchListRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detailsTitle)).check(matches(isDisplayed()));
    }
}
