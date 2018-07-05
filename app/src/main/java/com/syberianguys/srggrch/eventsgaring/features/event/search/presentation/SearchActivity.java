package com.syberianguys.srggrch.eventsgaring.features.event.search.presentation;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.core.events.AdapterEvent;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
   //        не забыть унаследоваться от BaseActivity

    Button searchingButton;
    EditText editSearch;

    RecyclerView searchingRecyclerEvents;
    private RecyclerView.Adapter searchingAdapter;
    private RecyclerView.LayoutManager searchingLayoutManager;

    ArrayList<Event> searchingEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        searchingButton = findViewById(R.id.button_searching);
        editSearch = findViewById(R.id.edit_searching);

        //------------------------------------------------------------------------------------------



        searchingEvents = new ArrayList<>();

        for (int i = 0; i<10; i++){
            searchingEvents.add(new Event("example",
                    "exampleHost", "exampleDescription",
                    Integer.toString(i)));
        }
        searchingRecyclerEvents = findViewById(R.id.allEvent_recycler_view);
        searchingLayoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        searchingAdapter = new AdapterEvent(searchingEvents);
        searchingRecyclerEvents.setLayoutManager(searchingLayoutManager);
        searchingRecyclerEvents.setAdapter(searchingAdapter);

    }
}
