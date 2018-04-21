package com.libertystudio.bookshop_kursovaya;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.libertystudio.bookshop_kursovaya.data.Author;
import com.libertystudio.bookshop_kursovaya.data.Book;
import com.libertystudio.bookshop_kursovaya.data.BookAdapter;
import com.libertystudio.bookshop_kursovaya.fragment.FBasket;
import com.libertystudio.bookshop_kursovaya.fragment.FBooks;
import com.libertystudio.bookshop_kursovaya.fragment.FSearch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView menuBottom;

    final FragmentManager fragmentManager = getSupportFragmentManager();

    final Fragment fragmentBooks = new FBooks();
    final Fragment fragmentSearch = new FSearch();
    final Fragment fragmentBasket = new FBasket();

    private ListView lvBooks;
    private ArrayList<Book> listBooks = new ArrayList<>();
    private BookAdapter bookAdapter;

    private Book selectedBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuBottom = findViewById(R.id.navigation);
        menuBottom.setSelectedItemId(R.id.action_home);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragmentBooks).commit();
        setTitle("Книги");

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
//                                    populateListView();
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

    private void populateListView() {
        lvBooks = findViewById(R.id.lv_books);

        listBooks.add(new Book("Мастер и маргарита", new Author("Булгаков", "Михаил")));
        listBooks.add(new Book("Война и мир", new Author("Толстой", "Лев")));
        listBooks.add(new Book("Преступление и наказание", new Author("Достоевский", "Фёдор")));
        listBooks.add(new Book("Анна Каренина", new Author("Толстой", "Лев")));
        listBooks.add(new Book("Мёртвые души", new Author("Гоголь", "Николай")));
        listBooks.add(new Book("Отцы и дети", new Author("Тургенев", "Иван")));
        listBooks.add(new Book("Евгений Онегин", new Author("Пушкин", "Александр")));
        listBooks.add(new Book("Герой нашего времени", new Author("Лермонтов", "Михаил")));
        listBooks.add(new Book("Палата №6", new Author("Чехов", "Антон")));
        listBooks.add(new Book("Обломов", new Author("Гончаров", "Иван")));
        listBooks.add(new Book("Горе от ума", new Author("Грибоедов", "Александр")));
        listBooks.add(new Book("Тихий Дон", new Author("Шолохов", "Михаил")));
        listBooks.add(new Book("А зори здесь тихие", new Author("Васильев", "Борис")));

        bookAdapter = new BookAdapter(this, listBooks);

        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "clicked: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        try {
            lvBooks.setAdapter(bookAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }
}