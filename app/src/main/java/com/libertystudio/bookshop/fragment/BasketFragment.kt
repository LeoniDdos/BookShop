package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.adapter.BookAdapter
import kotlinx.android.synthetic.main.fragment_basket.*

class BasketFragment : BaseFragment() {
    private var mainActivity: MainActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        setTitle("Корзина")

        mainActivity = activity as MainActivity?
        lvBasketBooks?.adapter = BookAdapter(mainActivity, mainActivity!!.listBasketBooks)
        tvBasketSum?.text = mainActivity!!.basketSum.toString() + " руб."
        btnBasketBuy?.setOnClickListener {
//            Toast.makeText(mainActivity, "Книги успешно куплены", Toast.LENGTH_SHORT).show()
//            mainActivity.getListBasketBooks().clear()
//            lvBasketBooks.setAdapter(new BookAdapter(mainActivity, mainActivity.getListBasketBooks()))
//            tvSum.setText(String.valueOf(mainActivity.getBasketSum()) + " руб.")
            if (mainActivity!!.listBasketBooks.size > 0) {
                startFragment(PurchaseFragment())
            } else {
                Toast.makeText(mainActivity, "В корзине отсутствуют книги", Toast.LENGTH_SHORT).show()
            }
        }
    }
}