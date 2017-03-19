package com.udacity.gradle.builditbigger.testing;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import java.util.concurrent.ExecutionException;

/**
 * Created by partokarwat on 3/17/17.
 */

public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Activity application;

    public ApplicationTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        application = getActivity();
    }

    public void testNonEmptyString() throws InterruptedException {
        EndpointsAsyncTask fetchJokeTask = new EndpointsAsyncTask(application.getApplicationContext(), "bla bla");
        fetchJokeTask.execute();
        String joke = null;
        try {
            joke = fetchJokeTask.get();
            Log.d("testFetchJokeTask", "joke=" + joke);
        } catch (ExecutionException e) {
            assertTrue(false);
        }
        assertNotNull(joke);
        assertNotSame(joke, "");
    }
}