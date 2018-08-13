package com.example.jokedisplayactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class jokedisplay extends AppCompatActivity {
    public static final String ParcelableKeyJoke = "ThisIsTheKeyForStoringAJokeInAParcelable";
    public static final String ParcelableKeyPunchline = "ThisisTheKeyForStoringAPunchlineInAParcelable";

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
            String joke = data.getString(ParcelableKeyJoke);
            String punchline = getIntent().getExtras().getString(ParcelableKeyPunchline);
            if (joke != null) {
                JokeTextView.setText(joke);
                PunchlineTextView.setText(punchline);
            }
        }
    }
}
