package com.ehappy.baspost_01;

public class Feedback {

    public double angle;
    public String judge;
    public String comment;

    public Feedback(){

    }

    public Feedback(float angle, String judge, String comment) {
        this.angle = angle;
        this.judge = judge;
        this.comment = comment;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
