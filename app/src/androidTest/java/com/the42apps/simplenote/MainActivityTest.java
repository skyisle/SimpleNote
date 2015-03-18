package com.the42apps.simplenote;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.internal.util.Checks.checkNotNull;

/**
 * Created by skyisle on 3/18/15.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    @Test
    public void testLoginActivityWithInvalidEmail() {
        onView(withId(R.id.login))
                .perform(click());

        onView(withId(R.id.email))
                .perform(typeText("invalid"));

        onView(withId(R.id.email_sign_in_button))
                .perform(click());

        onView(withId(R.id.email))
                .check(matches(hasErrorText("This email address is invalid")));

    }

    @Test
    public void testLoginActivityWithInvalidPwd() {
        onView(withId(R.id.login))
                .perform(click());

        onView(withId(R.id.email))
                .perform(typeText("valid@mail.com"));

        onView(withId(R.id.password))
                .perform(typeText("sh"));

        onView(withId(R.id.email_sign_in_button))
                .perform(click());

        onView(withId(R.id.password))
                .check(matches(hasErrorText("This password is too short")));

    }

    private static Matcher<? super View> hasErrorText(String expectedError) {
        return new ErrorTextMatcher(expectedError);
    }

    private static class ErrorTextMatcher extends TypeSafeMatcher<View> {
        private final String expectedError;

        private ErrorTextMatcher(String expectedError) {
            this.expectedError = checkNotNull(expectedError);
        }

        @Override
        public boolean matchesSafely(View view) {
            if (!(view instanceof EditText)) {
                return false;
            }
            EditText editText = (EditText) view;
            return expectedError.equals(editText.getError());
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("with error: " + expectedError);
        }
    }
}