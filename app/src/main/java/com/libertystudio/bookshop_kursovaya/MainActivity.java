package com.libertystudio.bookshop_kursovaya;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.libertystudio.bookshop_kursovaya.fragment.FBasket;
import com.libertystudio.bookshop_kursovaya.fragment.FBooks;
import com.libertystudio.bookshop_kursovaya.fragment.FSearch;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView menuBottom;

    final FragmentManager fragmentManager = getSupportFragmentManager();

    final Fragment fragmentBooks = new FBooks();
    final Fragment fragmentSearch = new FSearch();
    final Fragment fragmentBasket = new FBasket();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuBottom = findViewById(R.id.navigation);
        menuBottom.setSelectedItemId(R.id.action_home);

        menuBottom.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        try {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            switch (item.getItemId()) {
                                case R.id.action_home:
                                    fragmentTransaction.replace(R.id.content, fragmentBooks).commit();
                                    setTitle("Книги");
                                    return true;
                                case R.id.action_search:
                                    fragmentTransaction.replace(R.id.content, fragmentSearch).commit();
                                    setTitle("Поиск");
                                    return true;
                                case R.id.action_basket:
                                    fragmentTransaction.replace(R.id.content, fragmentBasket).commit();
                                    setTitle("Корзина");
                                    return true;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                });
    }
}