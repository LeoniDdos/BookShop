package com.libertystudio.bookshop

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.libertystudio.bookshop.entity.Book
import java.lang.reflect.Type


class BookMockData {
    companion object {
        fun getBooks(context: Context): ArrayList<Book> {
            val booksJson = getBooksJson(context = context)

            val booksType: Type = object : TypeToken<ArrayList<Book>>() {}.type

            return Gson().fromJson(booksJson, booksType)
        }

        private fun getBooksJson(context: Context): String {
            val inputStream = context.resources.openRawResource(R.raw.books)

            return inputStream.bufferedReader().use { it.readText() }
        }
    }
}