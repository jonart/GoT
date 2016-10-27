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

import ru.skillbranch.ui.adapters.RecyclerAdapter;
import ru.skillbranch.utils.ConstantManager;
import ru.skillbranch.mvp.presenter.FragmentPresenter;
import ru.skillbranch.mvp.presenter.IFragmentPresenter;
import ru.skillbranch.data.storage.models.Member;
import ru.skillbranch.mvp.view.IFragmentView;
import ru.skillbranch.ui.activity.CharacterScreen;
import ru.skillbranch.got.R;

public class HouseListFragment extends Fragment implements IFragmentView, RecyclerAdapter.MemberViewHolder.ItemClickListener {
    FragmentPresenter mPresenter = FragmentPresenter.getInstance();

    private List<Member> mMembers;

    public HouseListFragment() {

    }

    public static HouseListFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt(ConstantManager.HOUSE_ID, id);
        HouseListFragment fragment = new HouseListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.takeView(this);
        mPresenter.initView();
        mMembers = mPresenter.getMembers(getArguments().getInt(ConstantManager.HOUSE_ID));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAdapter recyclerAdapter =
                new RecyclerAdapter(mMembers, getArguments().getInt(ConstantManager.HOUSE_ID), this);
        recyclerView.swapAdapter(recyclerAdapter, false);

        return view;
    }

    @Override
    public IFragmentPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showMemberProfile(int position) {
        Intent profileIntent = new Intent(getActivity(), CharacterScreen.class);
        profileIntent.putExtra(ConstantManager.URL_KEY, mMembers.get(position).getUrl());
        startActivity(profileIntent);
    }

    @Override
    public void onUserItemClick(int position) {
        mPresenter.onListItemClick(position);
    }
}
