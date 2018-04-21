package com.libertystudio.bookshop_kursovaya.data;

import io.realm.RealmObject;

public class Book {
    private String title;
    private String description;
    private Author author;
    private int year;
    private double price;

    public Book(String title, Author author) {
        this.title = title;
        this.description = "Очень длинное описание сюжета книги";
        this.author = author;
        this.year = 1850;
        this.price = 150;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}