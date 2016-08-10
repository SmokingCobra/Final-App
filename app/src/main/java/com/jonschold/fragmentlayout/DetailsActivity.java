package com.jonschold.fragmentlayout;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class DetailsActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.darkestGray));

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            finish();
            return;
        }

        if(savedInstanceState == null){

            DetailsFragment details = new DetailsFragment();

            details.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();

        }

    }
}
