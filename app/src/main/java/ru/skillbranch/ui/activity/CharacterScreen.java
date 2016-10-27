package ru.skillbranch.ui.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ru.skillbranch.utils.ConstantManager;
import ru.skillbranch.got.R;
import ru.skillbranch.mvp.presenter.CharacterScreenPresenter;
import ru.skillbranch.data.managers.DataManager;
import ru.skillbranch.data.storage.models.Member;

public class CharacterScreen extends BaseActivity {
    CharacterScreenPresenter mCharacterScreenPresenter = CharacterScreenPresenter.getInstance();

    private Toolbar mToolbar;
    private TextView mWords, mBorn, mTitles, mAliases, mFather, mMother;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView mHouseImg;
    private Member mMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mHouseImg = (ImageView) findViewById(R.id.house_img);
        mWords = (TextView) findViewById(R.id.character_word);
        mBorn = (TextView) findViewById(R.id.character_born);
        mTitles = (TextView) findViewById(R.id.character_titles);
        mAliases = (TextView) findViewById(R.id.character_aliases);
        mFather = (TextView) findViewById(R.id.character_father);
        mMother = (TextView) findViewById(R.id.character_mother);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        setupToolbar();
        initProfileData();
    }


    public void initProfileData(){
        String url = getIntent().getStringExtra(ConstantManager.URL_KEY);
        mMember = mCharacterScreenPresenter.getUserData(url);

        switch (mMember.getWords()){
            case ConstantManager.STARKS_WORDS:
                mHouseImg.setImageResource(R.drawable.starkhouse);
                break;
            case ConstantManager.LANNISTERS_WORDS:
                mHouseImg.setImageResource(R.drawable.lanhouse);
                break;
            case ConstantManager.TANGARYENS_WORDS:
                mHouseImg.setImageResource(R.drawable.targarienhouse);
                break;
            default:
                break;
        }
        mWords.setText(mMember.getWords());
        mBorn.setText(mMember.getBorn());
        mTitles.setText(mMember.getTitles());
        mAliases.setText(mMember.getAliases());
        mFather.setText(mMember.getFather());
        mMother.setText(mMember.getMother());
        if(!mMember.getDied().isEmpty()){
            Toast.makeText(this,"Персонаж погиб " + mMember.getDied(),Toast.LENGTH_LONG).show();
        }

        mCollapsingToolbarLayout.setTitle(mMember.getName());
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


}
