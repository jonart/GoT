package ru.skillbranch.data.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 20.10.2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{
    private final List<Fragment> mFragmentsList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager){ super(manager);}

    @Override
    public Fragment getItem(int position){ return mFragmentsList.get(position);}

    @Override
    public int getCount(){return mFragmentsList.size();}

    public void addFragment(Fragment fragment, String title){
        mFragmentsList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mFragmentTitleList.get(position);
    }
}