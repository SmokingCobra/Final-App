package com.jonschold.fragmentlayout;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


class ExampleAdapter<S> extends ArrayAdapter<String> {

    public ExampleAdapter(Context context, int textViewResourceId, String[] objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = super.getView(position, convertView, parent);

        Typeface tp = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/Neutra2Text-Book.otf");
        TextView tv = (TextView) view.findViewById(android.R.id.text1);
        tv.setTypeface(tp);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        return view;
    }
}