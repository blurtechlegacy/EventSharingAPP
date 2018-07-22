package tech.blur.eventhub.features.auth.signup.presenter;

import android.content.Context;

import tech.blur.eventhub.App;
import tech.blur.eventhub.features.auth.signup.data.SignUpApi;
import tech.blur.eventhub.features.auth.signup.data.SignUpDataSource;
import tech.blur.eventhub.features.auth.signup.data.SignUpDataSourceImpl;
import tech.blur.eventhub.features.auth.signup.data.SignUpRepository;
import tech.blur.eventhub.features.auth.signup.data.SignUpRepositoryImpl;
import tech.blur.eventhub.features.auth.signup.domain.SignUpInteractor;
import tech.blur.eventhub.features.auth.signup.domain.SignUpInteractorImpl;

import tech.blur.eventhub.features.auth.signup.data.SignUpDataSourceImpl;
import tech.blur.eventhub.features.auth.signup.domain.SignUpInteractorImpl;

public final class SignUpPresenterFactory {
    static SignUpPresenter createPresenter(Context context){
        final SignUpApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(SignUpApi.class);
        final SignUpDataSource dataSource = new SignUpDataSourceImpl(api);
        final SignUpRepository repository = new SignUpRepositoryImpl(dataSource);
        final SignUpInteractor interactor = new SignUpInteractorImpl(repository);

      return  new SignUpPresenter(interactor);
    }
}
