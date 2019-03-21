package com.ehappy.baspost_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText username,password,email,nickname;
    private Button btnRegister;
    private ProgressBar loading;
    //private static String REGISTER_REQUEST_URL = "http://10.96.21.231/register2018.php";
    private static String REGISTER_REQUEST_URL ="http://192.168.1.162:8888/register2018.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        nickname = findViewById(R.id.etNickname);
        email = findViewById(R.id.etEmail);
        btnRegister = findViewById(R.id.btRegister);
        loading = findViewById(R.id.loading);

        // Listening to Login Screen link
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Regist();
            }

        });

    }


        private void Regist() {

            loading.setVisibility(View.VISIBLE);
            btnRegister.setVisibility(View.GONE);

            final String username = this.username.getText().toString().trim();
            final String password = this.password.getText().toString().trim();
            final String nickname = this.nickname.getText().toString().trim();
            final String email = this.email.getText().toString().trim();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_REQUEST_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if(success.equals("1")){
                                Toast.makeText(RegisterActivity.this,"Register Success!",Toast.LENGTH_SHORT).show();
                                loading.setVisibility(View.GONE);

                                Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                                RegisterActivity.this.startActivity(loginIntent);

                            }


                        }catch (JSONException e){

                            e.printStackTrace();
                            Toast.makeText(RegisterActivity.this,"Register Error! "+e.toString(),Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            btnRegister.setVisibility(View.VISIBLE);
                        }



                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(RegisterActivity.this,"Register Error! "+error.toString(),Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            btnRegister.setVisibility(View.VISIBLE);

                        }
                    })


            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<>();

                    params.put("username",username);
                    params.put("password",password);
                    params.put("email",email);
                    params.put("nickname",nickname);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

}

