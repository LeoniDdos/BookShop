package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.adapter.BaseAdapterCallback
import com.libertystudio.bookshop.adapter.BookAdapter
import com.libertystudio.bookshop.entity.Book
import kotlinx.android.synthetic.main.fragment_books.*

class BooksFragment : BaseFragment() {
    private var mainActivity: MainActivity? = null

    private val bookAdapter = BookAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity = activity as MainActivity?

        initAdapter()
        initView()
    }

    private fun initAdapter() {
        bookAdapter.setDataList(mainActivity!!.listBooks)
        bookAdapter.callback = object : BaseAdapterCallback<Book> {
            override fun onItemClick(item: Book) {
                startFragment(BookInfoFragment.newInstance(item))
            }
        }
    }

    private fun initView() {
        setTitle(resources.getString(R.string.fragment_books_title))

        rvBooks?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }
    }
}