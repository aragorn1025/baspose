package com.ehappy.baspost_01;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import java.util.*;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://localhost:8888/Register.php";

    private Map<String,String> params;

    public RegisterRequest(String name, String account, String email, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("account", account);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }



}
