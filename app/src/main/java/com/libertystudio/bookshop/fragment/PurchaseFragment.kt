package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import kotlinx.android.synthetic.main.fragment_purchase.*

class PurchaseFragment : BaseFragment() {
    private var mainActivity: MainActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_purchase, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        setTitle("Успешная покупка")

        mainActivity = activity as MainActivity?

        tvPurchaseBooksCount.text = mainActivity!!.listBasketBooks.size.toString()
        tvPurchaseSum.text = mainActivity!!.basketSum.toString() + " руб."

        mainActivity!!.listBasketBooks.clear()
    }
}