package com.libertystudio.bookshop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.libertystudio.bookshop.MainActivity;
import com.libertystudio.bookshop.R;
import com.libertystudio.bookshop.data.Book;
import com.libertystudio.bookshop.data.BookAdapter;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    private TextView etSearchTitle;
    private Button btnSearch;

    private BookAdapter bookAdapter;

    private MainActivity mainActivity;

    private ListView lvSearchBooks;

    public SearchFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        initElements(view);

        return view;
    }

    private void initElements(View view) {
        mainActivity = (MainActivity) getActivity();

        etSearchTitle = view.findViewById(R.id.etSearchTitle);
        btnSearch = view.findViewById(R.id.btnSearch);
        lvSearchBooks = view.findViewById(R.id.lvSearchBooks);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearchTitle.setVisibility(View.INVISIBLE);
                btnSearch.setVisibility(View.INVISIBLE);

                ArrayList<Book> foundBooks = new ArrayList<>();

                for (Book itrBook : mainActivity.getListBooks()) {
                    if (etSearchTitle.getText().toString().equals(itrBook.getTitle())) {
                        foundBooks.add(itrBook);
                    }
                }

                BookAdapter bookAdapter = new BookAdapter(mainActivity, foundBooks);
                lvSearchBooks.setAdapter(bookAdapter);

                Toast.makeText(mainActivity, "Поиск завершён. Количество: " + foundBooks.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initListView() {
        bookAdapter = new BookAdapter(getActivity(), mainActivity.getListBooks());

        lvSearchBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainActivity.setSelectedBook(mainActivity.getListBooks().get(position));

                Fragment fragmentBookInfo = new BookInfoFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, fragmentBookInfo).commit();
                mainActivity.setTitle("О книге");
            }
        });

        try {
            lvSearchBooks.setAdapter(bookAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}