package com.ehappy.baspost_01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder>{

    private Context context;
    private List<Feedback> list;

    public FeedbackAdapter(Context context, List<Feedback> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.single_feedback, parent ,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Feedback feedback = list.get(i);

        viewHolder.textAngle.setText(String.valueOf(feedback.getAngle()));
        viewHolder.textJudge.setText(feedback.getJudge());
        viewHolder.textComment.setText(feedback.getComment());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textAngle, textJudge,textComment;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textAngle = itemView.findViewById(R.id.main_angle);
            textJudge = itemView.findViewById(R.id.main_judge);
            textComment = itemView.findViewById(R.id.main_comment);
        }
    }
}
