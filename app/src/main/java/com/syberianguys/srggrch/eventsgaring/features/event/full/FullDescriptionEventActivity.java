package com.syberianguys.srggrch.eventsgaring.features.event.full;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.syberianguys.srggrch.eventsgaring.R;

public class FullDescriptionEventActivity extends AppCompatActivity {
    TextView nameEvent ;
    TextView nameHost;
    TextView fullDescription;
    TextView place;
    TextView date;
    ImageView eventImage;
    Button wantToGoBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_description_event);

        nameEvent=findViewById(R.id.name_event);
        nameHost=findViewById(R.id.name_host);
        fullDescription=findViewById(R.id.event_description);
        place = findViewById(R.id.event_place);
        date = findViewById(R.id.event_date);
        eventImage = findViewById(R.id.event_image);
        wantToGoBut = findViewById(R.id.want_to_go_but);


    }
}
