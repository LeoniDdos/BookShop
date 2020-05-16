package com.libertystudio.bookshop.adapter

interface BaseAdapterCallback<T> {
    fun onItemClick(item: T)
}