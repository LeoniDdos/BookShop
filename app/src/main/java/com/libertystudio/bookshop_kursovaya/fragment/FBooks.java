package com.libertystudio.bookshop_kursovaya.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.libertystudio.bookshop_kursovaya.MainActivity;
import com.libertystudio.bookshop_kursovaya.R;
import com.libertystudio.bookshop_kursovaya.data.Author;
import com.libertystudio.bookshop_kursovaya.data.Book;
import com.libertystudio.bookshop_kursovaya.data.BookAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FBooks.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FBooks#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FBooks extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListView lvBooks;
    private ArrayList<Book> listBooks = new ArrayList<>();
    private BookAdapter bookAdapter;


    public FBooks() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FBooks.
     */
    // TODO: Rename and change types and number of parameters
    public static FBooks newInstance(String param1, String param2) {
        FBooks fragment = new FBooks();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void populateListView() {
        System.out.println("BEGIN");

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

        bookAdapter = new BookAdapter(getActivity(), listBooks);

        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "clicked: " + position, Toast.LENGTH_SHORT).show();

                FragmentManager fragmentManager = getFragmentManager();

                ((MainActivity)getActivity()).setSelectedBook(listBooks.get(position));

                Fragment fragmentBookInfo = new FBookInfo();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, fragmentBookInfo).commit();
                getActivity().setTitle("О книге");
            }
        });

        try {
            lvBooks.setAdapter(bookAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //populateListView();

        View view = inflater.inflate(R.layout.fragment_books, container, false);
        lvBooks = view.findViewById(R.id.lv_books);

        populateListView();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Commented
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
