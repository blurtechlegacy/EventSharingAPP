package tech.blur.eventhub.features.auth.signin.presentation;

import tech.blur.eventhub.features.MvpPresenter;
import tech.blur.eventhub.features.auth.signin.domain.AuthInteractor;
import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.event.list.presentation.EventsListActivity;
import tech.blur.eventhub.network.Carry;

import tech.blur.eventhub.features.auth.signin.domain.model.UserAuth;
import tech.blur.eventhub.features.core.events.model.User;

public class SignInPresenter extends MvpPresenter<SignInView>{


    private final AuthInteractor authInteractor;


    private String login;
    private String pass;

    public SignInPresenter(AuthInteractor authInteractor) {
        this.authInteractor = authInteractor;
    }

    void onSignInClicked (){
        UserAuth userAuth =  new UserAuth(login, pass);
        if ((login != null)&&(pass!=null))
        authInteractor.checkAuth(userAuth, new Carry<User>() {
            @Override
            public void onSuccess(User result) {
                if (result != null) {
                    view.authOk();
                    authInteractor.putIsAuth(true);
                    authInteractor.putUser(result);

                }
                else view.authFailed();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }
        });
    }

    public void onLoginChanged(CharSequence login) {
        this.login = login.toString();
    }

    public void onPassChanged(CharSequence pass) {
        this.pass = pass.toString();
    }
}
