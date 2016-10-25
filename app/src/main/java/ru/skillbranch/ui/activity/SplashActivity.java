package ru.skillbranch.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.widget.Toast;

import ru.skillbranch.got.BuildConfig;
import ru.skillbranch.data.IceAndFire;
import ru.skillbranch.mvp.presenter.ISplashPresenter;
import ru.skillbranch.mvp.presenter.SplashPresenter;
import ru.skillbranch.data.network.DataManager;
import ru.skillbranch.data.network.database.DaoSession;
import ru.skillbranch.got.R;
import ru.skillbranch.data.network.database.MemberDao;
import ru.skillbranch.mvp.view.ISplashView;

public class SplashActivity extends BaseActivity implements ISplashView{
    SplashPresenter mSplashPresenter = SplashPresenter.getInstance();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashPresenter.takeView(this);
        mSplashPresenter.initView();
        loading();
    }


    public void loading(){
        showLoad();
        if(mSplashPresenter.isDBEmpty()){
            mSplashPresenter.addMembersToDB();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent listCharacter = new Intent(SplashActivity.this, CharacterListScreen.class);
                    startActivity(listCharacter);
                    finish();
                }
            }, 3000);
        } else {
            hideLoad();
            Intent listCharacter = new Intent(SplashActivity.this, CharacterListScreen.class);
            startActivity(listCharacter);
            finish();
        }

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(Throwable e) {
        if(BuildConfig.DEBUG){
            showMessage(e.getMessage());
            e.printStackTrace();
        }else {
            showMessage("Что то пошло не так");
        }
    }

    @Override
    public void showLoad() {
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this, R.style.custom_dialog);
            mProgressDialog.setCancelable(false);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
        }else {
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
            finish();
        }
    }

    @Override
    public void hideLoad() {
        if(mProgressDialog != null){
            if(mProgressDialog.isShowing()){
                mProgressDialog.dismiss();
            }
        }
    }

    @Override
    public ISplashPresenter getPresenter() {
        return null;
    }

}
