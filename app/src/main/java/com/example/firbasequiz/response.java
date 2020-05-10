package com.example.firbasequiz;

public class response {
    private  String correctanswer;
    private  double points;
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public response(String correctanswer, double points) {
        this.correctanswer = correctanswer;
        this.points = points;
    }

    public void CalculateScore(double point)
    {
        double finalscore = 0;
        finalscore = point + this.total;
        setTotal(finalscore);
    }


}
