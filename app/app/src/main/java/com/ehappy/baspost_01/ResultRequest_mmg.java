package com.ehappy.baspost_01;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ResultRequest_mmg extends StringRequest {


//    //which class i chose in CaptureShootingActivity.java
//    public static int type;
//    //according to which class he chose, get relative judges
//    type = MainActivity.type;
//    System.out.println("which type?(0:shoot,1:layup_right) : "+type);


    private static final String RESULT_REQUEST_URL = "http://140.115.51.184:40130/mmg_result.php";
    private Map<String, String> params;

    public ResultRequest_mmg(Response.Listener<String> listener) {
        super(Method.POST, RESULT_REQUEST_URL, listener, null);
        params = new HashMap<>();

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
