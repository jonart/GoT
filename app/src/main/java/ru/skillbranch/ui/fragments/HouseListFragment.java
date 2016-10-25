package ru.skillbranch.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.annotation.Nullable;

import ru.skillbranch.data.RecyclerAdapter;
import ru.skillbranch.data.utils.ConstantManager;
import ru.skillbranch.mvp.presenter.FragmentPresenter;
import ru.skillbranch.mvp.presenter.IFragmentPresenter;
import ru.skillbranch.data.network.DataManager;
import ru.skillbranch.data.network.database.Member;
import ru.skillbranch.mvp.view.IFragmentView;
import ru.skillbranch.ui.activity.CharacterScreen;
import ru.skillbranch.got.R;

/**
 * Created by root on 20.10.2016.
 */

public class HouseListFragment extends Fragment implements IFragmentView{
    FragmentPresenter mFragmentPresenter = FragmentPresenter.getInstance();

    private DataManager mDataManager;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;
    private List<Member> mMembers;
    private RecyclerAdapter mRecyclerAdapter;
    private Member mMember;


    public HouseListFragment() {
    }


    public static HouseListFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt(ConstantManager.HOUSE_ID,id);
        HouseListFragment fragment = new HouseListFragment();
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
        mFragmentPresenter.takeView(this);
        mFragmentPresenter.initView();
        int id = getArguments().getInt(ConstantManager.HOUSE_ID);
        mMembers = mFragmentPresenter.getUser(id);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        showUsers(mMembers);

        return view;
    }

    public void showUsers(List<Member> members){
        mMembers = members;

        mRecyclerAdapter = new RecyclerAdapter(mMembers, getArguments().getInt(ConstantManager.HOUSE_ID), new RecyclerAdapter.MemberViewHolder.CustomClickListener(){
            @Override
            public void onUserItemClickListener(int position){
                Intent profileIntent = new Intent(getActivity(), CharacterScreen.class);
                profileIntent.putExtra(ConstantManager.PARCELABLE_KEY, mMembers.get(position).getUrl());

                startActivity(profileIntent);
            }

        });

        mRecyclerView.swapAdapter(mRecyclerAdapter, false);
    }


    @Override
    public IFragmentPresenter getPresenter() {
        return null;
    }
}
