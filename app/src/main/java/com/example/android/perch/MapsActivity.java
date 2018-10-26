// Created by Rafal Ryczek
package com.example.android.perch;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Towson, MD and move the camera.
        LatLng towson = new LatLng(39.401497, -76.601913); // Geo code for marker
        mMap.addMarker(new MarkerOptions().position(towson).title("Towson, MD")); // Create marker in Towson
        mMap.moveCamera(CameraUpdateFactory.newLatLng(towson)); // Center camera at geo code labeled with marker
        mMap.moveCamera(CameraUpdateFactory.zoomTo(12)); // Zoom camera
    }


}
