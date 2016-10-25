package ru.skillbranch.mvp.model;

import android.content.Context;

import ru.skillbranch.data.network.DataManager;
import ru.skillbranch.data.network.database.DaoSession;
import ru.skillbranch.data.network.database.Member;
import ru.skillbranch.data.network.database.MemberDao;

/**
 * Created by root on 23.10.2016.
 */

public class CharacterScreenModel {
    private DataManager mDataManager;
    private DaoSession mDaoSession;
    private Context mContext;

    public CharacterScreenModel(){
        mDataManager = DataManager.getInstance();
        mContext = mDataManager.getContext();
        mDaoSession = mDataManager.getDaoSession();
    }

    public Member getUserByQuery(String url){

        Member member = mDaoSession.queryBuilder(Member.class)
                .where(MemberDao.Properties.Url.eq(url))
                .build()
                .unique();
        return member;
    }
}
