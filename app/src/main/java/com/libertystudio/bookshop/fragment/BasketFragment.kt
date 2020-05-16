package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.adapter.BaseAdapterCallback
import com.libertystudio.bookshop.adapter.BookAdapter
import com.libertystudio.bookshop.entity.Book
import kotlinx.android.synthetic.main.fragment_basket.*

class BasketFragment : BaseFragment() {
    private var mainActivity: MainActivity? = null

    private val bookAdapter = BookAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity = activity as MainActivity?

        initAdapter()
        initView()
    }

    private fun initAdapter() {
        bookAdapter.setDataList(mainActivity!!.listBasketBooks)
        bookAdapter.callback = object : BaseAdapterCallback<Book> {
            override fun onItemClick(item: Book) {
                startFragment(BookInfoFragment.newInstance(item))
            }
        }
    }

    private fun initView() {
        setTitle(resources.getString(R.string.fragment_basket_title))

        rvBasketBooks?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }

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