package com.libertystudio.bookshop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.libertystudio.bookshop.MainActivity;
import com.libertystudio.bookshop.R;
import com.libertystudio.bookshop.data.BookAdapter;

public class BooksFragment extends BaseFragment {
    private ListView lvBooks;

    private MainActivity mainActivity;

    public BooksFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);
        initElements(view);

        return view;
    }

    private void initElements(View view) {
        mainActivity = (MainActivity) getActivity();

        lvBooks = view.findViewById(R.id.lv_books);
        lvBooks.setAdapter(new BookAdapter(mainActivity, mainActivity.getListBooks()));
        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainActivity.setSelectedBook(mainActivity.getListBooks().get(position));
                mainActivity.setTitle("О книге");

                Fragment fragmentBookInfo = new BookInfoFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, fragmentBookInfo).commit();
            }
        });
    }
}