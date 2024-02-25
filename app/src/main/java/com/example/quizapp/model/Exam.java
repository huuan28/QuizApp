package com.example.quizapp.model;

import java.io.Serializable;

public class Exam implements Serializable {
    String code;
    String title;
    String topic;
    String creator;

    //
    public Exam(){}

    public Exam(String code, String title, String topic, String creator) {
        this.code = code;
        this.title = title;
        this.topic = topic;
        this.creator = creator;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
