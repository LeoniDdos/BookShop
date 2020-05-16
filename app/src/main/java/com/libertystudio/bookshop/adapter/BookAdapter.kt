package com.libertystudio.bookshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.entity.Book

class BookAdapter : BaseAdapter<Book>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    inner class BookViewHolder(itemView: View) : BaseViewHolder<Book>(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.textViewTitle)
        private val tvPrice = itemView.findViewById<TextView>(R.id.textViewPrice)

        override fun bind(item: Book) {
            tvTitle.text = item.title + " (" + item.author.surname + " " + item.author.name.substring(0, 1) + ".)"
            tvPrice.text = "${item.price} руб."

            itemView.setOnClickListener {
                callback?.onItemClick(item)
            }
        }
    }
}