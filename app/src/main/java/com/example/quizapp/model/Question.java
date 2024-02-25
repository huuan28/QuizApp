package com.example.quizapp.model;

import java.io.Serializable;

public class Question implements Serializable {
    int id;
    int segNum;
    String content;
    String optA;
    String optB;
    String optC;
    String optD;
    int corrAns;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSegNum() {
        return segNum;
    }

    public void setSegNum(int segNum) {
        this.segNum = segNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOptA() {
        return optA;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public String getOptB() {
        return optB;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptC() {
        return optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getOptD() {
        return optD;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public int getCorrAns() {
        return corrAns;
    }

    public void setCorrAns(int corrAns) {
        this.corrAns = corrAns;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    String examCode;

    public Question() {
    }

    public Question(int id, int segNum, String content, String optA, String optB, String optC, String optD, int corrAns, String examCode) {
        this.id = id;
        this.segNum = segNum;
        this.content = content;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.corrAns = corrAns;
        this.examCode = examCode;
    }
}
