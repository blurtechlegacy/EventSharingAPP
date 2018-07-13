package com.syberianguys.srggrch.eventsgaring.features.event.full.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.BaseActivity;
import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.AdapterTag;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.Tag;
import com.syberianguys.srggrch.eventsgaring.features.event.list.presentation.EventListPresenterFactory;
import com.syberianguys.srggrch.eventsgaring.features.event.list.presentation.EventsListActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullEventActivity extends BaseActivity implements FullActivityView {

    private FullEventPresenter presenter;
    private ProgressBar progressBar;

    TextView nameEvent ;
    TextView nameHost;
    TextView fullDescription;
    TextView place;
    TextView date;
    Button wantToGoBut;

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
        setContentView(R.layout.activity_full_description_event);


        progressBar = findViewById(R.id.full_event_progressBar);
        Log.e("FullEventActivity", "Started");

        nameEvent = findViewById(R.id.name_event);
        nameHost = findViewById(R.id.name_host);
        fullDescription = findViewById(R.id.event_description);
        place = findViewById(R.id.event_place);
        date = findViewById(R.id.event_date);
        wantToGoBut = findViewById(R.id.want_to_go_but);

        //wantToGoBut.setOnClickListener();
        id = getIntent().getStringExtra("Event_id");

        presenter.onEventSelected(id);

        wantToGoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onWantToGoClicked(id);
            }
        });

        recyclerTags = findViewById(R.id.full_event_recycler_view_tags);

        layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerTags.setLayoutManager(layoutManager);
        fullEventTagsAdapter = new AdapterTagFullEvent(tags);



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
        nameEvent.setVisibility(View.GONE);
        place.setVisibility(View.GONE);
        fullDescription.setVisibility(View.GONE);
        date.setVisibility(View.GONE);
        wantToGoBut.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        place.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        nameHost.setVisibility(View.VISIBLE);
        nameEvent.setVisibility(View.VISIBLE);
        fullDescription.setVisibility(View.VISIBLE);
        date.setVisibility(View.VISIBLE);
        wantToGoBut.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEvent(Event event, List<Tag> tags) {
        nameEvent.setText(event.getName());
        nameHost.setText(event.getHost_name());
        fullDescription.setText(event.getDescription());
        place.setText(event.getPlace());
        date.setText(DateUtils.formatDateTime(this,
                Long.parseLong(event.getStart()),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));

        fullEventTagsAdapter.setTags(tags);
        recyclerTags.setAdapter(fullEventTagsAdapter);
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
        wantToGoBut.setText(R.string.assign_done);
        wantToGoBut.setFocusable(false);
        wantToGoBut.setClickable(false);

    }
}
