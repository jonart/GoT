package ru.skillbranch.mvp.model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.skillbranch.data.managers.DataManager;
import ru.skillbranch.data.network.responses.HouseModelRes;
import ru.skillbranch.data.network.responses.UserModelRes;
import ru.skillbranch.data.storage.models.DaoSession;
import ru.skillbranch.data.storage.models.Member;

public class SplashModel {
    private DataManager mDataManager;
    private DaoSession mDaoSession;

    public SplashModel() {
        mDataManager = DataManager.getInstance();
        mDaoSession = mDataManager.getDaoSession();
    }

    public boolean isDbEmpty() {
        return mDaoSession.queryBuilder(Member.class).build().list().isEmpty();
    }

    public void loadUsersToDB() {

        List<String> listHouse = new ArrayList<>();
        listHouse.add("houses/229");
        listHouse.add("houses/362");
        listHouse.add("houses/378");

        for (int i = 0; i < listHouse.size(); i++) {
            Call<HouseModelRes> call = mDataManager.getHouse(listHouse.get(i));
            call.enqueue(new Callback<HouseModelRes>() {
                @Override
                public void onResponse(Call<HouseModelRes> call, Response<HouseModelRes> response) {
                    if (response.code() == 200) {
                        List<String> list = response.body().getSwornMembers();
                        String words = response.body().getWords();
                        for (int i = 0; i < list.size(); i++) {
                            loadMember(list.get(i), words);
                        }
                    } else {
                        System.out.println(":-(");
                    }
                }

                @Override
                public void onFailure(Call<HouseModelRes> call, Throwable t) {
                    System.out.println("FUCK");
                }
            });
        }
    }

    private void loadMember(String url, final String words) {
        Call<UserModelRes> callMember = mDataManager.getMember(url);
        callMember.enqueue(new Callback<UserModelRes>() {
            @Override
            public void onResponse(Call<UserModelRes> call, Response<UserModelRes> response) {
                if (response.code() == 200) {
                    Member members = new Member(response.body(), words);
                    mDaoSession.getMemberDao().insertOrReplace(members);
                }
            }

            @Override
            public void onFailure(Call<UserModelRes> call, Throwable t) {
                System.out.println("FUCK");
            }
        });
    }
}
