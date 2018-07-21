package tech.blur.eventhub.features;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract <T extends MvpView> MvpPresenter<T> getPresenter();

    protected abstract <T extends MvpView> T getMvpView();

    private MvpPresenter<MvpView> presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(getMvpView());
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
