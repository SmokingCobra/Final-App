package com.jonschold.fragmentlayout;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.telecom.Call;
import android.view.View;
import android.app.ListFragment;
import android.content.pm.InstrumentationInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TitleFragment extends ListFragment{

    boolean mDuelPane;
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ExampleAdapter<String> connectArrayToListView = new ExampleAdapter<>(getActivity(), android.R.layout.simple_list_item_1, InstrumentInfo.GEAR);

        setListAdapter(connectArrayToListView);

        View detailsFrame = getActivity().findViewById(R.id.details);

        mDuelPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if(savedInstanceState != null){

            mCurCheckPosition = savedInstanceState.getInt("CurChoice", 0);


        }

        if(mDuelPane){

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurCheckPosition);


        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("curChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }


    void showDetails(int index){

        mCurCheckPosition = index;

        if(mDuelPane){

            getListView().setItemChecked(index, true);

            DetailsFragment details = (DetailsFragment)
                    getFragmentManager().findFragmentById(R.id.details);

            if(details == null || details.getShownIndex() != index){

                details = DetailsFragment.newInstance(index);

                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.details, details);

                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }

        }
        else {

            Intent intent = new Intent();

            intent.setClass(getActivity(), DetailsActivity.class);

            intent.putExtra("index", index);

            startActivity(intent);

        }

    }
}