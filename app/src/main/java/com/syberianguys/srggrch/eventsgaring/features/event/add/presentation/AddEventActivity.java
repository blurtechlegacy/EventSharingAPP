package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.BaseActivity;
import com.syberianguys.srggrch.eventsgaring.features.DefaultTextWatcher;
import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.MvpView;

import java.util.ArrayList;

public final class AddEventActivity extends BaseActivity implements AddEventView {
   /*
   must be extended by BaseActivity
    */
   AddEventPresenter presenter;

   private ProgressBar progressBar;


    private EditText editNameEvent;
    private EditText editHostName;
    private EditText editDescription;
    private EditText startEvent;
    private EditText endEvent;
    private Button addEventButton;



    private RecyclerView recyclerTags;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter addNewEventAdapter;

    private ArrayList<String> tags;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        editNameEvent = findViewById(R.id.edit_name);
        editHostName = findViewById(R.id.edit_login);
        editDescription = findViewById(R.id.edit_description);
        startEvent = findViewById(R.id.edit_event_start);
        endEvent = findViewById(R.id.edit_event_end);
        addEventButton = findViewById(R.id.add_new_but);

        editNameEvent.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setNameEvent(s.toString());
            }
        });
        editHostName.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setNameHost(s.toString());
            }
        });
        editDescription.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setDescription(s.toString());
            }
        });
        startEvent.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setDateStart(s.toString());
            }
        });
        endEvent.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               presenter.setDateEnd(s.toString());
            }
        });

        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddEventClicked();
            }
        });

        tags = new ArrayList<>();

        recyclerTags = findViewById(R.id.id_recycler_view_tags);

        layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        recyclerTags.setLayoutManager(layoutManager);
        addNewEventAdapter = new AdapterTag(tags, new AdapterTag.TagListerner() {
            @Override
            public void onTagSelected(int tagId) {
                presenter.onTagSelected(tagId);
            }
        });
        recyclerTags.setAdapter(addNewEventAdapter);
    }

    //BaseActivity methods
    @Override
    protected MvpPresenter<AddEventView> getPresenter() {
        presenter = AddEventPresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }
    //AddEventView methods
    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
