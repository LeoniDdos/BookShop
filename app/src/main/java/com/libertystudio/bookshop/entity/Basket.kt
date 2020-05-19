package com.libertystudio.bookshop.entity

import androidx.room.Entity

@Entity(tableName = "tablebasket")
data class Basket (
        val books: ArrayList<Book>,
        val fullPrice: Int
)