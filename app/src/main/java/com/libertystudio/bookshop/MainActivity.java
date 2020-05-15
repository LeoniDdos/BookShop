package com.libertystudio.bookshop;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.libertystudio.bookshop.data.Author;
import com.libertystudio.bookshop.data.Book;
import com.libertystudio.bookshop.fragment.BasketFragment;
import com.libertystudio.bookshop.fragment.BooksFragment;
import com.libertystudio.bookshop.fragment.SearchFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final FragmentManager fragmentManager = getSupportFragmentManager();

    final Fragment fragmentBooks = new BooksFragment();
    final Fragment fragmentSearch = new SearchFragment();
    final Fragment fragmentBasket = new BasketFragment();

    private ArrayList<Book> listBooks = new ArrayList<>();
    private ArrayList<Book> listBasketBooks = new ArrayList<>();

    private Book selectedBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView menuBottom = findViewById(R.id.bottomBar);
        menuBottom.setSelectedItemId(R.id.action_home);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragmentBooks).commit();
        setTitle("Книги");

        initBookList();

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

    private void initBookList() {
        listBooks.add(new Book("Мастер и маргарита", new Author("Булгаков", "Михаил"),
                "«Мастер и Маргарита» — роман Михаила Афанасьевича Булгакова, работа над которым началась в конце 1920-х годов и продолжалась вплоть до смерти писателя.", 1967, 400));
        listBooks.add(new Book("Война и мир", new Author("Толстой", "Лев"),
                "«Война и мир» — роман-эпопея Льва Николаевича Толстого, описывающий русское общество в эпоху войн против Наполеона в 1805—1812 годах.", 1867, 500));
        listBooks.add(new Book("Преступление и наказание", new Author("Достоевский", "Фёдор"),
                "«Преступление и наказание» — социально-психологический и социально-философский роман Фёдора Михайловича Достоевского, над которым писатель работал в 1865—1866 годах.", 1866, 350));
        listBooks.add(new Book("Анна Каренина", new Author("Толстой", "Лев"),
                "«Анна Каренина» — роман Льва Толстого о трагической любви замужней дамы Анны Карениной и блестящего офицера Вронского на фоне счастливой семейной жизни дворян Константина Лёвина и Кити Щербацкой.", 1877, 270));
        listBooks.add(new Book("Мёртвые души", new Author("Гоголь", "Николай"),
                "«Мёртвые души» — произведение Николая Васильевича Гоголя, жанр которого сам автор обозначил как поэму. Изначально задумано как трёхтомное произведение. Первый том был издан в 1842 году. Практически готовый второй том был уничтожен самим Гоголем, но сохранилось несколько глав в черновиках. Третий том был задуман и не начат, о нём остались только отдельные сведения.", 1842, 530));
        listBooks.add(new Book("Отцы и дети", new Author("Тургенев", "Иван"),
                "«Отцы и дети» — роман русского писателя Ивана Сергеевича Тургенева, написанный в 60-е годы XIX века. Роман стал знаковым для своего времени, а образ главного героя Евгения Базарова был воспринят молодёжью как пример для подражания. Такие идеалы как бескомпромиссность, отсутствие преклонения перед авторитетами и старыми истинами, приоритет полезного над прекрасным, были восприняты людьми того времени и нашли отражение в мировоззрении Базарова.", 1862, 200));
        listBooks.add(new Book("Евгений Онегин", new Author("Пушкин", "Александр"),
                "«Евгений Онегин» — роман в стихах русского поэта Александра Сергеевича Пушкина, одно из самых значительных произведений русской словесности.", 1832, 150));
        listBooks.add(new Book("Герой нашего времени", new Author("Лермонтов", "Михаил"),
                "«Герой нашего времени» — первый в русской прозе лирико-психологический роман, написанный Михаилом Юрьевичем Лермонтовым. Классика русской литературы.", 1840, 220));
        listBooks.add(new Book("Палата №6", new Author("Чехов", "Антон"),
                "«Палата № 6» — повесть Антона Павловича Чехова.", 1892, 190));
        listBooks.add(new Book("Обломов", new Author("Гончаров", "Иван"),
                "«Обломов» — роман, написанный русским писателем Иваном Александровичем Гончаровым. Роман входит в трилогию с произведениями «Обыкновенная история» и «Обрыв», являясь её второй частью.", 1859, 220));
        listBooks.add(new Book("Горе от ума", new Author("Грибоедов", "Александр"),
                "«Горе от ума» — комедия в стихах А. С. Грибоедова. Она сочетает в себе элементы классицизма и новых для начала XIX века романтизма и реализма. Она описывает светское общество времен крепостного права и показывает жизнь 1808—1824-х годов.", 1825, 340));
        listBooks.add(new Book("Тихий Дон", new Author("Шолохов", "Михаил"),
                "«Тихий Дон» — роман-эпопея Михаила Шолохова в четырёх томах. Одно из наиболее значительных произведений русской литературы XX века, рисующее широкую панораму жизни донского казачества во время Первой мировой войны, революционных событий 1917 года и Гражданской войны в России.", 1928, 410));
        listBooks.add(new Book("А зори здесь тихие", new Author("Васильев", "Борис"),
                "«А зори здесь тихие…» — произведение, написанное Борисом Васильевым, повествующее о судьбах пяти самоотверженных девушек-зенитчиц и их командира во время Великой Отечественной войны.", 1969, 120));
    }

    public int getBasketSum() {
        int sum = 0;

        for (Book itrBook : listBasketBooks) {
            sum += itrBook.getPrice();
        }

        return sum;
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    public ArrayList<Book> getListBooks() {
        return listBooks;
    }

    public ArrayList<Book> getListBasketBooks() {
        return listBasketBooks;
    }
}