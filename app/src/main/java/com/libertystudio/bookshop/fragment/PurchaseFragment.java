package com.libertystudio.bookshop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.libertystudio.bookshop.MainActivity;
import com.libertystudio.bookshop.R;

public class PurchaseFragment extends Fragment {
    private MainActivity mainActivity;

    public PurchaseFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_purchase, container, false);
        initElements(view);

        return view;
    }

    private void initElements(View view) {
        mainActivity = (MainActivity) getActivity();

        TextView tvBooksCount = view.findViewById(R.id.tvBooksCount);
        TextView tvSum = view.findViewById(R.id.tvSum);

        tvBooksCount.setText(String.valueOf(mainActivity.getListBasketBooks().size()));
        tvSum.setText(mainActivity.getBasketSum() + " руб.");

        mainActivity.getListBasketBooks().clear();
    }
}