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
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.*

class SearchFragment : BaseFragment() {
    private var bookAdapter = BookAdapter()
    private var mainActivity: MainActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity = activity as MainActivity?

        initAdapter()
        initView()
    }

    private fun initAdapter() {
        bookAdapter.callback = object : BaseAdapterCallback<Book> {
            override fun onItemClick(item: Book) {
                startFragment(BookInfoFragment.newInstance(item))
            }
        }
    }

    private fun initView() {
        setTitle("Поиск")

        rvSearchBooks?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }

        btnSearchDo?.setOnClickListener {
            etSearchTitle?.visibility = View.INVISIBLE
            btnSearchDo?.visibility = View.INVISIBLE
            val foundBooks = ArrayList<Book>()
            for (itrBook in mainActivity!!.listBooks) {
                if (etSearchTitle?.text.toString() == itrBook.title) {
                    foundBooks.add(itrBook)
                }
            }

            bookAdapter.setDataList(foundBooks)

            Toast.makeText(mainActivity, "Поиск завершён. Количество: " + foundBooks.size, Toast.LENGTH_SHORT).show()
        }
    }
}