package com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.core.DefaultTextWatcher;
import com.syberianguys.srggrch.eventsgaring.features.event.list.presentation.AllEventsActivity;


public class SignInActivity extends AppCompatActivity{

    EditText login;
    EditText pass;
    Button signIn;
    Button signUp;

    SignInPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        login = findViewById(R.id.edit_signin_login);
        pass = findViewById(R.id.edit_signin_password);
        signIn = findViewById(R.id.signIn);
        signUp = findViewById(R.id.signUp);


        login.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setLogin(s);
            }
        });

        pass.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setPass(s);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSignInClicked();
                Intent intent = new Intent(getApplicationContext(), AllEventsActivity.class);
                startActivity(intent);

            }
        });


    }

}
