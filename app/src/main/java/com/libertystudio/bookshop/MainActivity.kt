package com.libertystudio.bookshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.libertystudio.bookshop.entity.Author
import com.libertystudio.bookshop.entity.Book
import com.libertystudio.bookshop.fragment.BasketFragment
import com.libertystudio.bookshop.fragment.BooksFragment
import com.libertystudio.bookshop.fragment.SearchFragment
import java.util.*

class MainActivity : AppCompatActivity() {
    private val fragmentBooks: Fragment = BooksFragment()
    private val fragmentSearch: Fragment = SearchFragment()
    private val fragmentBasket: Fragment = BasketFragment()

    val listBooks = ArrayList<Book>()
    val listBasketBooks = ArrayList<Book>()
    var selectedBook: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val menuBottom = findViewById<BottomNavigationView>(R.id.bottomBar)
        menuBottom.selectedItemId = R.id.action_home
        startFragment(fragmentBooks)
        title = "Книги"
        initBookList()
        menuBottom.setOnNavigationItemSelectedListener(
                BottomNavigationView.OnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.action_home -> {
                            startFragment(fragmentBooks)
                            title = "Книги"
                            return@OnNavigationItemSelectedListener true
                        }
                        R.id.action_search -> {
                            startFragment(fragmentSearch)
                            title = "Поиск"
                            return@OnNavigationItemSelectedListener true
                        }
                        R.id.action_basket -> {
                            startFragment(fragmentBasket)
                            title = "Корзина"
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                    return@OnNavigationItemSelectedListener false
                })
    }

    private fun initBookList() {
        listBooks.add(Book("Мастер и маргарита", Author("Булгаков", "Михаил"),
                "«Мастер и Маргарита» — роман Михаила Афанасьевича Булгакова, работа над которым началась в конце 1920-х годов и продолжалась вплоть до смерти писателя.", 1967, 400.0))
        listBooks.add(Book("Война и мир", Author("Толстой", "Лев"),
                "«Война и мир» — роман-эпопея Льва Николаевича Толстого, описывающий русское общество в эпоху войн против Наполеона в 1805—1812 годах.", 1867, 500.0))
        listBooks.add(Book("Преступление и наказание", Author("Достоевский", "Фёдор"),
                "«Преступление и наказание» — социально-психологический и социально-философский роман Фёдора Михайловича Достоевского, над которым писатель работал в 1865—1866 годах.", 1866, 350.0))
        listBooks.add(Book("Анна Каренина", Author("Толстой", "Лев"),
                "«Анна Каренина» — роман Льва Толстого о трагической любви замужней дамы Анны Карениной и блестящего офицера Вронского на фоне счастливой семейной жизни дворян Константина Лёвина и Кити Щербацкой.", 1877, 270.0))
        listBooks.add(Book("Мёртвые души", Author("Гоголь", "Николай"),
                "«Мёртвые души» — произведение Николая Васильевича Гоголя, жанр которого сам автор обозначил как поэму. Изначально задумано как трёхтомное произведение. Первый том был издан в 1842 году. Практически готовый второй том был уничтожен самим Гоголем, но сохранилось несколько глав в черновиках. Третий том был задуман и не начат, о нём остались только отдельные сведения.", 1842, 530.0))
        listBooks.add(Book("Отцы и дети", Author("Тургенев", "Иван"),
                "«Отцы и дети» — роман русского писателя Ивана Сергеевича Тургенева, написанный в 60-е годы XIX века. Роман стал знаковым для своего времени, а образ главного героя Евгения Базарова был воспринят молодёжью как пример для подражания. Такие идеалы как бескомпромиссность, отсутствие преклонения перед авторитетами и старыми истинами, приоритет полезного над прекрасным, были восприняты людьми того времени и нашли отражение в мировоззрении Базарова.", 1862, 200.0))
        listBooks.add(Book("Евгений Онегин", Author("Пушкин", "Александр"),
                "«Евгений Онегин» — роман в стихах русского поэта Александра Сергеевича Пушкина, одно из самых значительных произведений русской словесности.", 1832, 150.0))
        listBooks.add(Book("Герой нашего времени", Author("Лермонтов", "Михаил"),
                "«Герой нашего времени» — первый в русской прозе лирико-психологический роман, написанный Михаилом Юрьевичем Лермонтовым. Классика русской литературы.", 1840, 220.0))
        listBooks.add(Book("Палата №6", Author("Чехов", "Антон"),
                "«Палата № 6» — повесть Антона Павловича Чехова.", 1892, 190.0))
        listBooks.add(Book("Обломов", Author("Гончаров", "Иван"),
                "«Обломов» — роман, написанный русским писателем Иваном Александровичем Гончаровым. Роман входит в трилогию с произведениями «Обыкновенная история» и «Обрыв», являясь её второй частью.", 1859, 220.0))
        listBooks.add(Book("Горе от ума", Author("Грибоедов", "Александр"),
                "«Горе от ума» — комедия в стихах А. С. Грибоедова. Она сочетает в себе элементы классицизма и новых для начала XIX века романтизма и реализма. Она описывает светское общество времен крепостного права и показывает жизнь 1808—1824-х годов.", 1825, 340.0))
        listBooks.add(Book("Тихий Дон", Author("Шолохов", "Михаил"),
                "«Тихий Дон» — роман-эпопея Михаила Шолохова в четырёх томах. Одно из наиболее значительных произведений русской литературы XX века, рисующее широкую панораму жизни донского казачества во время Первой мировой войны, революционных событий 1917 года и Гражданской войны в России.", 1928, 410.0))
        listBooks.add(Book("А зори здесь тихие", Author("Васильев", "Борис"),
                "«А зори здесь тихие…» — произведение, написанное Борисом Васильевым, повествующее о судьбах пяти самоотверженных девушек-зенитчиц и их командира во время Великой Отечественной войны.", 1969, 120.0))
    }

    fun startFragment(fragment: Fragment?) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction
                .replace(R.id.fragmentContainer, fragment!!)
                .commit()
    }

    val basketSum: Int
        get() {
            var sum = 0
            for ((_, _, _, _, price) in listBasketBooks) {
                sum += price.toInt()
            }
            return sum
        }
}