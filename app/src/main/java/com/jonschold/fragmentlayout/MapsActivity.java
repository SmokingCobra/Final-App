package com.jonschold.fragmentlayout;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    protected MyDBHandler myDBHandler;
    private List<BandLocation> locationList;



    private BandLocation HardRock;
    private BandLocation Studio7;
    private BandLocation Lakefair;
    private BandLocation MidnightSun;
    private BandLocation WWU;
    private BandLocation LouieGs;
    private BandLocation BLGrange;
    private BandLocation EaglesBallroom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        myDBHandler = new MyDBHandler(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MarkerOptions marker = new MarkerOptions();
        LatLng tempLatLng;

        HardRock = new BandLocation(0, "Hard Rock Cafe", "47.609242", "-122.339451");
        Studio7 = new BandLocation(1, "Studio Seven","47.574573", "-122.333610");
        Lakefair = new BandLocation(2, "Lakefair Battle of the Bands", "47.043565", "-122.905621");
        MidnightSun = new BandLocation(3, "The Midnight Sun","47.045321", "-122.903218");
        WWU = new BandLocation(4, "Western Washington University", "48.738469", "-122.485706");
        LouieGs = new BandLocation(5, "Louie G's Pizzaria", "47.243367", "-122.358656");
        BLGrange = new BandLocation(6, "Black Lake Grange", "46.994034", "-122.985971");
        EaglesBallroom = new BandLocation(7, "Eagle's Grand Ballroom", "47.045355", "-122.892655");

        myDBHandler.addLocation(HardRock);
        myDBHandler.addLocation(Studio7);
        myDBHandler.addLocation(Lakefair);
        myDBHandler.addLocation(MidnightSun);
        myDBHandler.addLocation(WWU);
        myDBHandler.addLocation(LouieGs);
        myDBHandler.addLocation(BLGrange);
        myDBHandler.addLocation(EaglesBallroom);

        locationList = myDBHandler.getAllLocations();

        for(BandLocation bandLocation : locationList){
            tempLatLng = new LatLng(Double.parseDouble(bandLocation.getLat()), Double.parseDouble(bandLocation.getLon()));

            marker.position(tempLatLng);
            marker.title(bandLocation.getName());
            mMap.addMarker(marker);

        }

        tempLatLng = new LatLng(Double.parseDouble(HardRock.getLat()), Double.parseDouble(HardRock.getLon()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tempLatLng, 8));

    }
}
