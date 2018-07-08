package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation.SignInActivity;
import com.syberianguys.srggrch.eventsgaring.features.event.list.presentation.AllEventsActivity;

import java.util.ArrayList;

public final class AddEventActivity    extends BaseActivity implements AddEventView
{
   /*
   must be extended by BaseActivity
    */
    AddEventPresenter presenter;

   private ProgressBar progressBar;

    public static void start(Context context){
        final Intent intent = new Intent(context, AddEventActivity.class);
        //intent.putExtra(String.valueOf(isAuthAc), isAuth);
        context.startActivity(intent);
    }

    private EditText editNameEvent;
    private EditText editHostName;
    private EditText editDescription;
    private EditText startEvent;
    private EditText endEvent;
    private Button addEventButton;



    private RecyclerView recyclerTags;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterTag addNewEventAdapter;

    private ArrayList<Tag> tags;

   // private AddEventActivity activity = this;//каастыль



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        editNameEvent = findViewById(R.id.adding_event_name);
        editHostName = findViewById(R.id.adding_host_name);
        editDescription = findViewById(R.id.adding_event_discription);
        startEvent = findViewById(R.id.start_event_date);
        endEvent = findViewById(R.id.end_event_date);
        addEventButton = findViewById(R.id.add_new_event_but);



        editNameEvent.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onNameEventChanged(s);
            }
        });
        editHostName.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onNameHostChanged(s);
            }
        });
        editDescription.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onDescriptionChanged(s);
            }
        });
        startEvent.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               presenter.onDataStartChanged(s);
            }
        });
        endEvent.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               presenter.onDataEndChanged(s);
            }
        });

        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddEventClicked();
                AllEventsActivity.start(AddEventActivity.this,true);
}
        });

        tags = new ArrayList<>();
        for (int i = 0; i<10; i++){
            tags.add(new Tag("#new_tag"+i,false));
        }

        recyclerTags = findViewById(R.id.recycler_view_tags);

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
