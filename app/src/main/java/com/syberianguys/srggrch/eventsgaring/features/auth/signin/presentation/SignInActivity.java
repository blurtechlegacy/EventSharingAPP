package com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.BaseActivity;
import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.auth.signup.presenter.SignUpActivity;
import com.syberianguys.srggrch.eventsgaring.features.core.DefaultTextWatcher;


public class SignInActivity extends BaseActivity implements SignInView{

    EditText login;
    EditText pass;
    Button signIn;
    Button signUp;
    Boolean isAuth = false;

    //private static final boolean isAuthAc = false;

    SignInPresenter presenter;

    public static void start(Context context){
        final Intent intent = new Intent(context, SignInActivity.class);
        //intent.putExtra("isAuth", isAuthAc);
        context.startActivity(intent);
    }

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
                presenter.onLoginChanged(s);
            }
        });

        pass.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onPassChanged(s);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSignInClicked();
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpActivity.start(SignInActivity.this);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (isAuth) super.onBackPressed();
    }

    @Override
    public void authOk() {
        //EventsListActivity.start(SignInActivity.this, true);
        isAuth = true;
        onBackPressed();

    }

    //@SuppressLint("ShowToast")
    @Override
    public void authFailed() {
        Toast.makeText(this, "User not found", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    protected MvpPresenter<SignInView> getPresenter() {
        presenter = SignInPresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected SignInView getMvpView() {
        return this;
    }

}
