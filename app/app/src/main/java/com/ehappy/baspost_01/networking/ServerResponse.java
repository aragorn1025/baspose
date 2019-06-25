package com.ehappy.baspost_01.networking;
import com.google.gson.annotations.SerializedName;


//create another java class file for model the data that we get from response
public class ServerResponse {
    // variable name should be same as in the json response from php
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }


}
