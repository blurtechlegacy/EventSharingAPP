package tech.blur.eventhub.features.event.add.presentation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import tech.blur.eventhub.R;
import tech.blur.eventhub.features.BaseActivity;
import tech.blur.eventhub.features.DefaultTextWatcher;
import tech.blur.eventhub.features.MvpPresenter;
import tech.blur.eventhub.features.MvpView;
import tech.blur.eventhub.features.core.events.model.Event;
import tech.blur.eventhub.features.event.list.presentation.EventsListActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import tech.blur.eventhub.features.event.list.presentation.EventsListActivity;

public final class AddEventActivity extends BaseActivity implements AddEventView {
    private AddEventPresenter presenter;


    public static void start(Context context) {
        final Intent intent = new Intent(context, AddEventActivity.class);
        context.startActivity(intent);
    }

    private EditText editNameEvent;
    private EditText editDescription;
    private EditText editPlace;
    private TextView startEvent;
    private TextView endEvent;
    private Button addEventButton;


    private RecyclerView recyclerTags;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterTag adapterTag;

   // private ArrayList<Tag> tags;

    Calendar dateAndTime = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.blur.eventhub.R.layout.app_bar_new_event);

        Toolbar toolbar = findViewById(tech.blur.eventhub.R.id.new_event_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tech.blur.eventhub.R.string.title_new_event);



        editPlace = findViewById(tech.blur.eventhub.R.id.adding_event_place);
        editNameEvent = findViewById(tech.blur.eventhub.R.id.adding_event_name);
        editDescription = findViewById(tech.blur.eventhub.R.id.adding_event_discription);
        startEvent = findViewById(tech.blur.eventhub.R.id.start_event_date);
        endEvent = findViewById(tech.blur.eventhub.R.id.end_event_date);
        addEventButton = findViewById(tech.blur.eventhub.R.id.add_new_event_but);


        editNameEvent.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onNameEventChanged(s);
            }
        });
        editDescription.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onDescriptionChanged(s);
            }
        });
        editPlace.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onPlaceChanged(s);
            }
        });

        startEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateStart();
            }
        });

        endEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateEnd();
            }
        });


        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddEventClicked();
            }
        });



        recyclerTags = findViewById(tech.blur.eventhub.R.id.recycler_view_tags);

        layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerTags.setLayoutManager(layoutManager);
        adapterTag = new AdapterTag(new AdapterTag.TagListerner() {
            @Override
            public void onTagSelected(String tagText) {
                presenter.onTagSelected(tagText);
            }
        });
        recyclerTags.setAdapter(adapterTag);
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

        EventsListActivity.start(AddEventActivity.this, true);
    }

    @Override
    public void dateEmptyError() {
        Toast.makeText(this, "date is empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showTagList(List<Tag> list) {
        adapterTag.setEvents(list);
    }

    DatePickerDialog.OnDateSetListener dateSetListenerEnd = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.clear();
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setTimeEnd();

        }
    };

    TimePickerDialog.OnTimeSetListener timeSetListenerEnd = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTimeEnd();
        }

    };


    private void setInitialDateTimeEnd() {


        endEvent.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
        presenter.onDataEndChanged(String.valueOf(dateAndTime.getTimeInMillis()));

    }

    public void setTimeEnd() {
        new TimePickerDialog(AddEventActivity.this, timeSetListenerEnd,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();

    }

    public void setDateEnd() {
        new DatePickerDialog(AddEventActivity.this, dateSetListenerEnd,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
        // setTimeEnd(v);
    }

    DatePickerDialog.OnDateSetListener dateSetListenerStart = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.clear();
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setTimeStart();
        }
    };

    TimePickerDialog.OnTimeSetListener timeSetListenerStart = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTimeStart();
        }

    };


    private void setInitialDateTimeStart() {

        startEvent.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
        presenter.onDataStartChanged(String.valueOf(dateAndTime.getTimeInMillis()));
    }

    public void setTimeStart() {
        new TimePickerDialog(AddEventActivity.this, timeSetListenerStart,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();

    }

    public void setDateStart() {
        new DatePickerDialog(AddEventActivity.this, dateSetListenerStart,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

}
