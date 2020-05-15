package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.adapter.BookAdapter
import com.libertystudio.bookshop.entity.Book
import java.util.*

class SearchFragment : BaseFragment() {
    private var etSearchTitle: TextView? = null
    private var btnSearch: Button? = null
    private var bookAdapter: BookAdapter? = null
    private var mainActivity: MainActivity? = null
    private var lvSearchBooks: ListView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        initElements(view)
        return view
    }

    private fun initElements(view: View) {
        setTitle("Поиск")

        mainActivity = activity as MainActivity?
        etSearchTitle = view.findViewById(R.id.etSearchTitle)
        btnSearch = view.findViewById(R.id.btnSearch)
        lvSearchBooks = view.findViewById(R.id.lvSearchBooks)
        btnSearch?.setOnClickListener(View.OnClickListener {
            etSearchTitle?.setVisibility(View.INVISIBLE)
            btnSearch?.setVisibility(View.INVISIBLE)
            val foundBooks = ArrayList<Book>()
            for (itrBook in mainActivity!!.listBooks) {
                if (etSearchTitle?.getText().toString() == itrBook.title) {
                    foundBooks.add(itrBook)
                }
            }
            val bookAdapter = BookAdapter(mainActivity, foundBooks)
            lvSearchBooks?.setAdapter(bookAdapter)
            Toast.makeText(mainActivity, "Поиск завершён. Количество: " + foundBooks.size, Toast.LENGTH_SHORT).show()
        })
    }

    private fun initListView() {
        bookAdapter = BookAdapter(activity, mainActivity!!.listBooks)
        lvSearchBooks!!.onItemClickListener = OnItemClickListener { parent, view, position, id ->
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