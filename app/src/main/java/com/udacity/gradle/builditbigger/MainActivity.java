package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jokedisplayactivity.jokedisplay;


public class MainActivity extends AppCompatActivity implements EndpointActions.JokeGetter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        //Toast.makeText(this, Jokes.getRandomJoke().toString(), Toast.LENGTH_SHORT).show();
        /* This code directly got the joke and launched the activity.
        Joke joke = Jokes.getRandomJoke();
        Intent jokedisplayactivity = new Intent(this,jokedisplay.class);
        jokedisplayactivity.putExtra(ParcelableKeyJoke,joke.get_joke());
        jokedisplayactivity.putExtra(ParcelableKeyPunchline,joke.get_punchline());
        startActivity(jokedisplayactivity);
        */

        //New method is to use the GCE to supply the jokes. Get the joke using the EndpointActions
        new EndpointActions(this).execute();

    }


    @Override
    public void onFinished(String joke, String punchline) {
        Intent jokedisplayactivity = new Intent(this,jokedisplay.class);
        jokedisplayactivity.putExtra(jokedisplay.ParcelableKeyJoke,joke);
        jokedisplayactivity.putExtra(jokedisplay.ParcelableKeyPunchline,punchline);
        startActivity(jokedisplayactivity);
    }
}
