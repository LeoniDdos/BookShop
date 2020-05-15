package com.libertystudio.bookshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.entity.Book
import java.util.*

class BookAdapter(context: Context, private val books: ArrayList<Book>) : BaseAdapter() {
    override fun getCount(): Int {
        return books.size
    }

    override fun getItem(position: Int): Book {
        return books[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        itemView = itemView ?: inflater!!.inflate(R.layout.list_item, null)
        val tvTitle = itemView!!.findViewById<TextView>(R.id.textViewTitle)
        val tvPrice = itemView.findViewById<TextView>(R.id.textViewPrice)
        val (title, author, _, _, price) = books[position]
        tvTitle.text = title + " (" + author.surname + " " + author.name.substring(0, 1) + ".)"
        tvPrice.text = "$price руб."
        return itemView
    }

    companion object {
        private var inflater: LayoutInflater? = null
    }

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}