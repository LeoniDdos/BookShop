package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.adapter.BookAdapter

class BooksFragment : BaseFragment() {
    private var lvBooks: ListView? = null
    private var mainActivity: MainActivity? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_books, container, false)
        initElements(view)
        return view
    }

    private fun initElements(view: View) {
        mainActivity = activity as MainActivity?
        lvBooks = view.findViewById(R.id.lv_books)
        lvBooks?.setAdapter(BookAdapter(mainActivity, mainActivity!!.listBooks))
        lvBooks?.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            mainActivity!!.selectedBook = mainActivity!!.listBooks[position]
            mainActivity!!.title = "О книге"
            startFragment(BookInfoFragment())
        })
    }
}