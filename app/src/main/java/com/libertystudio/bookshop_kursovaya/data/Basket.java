package com.libertystudio.bookshop_kursovaya.data;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}