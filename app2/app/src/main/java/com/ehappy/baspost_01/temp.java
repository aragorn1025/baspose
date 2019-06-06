package com.ehappy.baspost_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class temp extends AppCompatActivity {

    private String url = "http://172.20.10.4:8888/judge.json";

    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;

    private List<Feedback> feedbackList;
    private RecyclerView.Adapter adapter;
    public ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        mList = findViewById(R.id.main_list);

        feedbackList = new ArrayList<>();
        adapter = new FeedbackAdapter(getApplicationContext(),feedbackList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        dividerItemDecoration = new DividerItemDecoration(mList.getContext(),linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        getData();
    }

    private void getData(){

        progressBar = findViewById(R.id.progress_id);
        progressBar.setVisibility(View.VISIBLE);


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Feedback feedback = new Feedback();
                        feedback.setAngle(jsonObject.getDouble("angle"));
                        feedback.setJudge(jsonObject.getString("judge"));
                        feedback.setComment(jsonObject.getString("comment"));

                        feedbackList.add(feedback);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressBar.setVisibility(View.INVISIBLE);

                    }
                }
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley",error.toString());
                progressBar.setVisibility(View.INVISIBLE);

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }
}
