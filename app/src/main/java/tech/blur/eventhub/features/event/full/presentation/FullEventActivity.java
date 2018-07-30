package tech.blur.eventhub.features.event.full.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tech.blur.eventhub.R;
import tech.blur.eventhub.features.BaseActivity;
import tech.blur.eventhub.features.MvpPresenter;
import tech.blur.eventhub.features.MvpView;
import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.add.presentation.AdapterTag;
import tech.blur.eventhub.features.event.add.presentation.Tag;
import tech.blur.eventhub.features.event.list.presentation.EventListPresenterFactory;
import tech.blur.eventhub.features.event.list.presentation.EventsListActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullEventActivity extends BaseActivity implements FullActivityView,OnMapReadyCallback {

    private FullEventPresenter presenter;
    private ProgressBar progressBar;
    private GoogleMap mMap;
    TextView nameHost;
    TextView fullDescription;
    TextView place;
    TextView date;
    Button wantToGoBut;
    Toolbar toolbar;

    private RecyclerView recyclerTags;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterTagFullEvent fullEventTagsAdapter;

    private ArrayList<Tag> tags;

    String id;


    public static void start (Context context, String id){
        final Intent intent = new Intent(context, FullEventActivity.class);
        intent.putExtra("Event_id", id);
        Log.e("FullEventActivity", "Try to start");
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.blur.eventhub.R.layout.app_bar_full_event);


        toolbar = findViewById(tech.blur.eventhub.R.id.full_event_toolbar);
        setSupportActionBar(toolbar);



        progressBar = findViewById(tech.blur.eventhub.R.id.full_event_progressBar);
        Log.e("FullEventActivity", "Started");

        nameHost = findViewById(tech.blur.eventhub.R.id.name_host);
        fullDescription = findViewById(tech.blur.eventhub.R.id.event_description);
        place = findViewById(tech.blur.eventhub.R.id.event_place);
        date = findViewById(tech.blur.eventhub.R.id.event_date);
        wantToGoBut = findViewById(tech.blur.eventhub.R.id.want_to_go_but);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //wantToGoBut.setOnClickListener();
        id = getIntent().getStringExtra("Event_id");

        presenter.onEventSelected(id);

        wantToGoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onWantToGoClicked(id);
            }
        });

        recyclerTags = findViewById(tech.blur.eventhub.R.id.full_event_recycler_view_tags);

        layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerTags.setLayoutManager(layoutManager);
        fullEventTagsAdapter = new AdapterTagFullEvent(tags);
        recyclerTags.setAdapter(fullEventTagsAdapter);



    }

    @Override
    protected MvpPresenter<FullActivityView> getPresenter() {
        presenter = FullEventPresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected  MvpView getMvpView() {
        return this;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        nameHost.setVisibility(View.GONE);
        place.setVisibility(View.GONE);
        fullDescription.setVisibility(View.GONE);
        date.setVisibility(View.GONE);
        recyclerTags.setVisibility(View.GONE);
        wantToGoBut.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        place.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        nameHost.setVisibility(View.VISIBLE);
        fullDescription.setVisibility(View.VISIBLE);
        date.setVisibility(View.VISIBLE);
        recyclerTags.setVisibility(View.VISIBLE);
        wantToGoBut.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEvent(Event event, List<Tag> tags) {
        getSupportActionBar().setTitle(event.getName());
        nameHost.setText(event.getHost_name());
        fullDescription.setText(event.getDescription());
        place.setText(event.getPlace());
        date.setText(DateUtils.formatDateTime(this,
                Long.parseLong(event.getStart()),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
        fullEventTagsAdapter.setTags(tags);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void assignFailed() {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void assignDone() {
        wantToGoBut.setText(tech.blur.eventhub.R.string.assign_done);
        wantToGoBut.setFocusable(false);
        wantToGoBut.setClickable(false);

    }

    @Override
    public void addMarker(String coordinates) {
        try{
            double latitude = Double.parseDouble(coordinates.split(",")[0]);
            double longtitude = Double.parseDouble(coordinates.split(",")[1]);
            LatLng nsk = new LatLng(latitude,longtitude);
            mMap.addMarker(new MarkerOptions().position(nsk));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(nsk));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(nsk,12));
        }catch (Exception e){
            Toast.makeText(this,"Невозможно найти местоположение встречи",Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng nsk = new LatLng(55.0180013, 82.8923166);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nsk));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(nsk,12));

    }


}
