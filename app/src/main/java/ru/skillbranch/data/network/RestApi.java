package ru.skillbranch.data.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import ru.skillbranch.data.network.responses.UserModelRes;
import ru.skillbranch.data.network.responses.HouseModelRes;

public interface RestApi {

    @GET
    Call<HouseModelRes> getHouse(@Url String url);

    @GET
    Call<UserModelRes> getMember(@Url String url);
}