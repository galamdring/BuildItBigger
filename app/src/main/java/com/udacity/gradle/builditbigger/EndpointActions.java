package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import java.io.IOException;

public class EndpointActions extends AsyncTask<Void,Void, Joke> {
    private static MyApi TheEndpoint = null;
    private JokeGetter jokeGetter;

    public EndpointActions(JokeGetter jokeGetter) {
        this.jokeGetter = jokeGetter;
    }

    public interface JokeGetter{
        void onFinished(String joke, String punchline);
    }


    @Override
    protected Joke doInBackground(Void... voids) {
        return GetTheJoke();
    }

    @Override
    protected void onPostExecute(Joke joke) {
        jokeGetter.onFinished(joke.getJoke(),joke.getPunchline());
    }

    public Joke GetTheJoke(){
        if(TheEndpoint==null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            TheEndpoint=builder.build();
        }
        try{
            return TheEndpoint.joke().execute();
        }
        catch(IOException ex){
            Log.w("EndpointActions","Failed to get joke from API.",ex);
        }
        return null;
    }
}
