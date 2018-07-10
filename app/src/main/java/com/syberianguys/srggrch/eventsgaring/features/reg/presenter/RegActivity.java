package com.syberianguys.srggrch.eventsgaring.features.reg.presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.BaseActivity;
import com.syberianguys.srggrch.eventsgaring.features.DefaultTextWatcher;
import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation.SignInActivity;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.UserGender;
import com.syberianguys.srggrch.eventsgaring.features.event.list.presentation.EventsListActivity;


public final class RegActivity extends BaseActivity implements RegView{
    private EditText editNameUser;
    private EditText editLogin;
    private EditText editPassword;
    private EditText editRepeatPassword;
    private Spinner  sexList;
    private EditText editBirthday;
    private Button   regButton;


    private RegPresenter presenter;
    public static boolean a=true;


    public static void start(Context context){
        final Intent intent = new Intent(context, RegActivity.class);
        //intent.putExtra("isAuth", isAuth);
       context.startActivity(intent);//хз
    }
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editNameUser = findViewById(R.id.edit_user_name);
        editLogin = findViewById(R.id.edit_user_login);
        editPassword = findViewById(R.id.edit_user_password);
        editRepeatPassword = findViewById(R.id.edit_repeat_password);
        sexList = findViewById(R.id.sex_spinner);
        editBirthday = findViewById(R.id.birthday);
        regButton = findViewById(R.id.sign_up_but);


        editNameUser.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onNameUserChanged(s);
            }
        });
        editLogin.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onLoginChanged(s);
            }
        });
        editPassword.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onPasswordChanged(s);
            }
        });
        editRepeatPassword.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onRepeatPasswordChanged(s);
            }
        });
        editBirthday.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onBirthdayChanged(s);
            }
        });
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRegButClicked();
                if(a==true)      EventsListActivity.start(RegActivity.this,a);

            }
        });
     sexList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             switch (position){
                 case 0: presenter.setUserGender(UserGender.MALE);
                        break;
                 case 1: presenter.setUserGender(UserGender.FEMALE);
                        break;
             }
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {
                        presenter.setUserGender(UserGender.MALE);
         }
     });
    }
    @Override
    protected RegPresenter getPresenter() {
       presenter =  RegPresenterFactory.createPresenter(this);
       return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}
