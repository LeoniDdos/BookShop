package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.adapter.BookAdapter
import kotlinx.android.synthetic.main.fragment_books.*

class BooksFragment : BaseFragment() {
    private var mainActivity: MainActivity? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        setTitle("Книги")

        mainActivity = activity as MainActivity?
        lvBooks?.adapter = BookAdapter(mainActivity, mainActivity!!.listBooks)
        lvBooks?.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            mainActivity!!.selectedBook = mainActivity!!.listBooks[position]
            startFragment(BookInfoFragment())
        }
    }
}