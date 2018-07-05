package com.syberianguys.srggrch.eventsgaring.features.event.search.presentation;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.syberianguys.srggrch.eventsgaring.R;

public class SearchActivity extends AppCompatActivity {
   //        не забыть унаследоваться от BaseActivity

    Button searchingButton;
    EditText editSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        searchingButton = findViewById(R.id.button_searching);
        editSearch = findViewById(R.id.edit_searching);

    }
}
