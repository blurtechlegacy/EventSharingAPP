package tech.blur.eventhub.features.event.add.presentation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import tech.blur.eventhub.R;
import tech.blur.eventhub.features.event.list.presentation.EventsListActivity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{
        private GoogleMap mMap;
        private Button addPlace;
        String coordinates;
    public static void start(Context context){
        final Intent intent = new Intent(context, MapsActivity.class);
        context.startActivity(intent);
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            addPlace = findViewById(R.id.maps_but);

            addPlace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AddEventActivity.start(MapsActivity.this,coordinates);
                }
            });

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

            // Add a marker in Sydney and move the camera
            LatLng nsk = new LatLng(55.0180013, 82.8923166);
           // mMap.addMarker(new MarkerOptions().position(nsk).title("Siberia"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(nsk));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(nsk,12));

            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

                @Override
                public void onMapClick(LatLng point) {

                    mMap.clear();

                    MarkerOptions marker = new MarkerOptions().position(
                            new LatLng(point.latitude, point.longitude)).title("New Marker");

                    mMap.addMarker(marker);
                    coordinates = point.latitude+"-"+ point.longitude;
                    System.out.println(point.latitude+"---"+ point.longitude);
                }
            });
        }
}
