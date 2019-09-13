package com.ehappy.baspost_01.networking;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiConfig2 {

//    Call<ServerResponse> upload_class(
//            @Query("type")int type
//    );

    @FormUrlEncoded
    //@POST("/user/index.php")
    @POST("upload_class.php")
    Call<Classtype> insertData(@Field("type") int type);
}
