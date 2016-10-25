package ru.skillbranch.ui.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import ru.skillbranch.data.network.DataManager;
import ru.skillbranch.data.utils.ConstantManager;
import ru.skillbranch.data.utils.ViewPagerAdapter;
import ru.skillbranch.mvp.presenter.CharacterListScreenPresenter;
import ru.skillbranch.got.R;
import ru.skillbranch.mvp.view.ICharacterListView;
import ru.skillbranch.ui.fragments.HouseListFragment;

import static ru.skillbranch.got.R.id.navigationView;

public class CharacterListScreen extends BaseActivity implements ICharacterListView {
    CharacterListScreenPresenter mCharacterListScreenPresenter = CharacterListScreenPresenter.getInstance();

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private DataManager mDataManager;
    private LinearLayout mLinearLayout;
    private DrawerLayout mNavigationDrawer;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list_screen);
        mDataManager = DataManager.getInstance();

        mCharacterListScreenPresenter.takeView(this);
        mCharacterListScreenPresenter.initView();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mLinearLayout = (LinearLayout) findViewById(R.id.linearSel);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigationDrawer);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        setupToolbar();
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(HouseListFragment.newInstance(ConstantManager.STARKS_HOUSE_ID), getString(R.string.starkHouse));
        adapter.addFragment(HouseListFragment.newInstance(ConstantManager.LANNISTERS_HOUSE_ID), getString(R.string.lannistersHouse));
        adapter.addFragment(HouseListFragment.newInstance(ConstantManager.TARGARYENS_HOUSE_ID), getString(R.string.tangaryensHouse));
        viewPager.setAdapter(adapter);
    }

    @Override
    public ICharacterListView getPresenter() {
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home) {
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Starks:
                        mViewPager.setCurrentItem(ConstantManager.STARKS_HOUSE_ID);
                        mNavigationDrawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Lannisters:
                        mViewPager.setCurrentItem(ConstantManager.LANNISTERS_HOUSE_ID);
                        mNavigationDrawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Tangaryens:
                        mViewPager.setCurrentItem(ConstantManager.TARGARYENS_HOUSE_ID);
                        mNavigationDrawer.closeDrawer(GravityCompat.START);
                        break;
                    default:
                        break;
                }
                item.setChecked(true);
                return false;
            }
        });

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }



}
