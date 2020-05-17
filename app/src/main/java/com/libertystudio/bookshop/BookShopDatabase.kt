package com.libertystudio.bookshop

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.libertystudio.bookshop.entity.Book

@Database(entities = [Book::class], version = 1)
abstract class BookShopDatabase: RoomDatabase() {

    companion object {
        fun buildDataSource(context: Context): BookShopDatabase = Room.databaseBuilder(
                context, BookShopDatabase::class.java, "BookShopDatabase")
                .build()
    }
}