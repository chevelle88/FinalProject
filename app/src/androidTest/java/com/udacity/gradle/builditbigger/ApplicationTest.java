package com.udacity.gradle.builditbigger;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> jokeActivityRule =
            new ActivityTestRule(MainActivity.class);
    @Test
    public void verifyJokeExists() {
        String joke = null;
        Context app[] = { jokeActivityRule.getActivity() };

        try {
            joke = new JokeAsyncTask().execute(app).get();
            assertNotNull("No joke returned.", joke);
            System.out.println("Joke: " + joke);
        }
        catch (Exception anyErr) {
            fail("Error occur while getting the joke.");
        }

    }
}