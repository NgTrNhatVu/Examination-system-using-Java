/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nv.entity;

import java.util.Set;

/**
 *
 * @author pc
 */
public class QuestionSet {

    private int id;
    private String title;
    private String description;
    private String date;
    private String image;
    private int status;
    private Set<Question> questions;

    public QuestionSet(String title, String description, String date, String image, int status, Set<Question> questions) {
        this(0, title, description, date,image, status, questions);
    }

    public QuestionSet(int id, String title, String description, String date, String image, int status, Set<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.image = image;
        this.status = status;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public int getStatus() {
        return status;
    }

    public Set<Question> getQuestions() {
        return questions;
    }
    
}
