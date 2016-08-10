package com.jonschold.fragmentlayout;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsFragment extends Fragment{


    public static DetailsFragment newInstance(int index){

        DetailsFragment f = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);

        f.setArguments(args);

        return f;

    }

    public int getShownIndex(){

        return getArguments().getInt("index", 0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //ListView listView = new ListView(getActivity());

        ScrollView scroller = new ScrollView(getActivity());

        TextView text = new TextView(getActivity());

        ImageView image = new ImageView(getActivity());

        int selectedItem = getShownIndex();

        int padding = (int)
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getActivity().getResources().getDisplayMetrics());

        //image.setPadding(0, 0, 0, 0);
        image.setAdjustViewBounds(true);
        image.setScaleType(ImageView.ScaleType.FIT_XY);

        //scroller.addView(text);

        //text.setText(InstrumentInfo.INFO[selectedItem]);

        /////////////////set image////////////////

        if(selectedItem == 0){
            image.setImageResource(R.drawable.drum_page);
        }
        else if (selectedItem == 1){
            image.setImageResource(R.drawable.cymbal_page);
        }
        else if (selectedItem == 2){
            image.setImageResource(R.drawable.guitar_page);
        }
        else if (selectedItem == 3){
            image.setImageResource(R.drawable.pedalboard_page);
        }
        else if (selectedItem == 4){
            image.setImageResource(R.drawable.amp_page);
        }

        //listView.addView(scroller);

        scroller.addView(image);

        return scroller;

    }
}
