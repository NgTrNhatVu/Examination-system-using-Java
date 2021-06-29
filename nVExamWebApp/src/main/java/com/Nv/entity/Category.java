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
public class Category {
    private int id;
    private String title;
    private String img;

    public Category(String catTitle){
        this(0, catTitle, null);
    }
    public Category(String catTitle, String catImg){
        this(0, catTitle, catImg);
    }
    
    public Category(int catId, String catTitle) {
        this(catId, catTitle, null);
    }
    
    public Category(int catId, String catTitle, String catImg) {
        this.id = catId;
        this.title = catTitle;
        this.img = catImg;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }
    
    
    
}
