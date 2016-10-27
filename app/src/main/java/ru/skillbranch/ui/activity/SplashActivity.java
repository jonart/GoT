package ru.skillbranch.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import ru.skillbranch.got.BuildConfig;
import ru.skillbranch.got.R;
import ru.skillbranch.mvp.presenter.ISplashPresenter;
import ru.skillbranch.mvp.presenter.SplashPresenter;
import ru.skillbranch.mvp.view.ISplashView;

public class SplashActivity extends BaseActivity implements ISplashView {

    SplashPresenter mPresenter = SplashPresenter.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter.takeView(this);
        mPresenter.initView();
    }

    @Override
    protected void onDestroy() {
        mPresenter.dropView();
        super.onDestroy();
    }

    @Override
    public void nextActivity() {
        Intent listCharacter = new Intent(SplashActivity.this, CharacterListScreen.class);
        startActivity(listCharacter);
        finish();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(int stringId) {
        showMessage(getString(stringId));
    }

    @Override
    public void showError(Throwable e) {
        if (BuildConfig.DEBUG) {
            showMessage(e.getMessage());
            e.printStackTrace();
        } else {
            showMessage(R.string.something_wrong);
        }
    }

    @Override
    public void showLoad() {
        showProgress();
    }

    @Override
    public void hideLoad() {
        hideProgress();
    }

    @Override
    public ISplashPresenter getPresenter() {
        return mPresenter;
    }

}
