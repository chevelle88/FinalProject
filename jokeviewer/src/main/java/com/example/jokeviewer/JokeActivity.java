package com.example.jokeviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent jokeIntent = getIntent();
        TextView jokeText = (TextView)this.findViewById(R.id.jokeText);

        jokeText.setText(jokeIntent.getStringExtra("RD_JOKE"));
    }
}
