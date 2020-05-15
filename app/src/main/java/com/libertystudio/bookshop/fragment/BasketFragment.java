package com.libertystudio.bookshop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.libertystudio.bookshop.MainActivity;
import com.libertystudio.bookshop.R;
import com.libertystudio.bookshop.adapter.BookAdapter;

public class BasketFragment extends BaseFragment {
    private MainActivity mainActivity;
    private ListView lvBasketBooks;
    private TextView tvSum;
    private Button btnBuy;

    public BasketFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basket, container, false);
        initElements(view);

        return view;
    }

    private void initElements(View view) {
        mainActivity = (MainActivity) getActivity();

        lvBasketBooks = view.findViewById(R.id.lvBasketBooks);
        lvBasketBooks.setAdapter(new BookAdapter(mainActivity, mainActivity.getListBasketBooks()));

        tvSum = view.findViewById(R.id.tvSum);
        tvSum.setText(mainActivity.getBasketSum() + " руб.");

        btnBuy = view.findViewById(R.id.buttonBuy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mainActivity, "Книги успешно куплены", Toast.LENGTH_SHORT).show();
//                mainActivity.getListBasketBooks().clear();
//                lvBasketBooks.setAdapter(new BookAdapter(mainActivity, mainActivity.getListBasketBooks()));
//                tvSum.setText(String.valueOf(mainActivity.getBasketSum()) + " руб.");

                if (mainActivity.getListBasketBooks().size() > 0) {
                    startFragment(new PurchaseFragment());
                    mainActivity.setTitle("Успешная покупка");
                }
                else {
                    Toast.makeText(mainActivity, "В корзине отсутствуют книги", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}