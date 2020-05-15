package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R

class PurchaseFragment : BaseFragment() {
    private var mainActivity: MainActivity? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_purchase, container, false)
        initElements(view)
        return view
    }

    private fun initElements(view: View) {
        mainActivity = activity as MainActivity?

        val tvBooksCount = view.findViewById<TextView>(R.id.tvBooksCount)
        val tvSum = view.findViewById<TextView>(R.id.tvSum)

        tvBooksCount.text = mainActivity!!.listBasketBooks.size.toString()
        tvSum.text = mainActivity!!.basketSum.toString() + " руб."

        mainActivity!!.listBasketBooks.clear()
    }
}