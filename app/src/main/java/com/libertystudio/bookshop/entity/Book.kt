package com.libertystudio.bookshop.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TableBook")
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