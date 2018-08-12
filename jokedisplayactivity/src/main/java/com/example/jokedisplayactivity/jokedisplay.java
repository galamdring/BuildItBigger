package com.example.jokedisplayactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jokelib.Joke;

public class jokedisplay extends AppCompatActivity {

    TextView JokeTextView;
    TextView PunchlineTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokedisplay);
        JokeTextView = findViewById(R.id.tv_joke);
        PunchlineTextView = findViewById(R.id.tv_punchline);
        Bundle data = getIntent().getExtras();
        if(data !=null) {
            String joke = data.getString(Joke.ParcelableKeyJoke);
            String punchline = getIntent().getExtras().getString(Joke.ParcelableKeyPunchline);
            if (joke != null) {
                JokeTextView.setText(joke);
                PunchlineTextView.setText(punchline);
            }
        }
    }
}
