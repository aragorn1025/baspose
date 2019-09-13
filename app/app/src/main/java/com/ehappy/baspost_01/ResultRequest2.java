package com.ehappy.baspost_01;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ResultRequest2 extends StringRequest {

    private static final String RESULT_REQUEST_URL = "http://140.115.51.184:40130/result_layup_test.php";
    private Map<String, String> params;

    public ResultRequest2(String filename, Response.Listener<String> listener) {
        super(Method.POST, RESULT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("filename", filename);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
