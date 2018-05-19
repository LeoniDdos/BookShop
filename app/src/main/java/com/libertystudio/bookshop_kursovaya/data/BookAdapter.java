package com.libertystudio.bookshop_kursovaya.data;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.libertystudio.bookshop_kursovaya.R;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {
    private ArrayList<Book> books;
    private static LayoutInflater inflater = null;

    public BookAdapter(Activity context, ArrayList<Book> books) {
        this.books = books;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.list_item, null) : itemView;
        TextView tvTitle = itemView.findViewById(R.id.textViewTitle);
        TextView tvPrice = itemView.findViewById(R.id.textViewPrice);
        Book selectedBook = books.get(position);
        tvTitle.setText(selectedBook.getTitle() + " (" + selectedBook.getAuthor().getSurname() + " " + selectedBook.getAuthor().getName().substring(0,1) + ".)");
        tvPrice.setText(String.valueOf(selectedBook.getPrice()) + " руб.");

        return itemView;
    }
}