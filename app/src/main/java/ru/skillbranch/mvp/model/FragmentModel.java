package ru.skillbranch.mvp.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ru.skillbranch.utils.ConstantManager;
import ru.skillbranch.data.managers.DataManager;
import ru.skillbranch.data.storage.models.DaoSession;
import ru.skillbranch.data.storage.models.Member;
import ru.skillbranch.data.storage.models.MemberDao;

public class FragmentModel {
    private DataManager mDataManager;
    private DaoSession mDaoSession;

    public FragmentModel(){
        mDataManager = DataManager.getInstance();
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
