package com.libertystudio.bookshop;

import com.libertystudio.bookshop.entity.Book;

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