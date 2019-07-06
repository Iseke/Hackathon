package com.example.newschecker;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.fragment_container, new News_page()).commit();


        /* if (FeedFragment.account != "") {
            System.out.println("hello");
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.fragment_container, new ProfileFragment()).commit();
            //bottomNavigationView.setSelectedItemId(R.id.nav_profile);

        } else {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.fragment_container, new FeedFragment()).commit();
        }*/
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selected=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selected= new News_page();
                    break;
                case R.id.navigation_dashboard:
                    selected= new Characteristics_page();
                    break;
                /*case R.id.navigation_notifications:
                    selected= new Profile_page();
                    break;*/
            }
            assert selected != null;
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.fragment_container, selected).commit();
            return true;
        }
    };


}
