package tech.blur.eventhub.features.auth.signin.presentation;

import android.content.Context;

import tech.blur.eventhub.App;
import tech.blur.eventhub.features.auth.signin.data.AuthApi;
import tech.blur.eventhub.features.auth.signin.data.AuthDataSource;
import tech.blur.eventhub.features.auth.signin.data.AuthDataSourceImpl;
import tech.blur.eventhub.features.auth.signin.data.AuthRepository;
import tech.blur.eventhub.features.auth.signin.data.AuthRepositoryImpl;
import tech.blur.eventhub.features.auth.signin.data.localstorage.AuthLocalDataSource;
import tech.blur.eventhub.features.auth.signin.data.localstorage.AuthLocalDataSourceImpl;
import tech.blur.eventhub.features.auth.signin.data.localstorage.AuthLocalRepository;
import tech.blur.eventhub.features.auth.signin.data.localstorage.AuthLocalRepositoryImpl;
import tech.blur.eventhub.features.auth.signin.domain.AuthInteractor;
import tech.blur.eventhub.features.auth.signin.domain.AuthInteractorImpl;

public class SignInPresenterFactory {

    static SignInPresenter createPresenter(Context context){
        final AuthApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(AuthApi.class);
        final AuthDataSource authDataSource = new AuthDataSourceImpl(api);
        final AuthRepository authRepository = new AuthRepositoryImpl(authDataSource);

        final AuthLocalDataSource authSPDataSource = new AuthLocalDataSourceImpl(context);
        final AuthLocalRepository authLocalRepository = new AuthLocalRepositoryImpl(authSPDataSource);

        final AuthInteractor authInteractor = new AuthInteractorImpl(authRepository, authLocalRepository);



        return new SignInPresenter(authInteractor);
    }

}
