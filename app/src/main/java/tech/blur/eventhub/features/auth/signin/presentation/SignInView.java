package tech.blur.eventhub.features.auth.signin.presentation;

import tech.blur.eventhub.features.MvpView;

public interface SignInView extends MvpView {

        void authOk();

        void authFailed();

        void showProgress();

        void hideProgress();

        void showError(String message);


}
