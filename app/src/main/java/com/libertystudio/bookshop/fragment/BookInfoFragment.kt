package com.libertystudio.bookshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.libertystudio.bookshop.MainActivity
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.entity.Book
import kotlinx.android.synthetic.main.fragment_book_info.*

class BookInfoFragment : BaseFragment() {
    private var mainActivity: MainActivity? = null
    private var selectedBook: Book? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_book_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        setTitle("О книге")

        mainActivity = activity as MainActivity?
        selectedBook = mainActivity!!.selectedBook

        tvBookInfoTitle.text = selectedBook!!.title
        tvBookInfoAuthor.text = selectedBook!!.author.name + " " + selectedBook!!.author.surname
        tvBookInfoYear.text = selectedBook!!.year.toString()
        tvBookInfoDescription.text = selectedBook!!.description
        tvBookInfoPrice.text = selectedBook!!.price.toString() + " рублей"

        btnBookInfoAddToBasket?.setOnClickListener {
            mainActivity!!.listBasketBooks.add(mainActivity!!.selectedBook!!)
            Toast.makeText(mainActivity, "Книга добавлена в корзину", Toast.LENGTH_SHORT).show()
        }
    }
}