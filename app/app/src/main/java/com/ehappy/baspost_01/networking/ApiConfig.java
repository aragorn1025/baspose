package com.ehappy.baspost_01.networking;

import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

//create a java interface inside api package and name it APIService.java.
// Here we will define all the API calls
public interface ApiConfig {

    @Multipart
    @POST("video_path.php")
    Call<ServerResponse> upload(
            @Header("Authorization") String authorization,
            @PartMap Map<String, RequestBody> map
    );

    Call<ServerResponse> upload_class(
            @Query("type")int type
    );

}
