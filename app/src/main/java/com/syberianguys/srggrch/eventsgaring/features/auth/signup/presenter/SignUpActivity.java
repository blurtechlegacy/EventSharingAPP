package com.syberianguys.srggrch.eventsgaring.features.auth.signup.presenter;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.syberianguys.srggrch.eventsgaring.R;
import com.syberianguys.srggrch.eventsgaring.features.BaseActivity;
import com.syberianguys.srggrch.eventsgaring.features.DefaultTextWatcher;
import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.AddEventActivity;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.UserGender;
import com.syberianguys.srggrch.eventsgaring.features.event.list.presentation.EventsListActivity;

import java.util.Calendar;


public final class SignUpActivity extends BaseActivity implements SignUpView {
    private EditText editNameUser;
    private EditText editLogin;
    private EditText editPassword;
    private EditText editRepeatPassword;
    private Spinner  sexList;
    private TextView editBirthday;
    private Button   regButton;


    Calendar dateAndTime = Calendar.getInstance();

    private SignUpPresenter presenter;
    //public static boolean a=true; // чет как-то хз


    public static void start(Context context){
        final Intent intent = new Intent(context, SignUpActivity.class);
        //intent.putExtra("isAuth", isAuth);
       context.startActivity(intent);
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
//        editBirthday.addTextChangedListener(new DefaultTextWatcher() {
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                presenter.onBirthdayChanged(s);
//            }
//        });
        editBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setBirthday();
            }
        });
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRegButClicked();
                //if(a==true)
                    EventsListActivity.start(SignUpActivity.this,true);

            }
        });
     sexList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          UserGender result = position == 1 ? UserGender.FEMALE : UserGender.MALE;
           presenter.setUserGender(result);
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {
                        presenter.setUserGender(UserGender.MALE);
         }
     });
    }
    @Override
    protected SignUpPresenter getPresenter() {
       presenter =  SignUpPresenterFactory.createPresenter(this);
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
            setInitialBirthday();
        }

    };
    public void setTimeEnd() {
        new TimePickerDialog(SignUpActivity.this, timeSetListenerEnd,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();

    }
    private void setInitialBirthday() {


        editBirthday.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
        presenter.onBirthdayChanged(String.valueOf(dateAndTime.getTimeInMillis()));

    }
    public void setBirthday() {
        new DatePickerDialog(SignUpActivity.this, dateSetListenerEnd,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
        // setTimeEnd(v);
    }
}
