package com.jonschold.fragmentlayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecordingsActivity extends AppCompatActivity {

    MediaPlayer logan_mp3, ekklesia_mp3, tmi_mp3, isaiah_mp3;
    ImageButton logan_button, ekklesia_button, tmi_button, isaiah_button;
    TextView explanationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordings);

        Context context = this;
        Typeface tp = Typeface.createFromAsset(context.getAssets(), "fonts/Neutra2Text-Book.otf");
        explanationText = (TextView)findViewById(R.id.recordingExplanationText);
        logan_button = (ImageButton)findViewById(R.id.logan_pic_button);
        ekklesia_button = (ImageButton)findViewById(R.id.ekklesia_pic_button);
        tmi_button = (ImageButton)findViewById(R.id.tmi_pic_button);
        isaiah_button = (ImageButton)findViewById(R.id.isaiah_pic_button);
        logan_mp3 = MediaPlayer.create(this, R.raw.look_at_her);
        ekklesia_mp3 = MediaPlayer.create(this, R.raw.open_my_eyes);
        tmi_mp3 = MediaPlayer.create(this, R.raw.melodies);
        isaiah_mp3 = MediaPlayer.create(this, R.raw.no_matter_where);

        logan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(logan_mp3.isPlaying()){
                    logan_mp3.pause();
                }
                else if(!ekklesia_mp3.isPlaying() && !tmi_mp3.isPlaying() && !isaiah_mp3.isPlaying()){
                    logan_mp3.start();
                }
            }
        });

        ekklesia_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ekklesia_mp3.isPlaying()) {
                    ekklesia_mp3.pause();
                } else if (!logan_mp3.isPlaying() && !tmi_mp3.isPlaying() && !isaiah_mp3.isPlaying()) {
                    ekklesia_mp3.start();
                }
            }
        });

        tmi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tmi_mp3.isPlaying()) {
                    tmi_mp3.pause();
                } else if (!logan_mp3.isPlaying() && !ekklesia_mp3.isPlaying() && !isaiah_mp3.isPlaying()) {
                    tmi_mp3.start();
                }
            }
        });

        isaiah_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isaiah_mp3.isPlaying()) {
                    isaiah_mp3.pause();
                } else if (!logan_mp3.isPlaying() && !ekklesia_mp3.isPlaying() && !tmi_mp3.isPlaying()) {
                    isaiah_mp3.start();
                }
            }
        });


    }

}
