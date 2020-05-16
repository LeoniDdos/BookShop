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
    private var currentBook: Book? = null

    companion object {
        fun newInstance(selectedBook: Book): BookInfoFragment {
            val fragment = BookInfoFragment()
            fragment.currentBook = selectedBook

            return fragment
        }
    }

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

        tvBookInfoTitle.text = currentBook!!.title
        tvBookInfoAuthor.text = currentBook!!.author.name + " " + currentBook!!.author.surname
        tvBookInfoYear.text = currentBook!!.year.toString()
        tvBookInfoDescription.text = currentBook!!.description
        tvBookInfoPrice.text = currentBook!!.price.toString() + " рублей"

        btnBookInfoAddToBasket?.setOnClickListener {
            mainActivity!!.listBasketBooks.add(currentBook!!)
            Toast.makeText(mainActivity, "Книга добавлена в корзину", Toast.LENGTH_SHORT).show()
        }
    }
}