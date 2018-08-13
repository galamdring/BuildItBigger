package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class UnitTest{

    @Test
    public void TestAsyncTaskLogicNotNull(){
        EndpointActions actions = new EndpointActions(null);
        Joke joke = actions.GetTheJoke();
        Assert.assertNotNull(joke);
        Assert.assertNotNull(joke.getJoke());
        Assert.assertNotNull(joke.getPunchline());
    }

    //The following 2 tests are based on the format found here:
    // https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework/44222992#44222992
    // as suggested by reviewer.
    // One test will fail if the service is not running, the other if it is.
    @Test
    public void TestAsyncTaskNotNullReturn() throws InterruptedException{
        final CountDownLatch latch = new CountDownLatch(1);
        EndpointActions actions = new EndpointActions(null){
            @Override
            protected void onPostExecute(Joke joke) {
                Assert.assertNotNull(joke);
                Assert.assertNotNull(joke.getJoke());
                Assert.assertNotNull(joke.getPunchline());
                latch.countDown();
            }
        };
        actions.execute();
        latch.await();
    }


    @Test
    public void TestAsyncTaskNullReturn() throws InterruptedException{
        final CountDownLatch latch = new CountDownLatch(1);
        EndpointActions actions = new EndpointActions(null){
            @Override
            protected void onPostExecute(Joke joke) {
                Assert.assertNull(joke);
                latch.countDown();
            }
        };
        actions.execute();
        latch.await();
    }
}
