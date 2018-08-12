package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

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
}
