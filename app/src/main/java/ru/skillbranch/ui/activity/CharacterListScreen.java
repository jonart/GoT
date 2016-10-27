package ru.skillbranch.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ru.skillbranch.got.R;
import ru.skillbranch.mvp.presenter.CharacterListScreenPresenter;
import ru.skillbranch.mvp.view.ICharacterListView;
import ru.skillbranch.ui.fragments.HouseListFragment;
import ru.skillbranch.utils.ConstantManager;
import ru.skillbranch.utils.ViewPagerAdapter;

import static ru.skillbranch.got.R.id.viewPager;

public class CharacterListScreen extends BaseActivity implements ICharacterListView {

    CharacterListScreenPresenter mPresenter = CharacterListScreenPresenter.getInstance();

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private DrawerLayout mNavigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list_screen);

        mPresenter.takeView(this);
        mPresenter.initView();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigationDrawer);

        setupToolbar();
        setupDrawer();
        setupViewPager();
    }

    @Override
    protected void onDestroy() {
        mPresenter.dropView();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mNavigationDrawer.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawer() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Starks:
                        mPresenter.setHousePage(ConstantManager.STARKS_HOUSE_ID);
                        break;
                    case R.id.Lannisters:
                        mPresenter.setHousePage(ConstantManager.LANNISTERS_HOUSE_ID);
                        break;
                    case R.id.Tangaryens:
                        mPresenter.setHousePage(ConstantManager.TARGARYENS_HOUSE_ID);
                        break;
                }
                mNavigationDrawer.closeDrawer(GravityCompat.START);
                item.setChecked(true);
                return true;
            }
        });
    }

    public void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(HouseListFragment.newInstance(ConstantManager.STARKS_HOUSE_ID), getString(R.string.starkHouse));
        adapter.addFragment(HouseListFragment.newInstance(ConstantManager.LANNISTERS_HOUSE_ID), getString(R.string.lannistersHouse));
        adapter.addFragment(HouseListFragment.newInstance(ConstantManager.TARGARYENS_HOUSE_ID), getString(R.string.tangaryensHouse));
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void setPage(int pageNumber) {
        mViewPager.setCurrentItem(pageNumber);
    }

    @Override
    public CharacterListScreenPresenter getPresenter() {
        return mPresenter;
    }
}
