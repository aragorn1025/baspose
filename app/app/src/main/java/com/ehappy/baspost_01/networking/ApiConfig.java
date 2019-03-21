package com.ehappy.baspost_01.networking;
import android.util.Log;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;


public interface ApiConfig {

    @Multipart
    @POST("videoR.php")
    Call<ServerResponse> upload(
            @Header("Authorization") String authorization,
            @PartMap Map<String, RequestBody> map
    );

//    Call<ServerResponse> upload(
//
//
//            try {
//
//                // 创建Socket对象 & 指定服务端的IP 及 端口号
//                socket = new Socket("140.115.51.181", 30708);
//
//                // 判断客户端和服务器是否连接成功
//                System.out.println(socket.isConnected());
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//    );

}
