package com.postgrad.management.entity;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ProgressUpdate {
    private Date date;
    private String content;

    // Constructor
    public ProgressUpdate(Date date, String content) {
        this.date = date;
        this.content = content;
    }

    // Getters and Setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM, yyyy (EEE)");
        return "Progress Update:\n" +
               "-----------------------------\n" +
               "Date    : " + dateFormatter.format(date) + "\n" +
               "Content : " + content + "\n" +
               "-----------------------------";
    }
}