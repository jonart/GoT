package ru.skillbranch.mvp.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ru.skillbranch.data.utils.ConstantManager;
import ru.skillbranch.data.network.DataManager;
import ru.skillbranch.data.network.database.DaoSession;
import ru.skillbranch.data.network.database.Member;
import ru.skillbranch.data.network.database.MemberDao;

/**
 * Created by root on 23.10.2016.
 */

public class FragmentModel {
    private DataManager mDataManager;
    private DaoSession mDaoSession;
    private Context mContext;

    public FragmentModel(){
        mDataManager = DataManager.getInstance();
        mContext = mDataManager.getContext();
        mDaoSession = mDataManager.getDaoSession();
    }

    public List<Member> getUserFromDb(int id){
        List<Member> list = new ArrayList<>();

        try{
            String houseName;
            switch (id){
                case ConstantManager.STARKS_HOUSE_ID:
                    houseName = ConstantManager.STARKS_WORDS;
                    break;
                case ConstantManager.LANNISTERS_HOUSE_ID:
                    houseName = ConstantManager.LANNISTERS_WORDS;
                    break;
                case ConstantManager.TARGARYENS_HOUSE_ID:
                    houseName = ConstantManager.TANGARYENS_WORDS;
                    break;
                default:
                    houseName = null;
            }
            list = mDaoSession.queryBuilder(Member.class)
                    .where(MemberDao.Properties.Words.eq(houseName))
                    .build()
                    .list();

            System.out.println("TAG_" + list.size() + "_");
        }catch (Exception e)
        {
            System.out.println("MyError " + e.toString());
        }

        return list;
    }
}
