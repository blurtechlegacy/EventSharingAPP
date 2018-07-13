package com.syberianguys.srggrch.eventsgaring.features.event.list.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.BaseActivity;
import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation.SignInActivity;
import com.syberianguys.srggrch.eventsgaring.features.core.events.AdapterEvent;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.AddEventActivity;
import com.syberianguys.srggrch.eventsgaring.features.event.assigned.presenter.AssignedActivity;
import com.syberianguys.srggrch.eventsgaring.features.event.full.presentation.FullEventActivity;
import com.syberianguys.srggrch.eventsgaring.features.event.my.presenter.MyEventsActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EventsListActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, EventListView {

    private RecyclerView recyclerEvents;
    private ProgressBar progressBar;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterEvent adapterEvent;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView user_login;
    private TextView user_name;

    private EventListPresenter presenter;

    public static void start(Context context, boolean isAuth){
        final Intent intent = new Intent(context, EventsListActivity.class);
        intent.putExtra("isAuth", isAuth);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_all_events);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddEventActivity.start(EventsListActivity.this);
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


        user_login = drawer.findViewById(R.id.userLogin);
        user_name = drawer.findViewById(R.id.userName);


        swipeRefreshLayout = findViewById(R.id.event_list_swiperefresh);
        progressBar = findViewById(R.id.allEvent_progressBar);
        recyclerEvents = findViewById(R.id.allEvent_recycler_view);
        layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        adapterEvent = new AdapterEvent(this, new AdapterEvent.SelectEventListener() {
            @Override
            public void onEventSelected(Event event) {
                //presenter.onEventSelected(event);
                FullEventActivity.start(EventsListActivity.this, event.getId());
                Log.e("Event selected", event.getId());
            }
        });



        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.onRefresh();
            }

        });


        recyclerEvents.setAdapter(adapterEvent);
        recyclerEvents.setLayoutManager(layoutManager);

        if (!presenter.isAuth()) {
            SignInActivity.start(EventsListActivity.this);
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.main,menu);
       MenuItem item = menu.findItem(R.id.search_event);
       SearchView searchView = (SearchView) item.getActionView();

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               presenter.startSearching();
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               presenter.onSearchedTextChanged(newText);
               return false;
           }
       });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (id){
            case R.id.search_event : return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_allEvents) {
            // Handle the camera action
        } else if (id == R.id.nav_myEvents) {
            MyEventsActivity.start(this);
        } else if (id == R.id.nav_assignedEvents) {
            AssignedActivity.start(this);
        } else if (id == R.id.nav_settings) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerEvents.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerEvents.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showEventList(List<Event> list) {
        Collections.reverse(list);
        if (presenter.isAuth()) adapterEvent.setEvents(list);
    }

//    public void setUser (User user){
//        user_login = findViewById(R.id.userLogin);
//        user_name = findViewById(R.id.userName);
//        if (user != null) {
//            user_login.setText(user.getLogin());
//            user_name.setText(user.getName());
//        }
//    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected MvpPresenter<EventListView> getPresenter() {
        presenter = EventListPresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }
}


