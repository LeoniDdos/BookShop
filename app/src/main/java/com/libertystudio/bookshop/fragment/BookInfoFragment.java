package com.libertystudio.bookshop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.libertystudio.bookshop.MainActivity;
import com.libertystudio.bookshop.R;
import com.libertystudio.bookshop.data.Book;

public class BookInfoFragment extends Fragment {
    private MainActivity mainActivity;

    private Book selectedBook;

    private Button btnAddToBasket;

    public BookInfoFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_info, container, false);
        initElements(view);

        return view;
    }

    private void initElements(View view) {
        mainActivity = (MainActivity) getActivity();
        selectedBook = mainActivity.getSelectedBook();

        TextView tvTitle = view.findViewById(R.id.tvInfoTitle);
        TextView tvAuthor = view.findViewById(R.id.tvInfoAuthor);
        TextView tvYear = view.findViewById(R.id.tvInfoYear);
        TextView tvDescription = view.findViewById(R.id.tvInfoDescription);
        TextView tvPrice = view.findViewById(R.id.tvInfoPrice);

        tvTitle.setText(selectedBook.getTitle());
        tvAuthor.setText(selectedBook.getAuthor().getName() + " " + selectedBook.getAuthor().getSurname());
        tvYear.setText(String.valueOf(selectedBook.getYear()));
        tvDescription.setText(selectedBook.getDescription());
        tvPrice.setText(selectedBook.getPrice() + " рублей");

        btnAddToBasket = view.findViewById(R.id.btnAddToBasket);
        btnAddToBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.getListBasketBooks().add(mainActivity.getSelectedBook());
                Toast.makeText(mainActivity, "Книга добавлена в корзину", Toast.LENGTH_SHORT).show();
            }
        });
    }
}