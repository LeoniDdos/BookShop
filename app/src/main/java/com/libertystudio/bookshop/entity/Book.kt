package com.libertystudio.bookshop.entity

import androidx.room.Embedded
import androidx.room.PrimaryKey

data class Book(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val title: String,
        @Embedded
        val author: Author,
        val description: String,
        val year: Int,
        val price: Double,
        val image: String
)