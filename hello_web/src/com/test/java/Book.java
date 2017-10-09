package com.test.java;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/9/2017
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    private double price;
    private String title;
    private String author;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
