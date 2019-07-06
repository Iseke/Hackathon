package com.example.newschecker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class News_page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<News> events ;
    RecyclerView rv;
    private OnFragmentInteractionListener mListener;

    public News_page() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static News_page newInstance(String param1, String param2) {
        News_page fragment = new News_page();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_page,container,false);
        rv = view.findViewById(R.id.news_list_view);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);
        LoadNews();
        TempAdapter adapter = new TempAdapter(events);
        rv.setAdapter(adapter);
        rv.addOnItemTouchListener(new RecyclerTouchListener(getContext(), rv, new ClickListener() {

            @Override
            public void onClick(View view, final int position) {

            }
            @Override
            public void onLongClick(View view, int position) {
                String url = events.get(position).getToUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        }));

        return view;
    }

    private void LoadNews() {
        events = new ArrayList<>();
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/2e9bb4b538e41838.jpg?imwidth=900","Плейлист Елбасы: какие песни любит и слушает Назарбаев (видео)","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/850434832a9c0af2.jpg?imwidth=900","Когда спишут штрафы и пени по кредитам казахстанцев, рассказали в Нацбанке","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/c3797302578c31f3.jpg?imwidth=900","Дочь Гульнары Каримовой рассказала о судьбе миллионов матери","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/915ce1091d5e4e9d.jpg?imwidth=900","230 семей в Талдыкоргане получили ключи от квартир","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/ebd2d89f36c97278.jpg?imwidth=900","Путин, Пашинян, Эрдоган: кто еще звонил Назарбаеву с поздравлениями","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/21152c5e7e0ce1f3.jpg?imwidth=900","Взрыв прогремел в воинской части в Азербайджане","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/dbf34b4c33e019d7.jpg?imwidth=900","Замакима Алматы Арман Кырыкбаев ушел в учебный отпуск","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/f4bf958c008f967e.jpg?imwidth=900","Программа обновления автобусного парка набирает обороты","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/812992cb0c770b3c.jpg?imwidth=900","Разрушенные после взрывов хозпостройки в Арыси ремонтировать не будут","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/81814cf5c3a575d6.png?imwidth=900","Смартфон из золота за 2 млн тенге выпустили в честь Дня столицы","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        events.add(new News("Nur.kz","https://netstorage-nur.akamaized.net/images/61a5c38e9229d734.png?imwidth=900","\"Белоснежка. Сказка для взрослых\" и другие интригующие премьеры этого сезона","https://www.nur.kz/1803443-samyj-bogatyj-celovek-v-mire-oficialno-razvelsa.html"));
        }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



   class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{
        private ClickListener clicklistener;
        private GestureDetector gestureDetector;
        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener){
            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }
        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

}
