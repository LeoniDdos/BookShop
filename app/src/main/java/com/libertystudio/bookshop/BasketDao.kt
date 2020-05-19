package com.libertystudio.bookshop

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.libertystudio.bookshop.entity.Basket

@Dao
interface BasketDao {
    @Query("SELECT * FROM tablebasket")
    fun getBasket(): LiveData<Basket>
}