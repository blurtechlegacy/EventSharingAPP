package tech.blur.eventhub.features.auth.signup.presenter;

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

import tech.blur.eventhub.R;
import tech.blur.eventhub.features.BaseActivity;
import tech.blur.eventhub.features.DefaultTextWatcher;
import tech.blur.eventhub.features.MvpView;
import tech.blur.eventhub.features.event.add.presentation.AddEventActivity;
import tech.blur.eventhub.features.event.add.presentation.UserGender;
import tech.blur.eventhub.features.event.list.presentation.EventsListActivity;

import java.util.Calendar;

import tech.blur.eventhub.features.event.add.presentation.UserGender;
import tech.blur.eventhub.features.event.list.presentation.EventsListActivity;


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


    public static void start(Context context) {
        final Intent intent = new Intent(context, SignUpActivity.class);
        //intent.putExtra("isAuth", isAuth);
        context.startActivity(intent);
    }
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.blur.eventhub.R.layout.activity_registration);

        editNameUser = findViewById(tech.blur.eventhub.R.id.edit_user_name);
        editLogin = findViewById(tech.blur.eventhub.R.id.edit_user_login);
        editPassword = findViewById(tech.blur.eventhub.R.id.edit_user_password);
        editRepeatPassword = findViewById(tech.blur.eventhub.R.id.edit_repeat_password);
        sexList = findViewById(tech.blur.eventhub.R.id.sex_spinner);
        editBirthday = findViewById(tech.blur.eventhub.R.id.birthday);
        regButton = findViewById(tech.blur.eventhub.R.id.sign_up_but);


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

    @Override
    public boolean nameChecker(String name) {
        if(name==null || name.equals("")){
            //editNameUser.setError("пропуск на пати только по имени");
            return false;
        }
        else return true;
    }

    @Override
    public boolean loginChecker(String login) {
        if(login==null || login.equals("")){
            editLogin.setError("придумай свой уникальный логин на eventhub");
            return false;
        }
        else return true;
    }

    @Override
    public boolean passwordChecker(String password) {
        if(password==null || password.equals("")){
            editPassword.setError("пароль должен быть не нулевым");
            return false;
        }
        else return true;
    }

    @Override
    public boolean confirmPasswordChecker(String password,String confirmPassword) {
       if(confirmPassword!=null && password.equals(confirmPassword)) return true;
       else{
           editRepeatPassword.setError("ты должен в точности повторить пароль");
           return false;
       }
    }


    @Override
    public boolean checker(String name, String login, String password, String confirmPassword)
    {
       boolean isNameCorrect =  nameChecker(name);
       boolean isLoginCorrect = loginChecker(login);
       boolean isPasswordCorrect = passwordChecker(password);
       boolean isConfirmPasswordCorrect = confirmPasswordChecker(password,confirmPassword);

        if(isNameCorrect==true && isLoginCorrect==true &&
                isPasswordCorrect==true && isConfirmPasswordCorrect==true){
            EventsListActivity.start(this,true);
            return true;
        }
       else {
            Toast.makeText(this ,"заполните обязательные поля",Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    DatePickerDialog.OnDateSetListener dateSetListenerEnd = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.clear();
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialBirthday();
        }
    };

    private void setInitialBirthday() {


        editBirthday.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
        presenter.onBirthdayChanged(String.valueOf(dateAndTime.getTimeInMillis()));

    }
    public void setBirthday() {
        new DatePickerDialog(SignUpActivity.this, dateSetListenerEnd,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }
}
