package com.ehappy.baspost_01;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ErrorRequest extends StringRequest {
    private static final String ERROR_REQUEST_URL = "http://140.115.51.181:40130/error.php";
    private Map<String, String> params;

    public ErrorRequest(String filename, Response.Listener<String> listener) {
        super(Method.POST, ERROR_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("filename", filename);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}