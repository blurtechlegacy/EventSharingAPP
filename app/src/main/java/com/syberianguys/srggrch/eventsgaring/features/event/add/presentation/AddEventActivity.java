package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.syberianguys.srggrch.eventsgaring.R;

import java.util.ArrayList;

public final class AddEventActivity extends AppCompatActivity{
   /*
   Не забыть унаследоваться от BaseActivity
    */
    private EditText editName;
    private EditText editLogin;
    private EditText editDescription;
    private EditText startEvent;
    private EditText endEvent;
    private Button startEventButton;



    private RecyclerView recyclerTags;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter addNewEventAdapter;

    private ArrayList<String> tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        editName = findViewById(R.id.edit_name);
        editLogin = findViewById(R.id.edit_login);
        editDescription = findViewById(R.id.edit_description);
        startEvent = findViewById(R.id.edit_event_start);
        endEvent = findViewById(R.id.edit_event_end);
        startEventButton = findViewById(R.id.add_new_but);


        tags = new ArrayList<>();

        recyclerTags = findViewById(R.id.id_recycler_view_tags);

        layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        recyclerTags.setLayoutManager(layoutManager);
        addNewEventAdapter = new AdapterTag(tags);
        recyclerTags.setAdapter(addNewEventAdapter);
    }
//    @Override
//    protected <T extends MvpView> MvpPresenter<T> getPresenter() {
//        return null;
//    }
//
//    @Override
//    protected <T extends MvpView> T getMvpView() {
//        return null;
//    }

}
