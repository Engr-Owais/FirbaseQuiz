package com.example.firbasequiz;

public class Books {
    private String correctindex;
    private String question;
    private String opt1;
    private String opt2;
    private String  opt3;

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    private  double points;

    public Books() {

    }

    public Books(String correctindex, String question, String opt1, String opt2, String opt3) {
        this.correctindex = correctindex;
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
    }

    public String getcorrectindex() {
        return correctindex;
    }

    public void setcorrectindex(String correctindex) {
        this.correctindex = correctindex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }
}
