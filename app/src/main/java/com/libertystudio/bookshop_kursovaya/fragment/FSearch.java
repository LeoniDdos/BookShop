package com.libertystudio.bookshop_kursovaya.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.libertystudio.bookshop_kursovaya.MainActivity;
import com.libertystudio.bookshop_kursovaya.R;
import com.libertystudio.bookshop_kursovaya.data.Book;
import com.libertystudio.bookshop_kursovaya.data.BookAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FSearch.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FSearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FSearch extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private TextView etSearchTitle;
    private Button btnSearch;

    private BookAdapter bookAdapter;

    private MainActivity mainActivity;

    private ListView lvSearchBooks;

    public FSearch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FSearch.
     */
    // TODO: Rename and change types and number of parameters
    public static FSearch newInstance(String param1, String param2) {
        FSearch fragment = new FSearch();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        initElements(view);

        return view;
    }

    private void initElements(View view) {
        mainActivity = (MainActivity) getActivity();

        etSearchTitle = view.findViewById(R.id.etSearchTitle);
        btnSearch = view.findViewById(R.id.btnSearch);
        lvSearchBooks = view.findViewById(R.id.lvSearchBooks);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearchTitle.setVisibility(View.INVISIBLE);
                btnSearch.setVisibility(View.INVISIBLE);

                ArrayList<Book> foundBooks = new ArrayList<>();

                for (Book itrBook : mainActivity.getListBooks()) {
                    if (etSearchTitle.getText().toString().equals(itrBook.getTitle())) {
                        foundBooks.add(itrBook);
                    }
                }

                BookAdapter bookAdapter = new BookAdapter(mainActivity, foundBooks);
                lvSearchBooks.setAdapter(bookAdapter);

                Toast.makeText(mainActivity, "Поиск завершён. Количество: " + foundBooks.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initListView() {
        bookAdapter = new BookAdapter(getActivity(), mainActivity.getListBooks());

        lvSearchBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainActivity.setSelectedBook(mainActivity.getListBooks().get(position));

                Fragment fragmentBookInfo = new FBookInfo();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, fragmentBookInfo).commit();
                mainActivity.setTitle("О книге");
            }
        });

        try {
            lvSearchBooks.setAdapter(bookAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
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