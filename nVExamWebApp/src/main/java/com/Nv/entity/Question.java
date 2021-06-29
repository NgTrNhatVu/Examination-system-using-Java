/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nv.entity;

/**
 *
 * @author pc
 */
public class Question {

    private int id;
    private String quesDes;
    private String correctAns;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String opt5;
    private String opt6;
    private int catID;
    private int status;

    public Question(String ques, String correctAns, String a, String b, String c, String d, String e, String f, int catID, int status) {
        this(0, ques, correctAns, a, b, c, d, e, f, catID, status);
    }

    public Question(int id, String quesDes, String correctAns, String opt1, String opt2, String opt3, String opt4, String opt5, String opt6, int catID, int status) {
        this.id = id;
        this.quesDes = quesDes;
        this.correctAns = correctAns;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.opt5 = opt5;
        this.opt6 = opt6;
        this.catID = catID;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getQuesDes() {
        return quesDes;
    }

    public String getCorrectAns() {
        return correctAns;
    }
    
    public String[] getCorrectAnsArr(){
        String[] result = this.correctAns.split("");
        return result;
    }

    public String getOpt1() {
        return opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public String getOpt5() {
        return opt5;
    }

    public String getOpt6() {
        return opt6;
    }

    public int getCatID() {
        return catID;
    }

    public int getStatus() {
        return status;
    }

}
