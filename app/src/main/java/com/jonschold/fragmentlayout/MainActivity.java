package com.jonschold.fragmentlayout;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button GearBTTN, LocationBTTN, AboutBTTN, RecordingsBTTN;
        TextView nameTXT;
        Context context = this;
        Typeface tp = Typeface.createFromAsset(context.getAssets(), "fonts/Neutra2Text-Book.otf");

        GearBTTN = (Button)findViewById(R.id.GearBTTN);
        LocationBTTN = (Button)findViewById(R.id.locationBTTN);
        AboutBTTN = (Button)findViewById(R.id.AboutBTTN);
        RecordingsBTTN = (Button)findViewById(R.id.recordingsBTTN);
        nameTXT = (TextView)findViewById(R.id.NameTXT);

        GearBTTN.setTypeface(tp);
        LocationBTTN.setTypeface(tp);
        AboutBTTN.setTypeface(tp);
        RecordingsBTTN.setTypeface(tp);
        nameTXT.setTypeface(tp);

        GearBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FragmentLayout.class));
            }
        });

        LocationBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        RecordingsBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecordingsActivity.class));
            }
        });

        AboutBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
            }
        });


    }

}
