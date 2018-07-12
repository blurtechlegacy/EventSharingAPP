package com.syberianguys.srggrch.eventsgaring.features.event.add.presentation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.BaseActivity;
import com.syberianguys.srggrch.eventsgaring.features.DefaultTextWatcher;
import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation.SignInActivity;
import com.syberianguys.srggrch.eventsgaring.features.event.list.presentation.EventsListActivity;

import java.util.ArrayList;
import java.util.Calendar;

public final class AddEventActivity extends BaseActivity implements AddEventView {
    private AddEventPresenter presenter;


    public static void start(Context context) {
        final Intent intent = new Intent(context, AddEventActivity.class);
        context.startActivity(intent);
    }

    private EditText editNameEvent;
    private EditText editHostName;
    private EditText editDescription;
    private TextView startEvent;
    private TextView endEvent;
    private Button addEventButton;


    private RecyclerView recyclerTags;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterTag addNewEventAdapter;

    private ArrayList<Tag> tags;

    Calendar dateAndTime = Calendar.getInstance();


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

        startEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(v);
                setDate(v);
                setInitialDateTime(startEvent);
            }
        });

        endEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(v);
                setDate(v);
                setInitialDateTime(endEvent);
            }
        });




        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddEventClicked();
                EventsListActivity.start(AddEventActivity.this, true);
            }
        });

        tags = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tags.add(new Tag("#new_tag" + i, false));
        }

        recyclerTags = findViewById(R.id.recycler_view_tags);

        layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerTags.setLayoutManager(layoutManager);
        addNewEventAdapter = new AdapterTag(tags, new AdapterTag.TagListerner() {
            @Override
            public void onTagSelected(int tagId) {
                presenter.onTagSelected(tagId);
            }
        });
        recyclerTags.setAdapter(addNewEventAdapter);
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }
    };

    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                dateAndTime.set(Calendar.MINUTE, minute);
            }

    };



    private void setInitialDateTime(TextView textView) {

        textView.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }

    public void setTime(View v) {
        new TimePickerDialog(AddEventActivity.this, timeSetListener,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();

    }

    public void setDate(View v) {
        new DatePickerDialog(AddEventActivity.this, dateSetListener,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
       // setTime(v);
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
        //  progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        //  progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

}
