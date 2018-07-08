package com.syberianguys.srggrch.eventsgaring.features.event.search.presentation;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.BaseActivity;
import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.core.events.AdapterEvent;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.Event;

import java.util.ArrayList;

public class SearchActivity extends BaseActivity implements SearchListView{
   //        не забыть унаследоваться от BaseActivity

    private Button searchingButton;
    private EditText editSearch;

    private RecyclerView searchingRecyclerEvents;
    private RecyclerView.Adapter searchingAdapter;
    private RecyclerView.LayoutManager searchingLayoutManager;

    private ArrayList<Event> searchingEvents;

    private SearchListPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);


        initView();

        //------------------------------------------------------------------------------------------



        searchingEvents = new ArrayList<>();

        for (int i = 0; i<10; i++){
            searchingEvents.add(new Event("example",
                    1, "exampleDescription",
                    Integer.toString(i)));
        }
        searchingRecyclerEvents = findViewById(R.id.allEvent_recycler_view);
        searchingLayoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        searchingAdapter = new AdapterEvent(searchingEvents);
        searchingRecyclerEvents.setLayoutManager(searchingLayoutManager);
        searchingRecyclerEvents.setAdapter(searchingAdapter);

    }
    private void initView(){
        searchingButton = findViewById(R.id.button_searching);
        editSearch = findViewById(R.id.edit_searching);

        searchingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSearchedEventClicked();
            }
        });
    }

    @Override
    protected MvpPresenter<SearchListView> getPresenter() {
        presenter = SearchPresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

}
