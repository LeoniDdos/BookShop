package com.libertystudio.bookshop

import android.app.Application

class App : Application() {
    companion object {
        lateinit var bookShopDatabase: BookShopDatabase
    }

    override fun onCreate() {
        super.onCreate()
        bookShopDatabase = BookShopDatabase.buildDataSource(context = applicationContext)
    }
}