package com.syberianguys.srggrch.eventsgaring.features.event.list.presentation;


import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation.SignInActivity;
import com.syberianguys.srggrch.eventsgaring.features.core.events.AdapterEvent;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.AddEventActivity;

import java.util.ArrayList;

public class AllEventsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerEvents;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter AdapterEvent;

    boolean f = false;

    private ArrayList<Event> events;

    public static void start(Context context, boolean isAuth){
        final Intent intent = new Intent(context, AllEventsActivity.class);
        intent.putExtra("isAuth", isAuth);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        f = getIntent().getBooleanExtra("isAuth", false);
        if (!f) {
            f = true;
            AddEventActivity.start(this);
        }

        setContentView(R.layout.activity_all_events);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //------------------------------------------------------------------------------------------



        events = new ArrayList<>();

        for (int i = 0; i<10; i++){
            events.add(new Event("example",
                    "exampleHost", "exampleDescription",
                    Integer.toString(i)));
        }

        recyclerEvents = findViewById(R.id.allEvent_recycler_view);
        layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        AdapterEvent = new AdapterEvent(events);
        recyclerEvents.setLayoutManager(layoutManager);
        recyclerEvents.setAdapter(AdapterEvent);




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    protected <T extends MvpView> MvpPresenter<T> getPresenter() {
//        presenter = PresenterFactory.createPresenter(this);
//        return presenter;
//        return null;
//    }
//
//    @Override
//    protected <T extends MvpView> T getMvpView() {
//        return null;
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_allEvents) {
            // Handle the camera action
        } else if (id == R.id.nav_myEvents) {

        } else if (id == R.id.nav_assignedEvents) {

        } else if (id == R.id.nav_settings) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
