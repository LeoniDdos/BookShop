package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.adapter.BookAdapter

class BasketFragment : BaseFragment() {
    private var mainActivity: MainActivity? = null
    private var lvBasketBooks: ListView? = null
    private var tvSum: TextView? = null
    private var btnBuy: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_basket, container, false)
        initElements(view)
        return view
    }

    private fun initElements(view: View) {
        setTitle("Корзина")

        mainActivity = activity as MainActivity?
        lvBasketBooks = view.findViewById(R.id.lvBasketBooks)
        lvBasketBooks?.setAdapter(BookAdapter(mainActivity, mainActivity!!.listBasketBooks))
        tvSum = view.findViewById(R.id.tvSum)
        tvSum?.setText(mainActivity!!.basketSum.toString() + " руб.")
        btnBuy = view.findViewById(R.id.buttonBuy)
        btnBuy?.setOnClickListener(View.OnClickListener { //                Toast.makeText(mainActivity, "Книги успешно куплены", Toast.LENGTH_SHORT).show();
//                mainActivity.getListBasketBooks().clear();
//                lvBasketBooks.setAdapter(new BookAdapter(mainActivity, mainActivity.getListBasketBooks()));
//                tvSum.setText(String.valueOf(mainActivity.getBasketSum()) + " руб.");
            if (mainActivity!!.listBasketBooks.size > 0) {
                startFragment(PurchaseFragment())
            } else {
                Toast.makeText(mainActivity, "В корзине отсутствуют книги", Toast.LENGTH_SHORT).show()
            }
        })
    }
}