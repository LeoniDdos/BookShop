package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.entity.Book

class BookInfoFragment : BaseFragment() {
    private var mainActivity: MainActivity? = null
    private var selectedBook: Book? = null
    private var btnAddToBasket: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_book_info, container, false)
        initElements(view)
        return view
    }

    private fun initElements(view: View) {
        setTitle("О книге")

        mainActivity = activity as MainActivity?
        selectedBook = mainActivity!!.selectedBook

        val tvTitle = view.findViewById<TextView>(R.id.tvInfoTitle)
        val tvAuthor = view.findViewById<TextView>(R.id.tvInfoAuthor)
        val tvYear = view.findViewById<TextView>(R.id.tvInfoYear)
        val tvDescription = view.findViewById<TextView>(R.id.tvInfoDescription)
        val tvPrice = view.findViewById<TextView>(R.id.tvInfoPrice)

        tvTitle.text = selectedBook!!.title
        tvAuthor.text = selectedBook!!.author.name + " " + selectedBook!!.author.surname
        tvYear.text = selectedBook!!.year.toString()
        tvDescription.text = selectedBook!!.description
        tvPrice.text = selectedBook!!.price.toString() + " рублей"

        btnAddToBasket = view.findViewById(R.id.btnAddToBasket)
        btnAddToBasket?.setOnClickListener(View.OnClickListener {
            mainActivity!!.listBasketBooks.add(mainActivity!!.selectedBook!!)
            Toast.makeText(mainActivity, "Книга добавлена в корзину", Toast.LENGTH_SHORT).show()
        })
    }
}