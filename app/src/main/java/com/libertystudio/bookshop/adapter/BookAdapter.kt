package com.libertystudio.bookshop.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.libertystudio.bookshop.R
import com.libertystudio.bookshop.entity.Book
import com.libertystudio.bookshop.inflate
import com.libertystudio.bookshop.showImage

class BookAdapter : BaseAdapter<Book>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = parent.context.inflate(R.layout.item_book, parent)
        return BookViewHolder(view)
    }

    inner class BookViewHolder(itemView: View) : BaseViewHolder<Book>(itemView) {
        private val ivImage = itemView.findViewById<ImageView>(R.id.ivBookImage)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvBookTitle)
        private val tvPrice = itemView.findViewById<TextView>(R.id.tvBookPrice)

        override fun bind(item: Book) {
            ivImage.showImage(url = item.image)
            tvTitle.text = item.title + " (" + item.author.surname + " " + item.author.name.substring(0, 1) + ".)"
            tvPrice.text = "${item.price} руб."

            itemView.setOnClickListener {
                callback?.onItemClick(item)
            }
        }
    }
}