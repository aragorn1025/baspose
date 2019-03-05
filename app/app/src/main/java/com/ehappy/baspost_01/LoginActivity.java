package com.ehappy.baspost_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    private EditText username,password;
    private Button btLogin;
    private ProgressBar loading;
    private TextView forgot,register;
    private static String URL_Login = "http://10.96.21.231/login2018.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        forgot = findViewById(R.id.etForgot);
        register = findViewById(R.id.etRegister);
        btLogin = findViewById(R.id.btLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);

            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String musername = username.getText().toString().trim();
                final String mpassword = password.getText().toString().trim();

                if(!musername.isEmpty() || !mpassword.isEmpty())
                {
                    Login(musername,mpassword);
                }
                else
                {
                    username.setError("Please insert username.");
                    password.setError("Please insert password.");
                }

            }
        });




    }

    private void Login(final String username,final String password) {

        loading.setVisibility(View.VISIBLE);
        btLogin.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_Login,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if(success.equals("1"))
                            {
                                for(int i=0; i<jsonArray.length(); i++)
                                {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String nickname = object.getString("nickname").trim();
                                    String username = object.getString("username").trim();

                                    Toast.makeText(LoginActivity.this,"Success Login. \nYour nickname : "+nickname+"\nYour username : "+username,Toast.LENGTH_SHORT).show();

                                    loading.setVisibility(View.GONE);

                                }
                            }



                        }catch(JSONException e) {
                            e.printStackTrace();
                            loading.setVisibility(View.GONE);
                            btLogin.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this,"Error"+e.toString(),Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        loading.setVisibility(View.GONE);
                        btLogin.setVisibility(View.VISIBLE);
                        Toast.makeText(LoginActivity.this,"Error"+error.toString(),Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{

                Map<String,String> params = new HashMap<>();
                params.put("username",username);
                params.put("password",password);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



}
