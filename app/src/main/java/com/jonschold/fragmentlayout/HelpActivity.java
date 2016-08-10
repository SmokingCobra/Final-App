package com.jonschold.fragmentlayout;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Context context = this;
        Typeface tp = Typeface.createFromAsset(context.getAssets(), "fonts/Neutra2Text-Book.otf");
        TextView aboutTXT = (TextView)findViewById(R.id.aboutTXT);

        aboutTXT.setTypeface(tp);

    }

}
