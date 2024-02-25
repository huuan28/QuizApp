package com.example.quizapp.model;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {
    String examinee;
    String examCode;
    int takeNum;
    double score;
    Date time;

    public String getExaminee() {
        return examinee;
    }

    public void setExaminee(String examinee) {
        this.examinee = examinee;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public int getTakeNum() {
        return takeNum;
    }

    public void setTakeNum(int takeNum) {
        this.takeNum = takeNum;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Result(String examinee, String examCode, int takeNum, double score, Date time) {
        this.examinee = examinee;
        this.examCode = examCode;
        this.takeNum = takeNum;
        this.score = score;
        this.time = time;
    }

    public Result() {
    }
}
