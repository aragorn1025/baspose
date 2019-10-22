package com.ehappy.baspost_01;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NICKNAME = "nickname";

    private EditText editTextUsername,editTextPassword,editTextEmail,editTextnickname;
    private Button btnRegister,loginbt;
    private ProgressBar loading;
    //private static String REGISTER_REQUEST_URL = "http://10.96.21.231/register2018.php";
    //private static String REGISTER_REQUEST_URL ="http://192.168.1.162:8888/register2018.php";
    private static String REGISTER_REQUEST_URL ="http://140.115.51.184:40130/registerV2.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.etUsername);
        editTextPassword = findViewById(R.id.etPassword);
        editTextnickname = findViewById(R.id.etNickname);
        editTextEmail = findViewById(R.id.etEmail);
        btnRegister = findViewById(R.id.btRegister);
        loginbt = findViewById(R.id.loginbt);
        loading = findViewById(R.id.loading);

        // Listening to Login Screen link
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Regist();
            }

        });

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToLogin();
            }
        });

    }


        private void Regist() {

            loading.setVisibility(View.VISIBLE);
            btnRegister.setVisibility(View.GONE);

            final String username = editTextUsername.getText().toString().trim();
            final String password = editTextPassword.getText().toString().trim();
            final String email = editTextEmail.getText().toString().trim();
            final String nickname = editTextnickname.getText().toString().trim();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_REQUEST_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            loading.setVisibility(View.GONE);
                            Toast.makeText(RegisterActivity.this,response,Toast.LENGTH_LONG).show();

                            changeToLogin();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(RegisterActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                            loading.setVisibility(View.GONE);
                            btnRegister.setVisibility(View.VISIBLE);
                        }
                    }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                    params.put(KEY_USERNAME,username);
                    params.put(KEY_PASSWORD,password);
                    params.put(KEY_EMAIL, email);
                    params.put(KEY_NICKNAME, nickname);
                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }


        private void changeToLogin(){
            Intent loginIntent = new Intent(RegisterActivity.this,Login2Activity.class);
            RegisterActivity.this.startActivity(loginIntent);

        }

}

