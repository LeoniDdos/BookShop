package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.adapter.BookAdapter
import com.libertystudio.bookshop.entity.Book
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.*

class SearchFragment : BaseFragment() {
    private var bookAdapter: BookAdapter? = null
    private var mainActivity: MainActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        setTitle("Поиск")

        mainActivity = activity as MainActivity?
        btnSearchDo?.setOnClickListener {
            etSearchTitle?.visibility = View.INVISIBLE
            btnSearchDo?.visibility = View.INVISIBLE
            val foundBooks = ArrayList<Book>()
            for (itrBook in mainActivity!!.listBooks) {
                if (etSearchTitle?.text.toString() == itrBook.title) {
                    foundBooks.add(itrBook)
                }
            }
            val bookAdapter = BookAdapter(context!!, foundBooks)
            lvSearchBooks?.adapter = bookAdapter
            Toast.makeText(mainActivity, "Поиск завершён. Количество: " + foundBooks.size, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initListView() {
        bookAdapter = BookAdapter(context!!, mainActivity!!.listBooks)
        lvSearchBooks!!.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            mainActivity!!.selectedBook = mainActivity!!.listBooks[position]
            startFragment(BookInfoFragment())
        }
        try {
            lvSearchBooks!!.adapter = bookAdapter
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}