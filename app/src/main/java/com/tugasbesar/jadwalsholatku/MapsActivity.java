package com.tugasbesar.jadwalsholatku;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

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
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    //memanggil lokasi masjid
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng jember = new LatLng(-8.174832, 113.717647); // titik koordinat lokasinya
        mMap.addMarker(new MarkerOptions().position(jember).title("Masjid Al-Qolam Universitas Muhammadiyah Jember")); //nama lokasi dari titik koordinat
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jember)); //untuk memperbesar atau untuk memperjelas titik lokasi
        LatLng jember1 = new LatLng(-8.172122, 113.720959); // titik koordinat lokasinya
        mMap.addMarker(new MarkerOptions().position(jember1).title("Masjid Baitul Muslimin Jember")); //nama lokasi dari titik koordinat
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jember1)); //untuk memperbesar atau untuk memperjelas titik lokasi
        LatLng jember2 = new LatLng(-8.168287, 113.700505); // titik koordinat lokasinya
        mMap.addMarker(new MarkerOptions().position(jember2).title("Masjid Jami' Al-Baitul Amien Jember")); //nama lokasi dari titik koordinat
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jember2)); //untuk memperbesar atau untuk memperjelas titik lokasi
        LatLng jember3 = new LatLng(-8.177956, 113.681351); // titik koordinat lokasinya
        mMap.addMarker(new MarkerOptions().position(jember3).title("Masjid Raudlatul Muchlisin Jember")); //nama lokasi dari titik koordinat
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jember3)); //untuk memperbesar atau untuk memperjelas titik lokasi
        LatLng jember4 = new LatLng(-8.168683, 113.694043); // titik koordinat lokasinya
        mMap.addMarker(new MarkerOptions().position(jember4).title("Masjid Baitur Roja' Jember")); //nama lokasi dari titik koordinat
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jember4)); //untuk memperbesar atau untuk memperjelas titik lokasi

    }
}
