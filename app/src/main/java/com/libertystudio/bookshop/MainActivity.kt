package com.libertystudio.bookshop

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.libertystudio.bookshop.entity.Book
import com.libertystudio.bookshop.fragment.BasketFragment
import com.libertystudio.bookshop.fragment.BooksFragment
import com.libertystudio.bookshop.fragment.SearchFragment
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val model: MainViewModel by viewModels()

    private val fragmentBooks: Fragment = BooksFragment()
    private val fragmentSearch: Fragment = SearchFragment()
    private val fragmentBasket: Fragment = BasketFragment()

    val listBooks = ArrayList<Book>()
    val listBasketBooks = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomBar()
        initToolbar()

        setMockBookList()
    }

    private fun initBottomBar() {
        val menuBottom = findViewById<BottomNavigationView>(R.id.bottomBar)
        menuBottom.selectedItemId = R.id.action_home
        startFragment(fragmentBooks)

        menuBottom.setOnNavigationItemSelectedListener(
                BottomNavigationView.OnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.action_home -> {
                            startFragment(fragmentBooks)
                            return@OnNavigationItemSelectedListener true
                        }
                        R.id.action_search -> {
                            startFragment(fragmentSearch)
                            return@OnNavigationItemSelectedListener true
                        }
                        R.id.action_basket -> {
                            startFragment(fragmentBasket)
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                    return@OnNavigationItemSelectedListener false
                })
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun setMockBookList() {
        listBooks.clear()
        listBooks.addAll(BookMockData.getBooks(context = applicationContext))
    }

    fun startFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    fun setTitle(title: String) {
        this.title = title
    }

    val basketSum: Int
        get() {
            var sum = 0
            for (itrBook in listBasketBooks) {
                sum += itrBook.price.toInt()
            }
            return sum
        }
}