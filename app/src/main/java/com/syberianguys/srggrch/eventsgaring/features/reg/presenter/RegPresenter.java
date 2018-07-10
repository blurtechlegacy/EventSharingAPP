package com.syberianguys.srggrch.eventsgaring.features.reg.presenter;

import android.widget.Toast;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.auth.signin.presentation.SignInActivity;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.features.event.add.presentation.UserGender;
import com.syberianguys.srggrch.eventsgaring.features.reg.domain.RegInteractor;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

public class RegPresenter extends MvpPresenter<RegView>{
    private RegInteractor interactor;
    private String login;
    private String nameUser;
    private String birthday;
    private String password;
    private String repeatPassword;
    private UserGender userGender;


    public RegPresenter(RegInteractor regInteractor) {
        this.interactor = regInteractor;
    }
    public void onRegButClicked(){
        if(password.equals(repeatPassword)){
        User user = new User(login,password,nameUser,birthday,userGender.getId()) ;
       interactor.addUser(user, new Carry<User>() {
            @Override
            public void onSuccess(User result) {

            }

            @Override
            public void onFailure(Throwable throwable) {
            view.showError(throwable.getMessage());
            }
        });
        }
        else{
           RegActivity.a = false;
           view.showError("password and repeat password must be eqvivalent");
        }
    }

    public void onLoginChanged(CharSequence login){
        this.login = login.toString();
    }
    public void onNameUserChanged(CharSequence nameUser){
        this.nameUser = nameUser.toString();
    }
    public void onBirthdayChanged(CharSequence birthday){
        this.birthday = birthday.toString();
    }
    public void onPasswordChanged(CharSequence password){
        this.password = password.toString();
    }
    public void onRepeatPasswordChanged(CharSequence repeatPassword){
        this.repeatPassword = repeatPassword.toString();
    }

    public void setUserGender(UserGender userGender) {
        this.userGender = userGender;
    }
}
