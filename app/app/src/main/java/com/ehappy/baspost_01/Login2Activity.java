package com.ehappy.baspost_01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login2Activity extends AppCompatActivity {

    private static String LOGIN_REQUEST_URL ="http://140.115.51.184:40130/login2.php";

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";

    private EditText edusername,edpassword;
    private Button btLogin;
    public ProgressBar loading;
    private TextView forgot,register;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        edusername = findViewById(R.id.etUsername);
        edpassword = findViewById(R.id.etPassword);
        //forgot = findViewById(R.id.etForgot);
        register = findViewById(R.id.etRegister);
        btLogin = findViewById(R.id.btLogin);
        loading = findViewById(R.id.loading);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login2Activity.this,RegisterActivity.class);
                Login2Activity.this.startActivity(registerIntent);

            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }

        });
    }

    private void userLogin() {


        loading.setVisibility(View.VISIBLE);
        btLogin.setVisibility(View.GONE);

        username = edusername.getText().toString().trim();
        password = edpassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_REQUEST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            //openProfile();
                            loading.setVisibility(View.GONE);
                            Toast.makeText(Login2Activity.this,response,Toast.LENGTH_LONG).show();

                            openProfile();
//                            Intent Intent = new Intent(Login2Activity.this,MainActivity.class);
//                            Login2Activity.this.startActivity(Intent);

                        }else{
                            loading.setVisibility(View.GONE);
                            btLogin.setVisibility(View.VISIBLE);
                            Toast.makeText(Login2Activity.this,response,Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        btLogin.setVisibility(View.VISIBLE);
                        Toast.makeText(Login2Activity.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,username);
                map.put(KEY_PASSWORD,password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void openProfile(){
        Intent intent = new Intent(this, ActivityUserProfile.class);
        intent.putExtra(KEY_USERNAME, username);
        startActivity(intent);
    }

}
