package ru.skillbranch.data;

/**
 * Created by root on 18.10.2016.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import ru.skillbranch.data.storage.models.UserModelRes;
import ru.skillbranch.data.storage.models.HouseModelRes;


/**
 * Created by root on 17.10.2016.
 */

public interface RestApi {

    @GET
    Call<HouseModelRes> getHouse(@Url String url);

    @GET
    Call<UserModelRes> callMember(@Url String url);
}