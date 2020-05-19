package com.libertystudio.bookshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.libertystudio.bookshop.entity.Basket

class MainViewModel : ViewModel() {
    val basket: LiveData<Basket> = App.bookShopDatabase.basketDao().getBasket()
}