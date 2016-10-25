package ru.skillbranch.mvp.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.skillbranch.data.RestApi;
import ru.skillbranch.data.storage.models.HouseModelRes;
import ru.skillbranch.data.storage.models.UserModelRes;
import ru.skillbranch.data.network.DataManager;
import ru.skillbranch.data.network.database.DaoSession;
import ru.skillbranch.data.network.database.Member;

/**
 * Created by root on 23.10.2016.
 */

public class SplashModel {
    private DataManager mDataManager;
    private DaoSession mDaoSession;
    private Context mContext;

    public SplashModel(){
        mDataManager = DataManager.getInstance();
        mContext = mDataManager.getContext();
        mDaoSession = mDataManager.getDaoSession();
    }

    public boolean getIsDataNull(){
        List<Member> list;

        list = mDaoSession.queryBuilder(Member.class)
                .build()
                .list();
        if(list.isEmpty()) return true;
        else return false;
    }

    public void addUserToDB() {
        OkHttpClient.Builder okhttp = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        okhttp.addInterceptor(loggingInterceptor);

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("http://anapioficeandfire.com/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder
                .client(okhttp.build())
                .build();

        final RestApi service = retrofit.create(RestApi.class);

        List<String> listHouse = new ArrayList<>();
        listHouse.add("houses/229");
        listHouse.add("houses/362");
        listHouse.add("houses/378");


        for (int i = 0; i < listHouse.size(); i++) {
            Call<HouseModelRes> call = service.getHouse(listHouse.get(i));

            call.enqueue(new Callback<HouseModelRes>() {
                @Override
                public void onResponse(Call<HouseModelRes> call, Response<HouseModelRes> response) {
                    if (response.code() == 200) {


                        List<String> list = response.body().getSwornMembers();
                        final String words = response.body().getWords();
                        System.out.println("_" + words + "_");

                        for (int i = 0; i < list.size(); i++) {
                            Call<UserModelRes> callMember = service.callMember(list.get(i));
                            callMember.enqueue(new Callback<UserModelRes>() {
                                @Override
                                public void onResponse(Call<UserModelRes> call, Response<UserModelRes> response) {
                                    if(response.code() == 200){
                                        Member members = new Member(response.body(), words);
                                        mDaoSession.getMemberDao().insertOrReplace(members);
                                    }
                                    else{

                                    }
                                }

                                @Override
                                public void onFailure(Call<UserModelRes> call, Throwable t) {
                                    System.out.println("FUCK");
                                }
                            });
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
}
