package com.aurorasoft.android_java_bottom_navigation_movie_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemReselectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment fragment = null;

            switch (menuItem.getItemId()){
                case R.id.mn_now_playing:
                    fragment = new NowPlayingFragment(MainActivity.this);
                    break;
                case R.id.mn_coming_soon:
                    fragment = new ComingSoonFragment(MainActivity.this);
                    break;
                case R.id.mn_latest:
                    fragment = new LatestFragment(MainActivity.this);
                    break;
                case R.id.mn_cari:
                    fragment = new SearchFragment(MainActivity.this);
                    break;
            }
            return loadFragment(fragment);
        }

    };

    private boolean loadFragment(Fragment fragment) {
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.f1_container, fragment).commit();
            return true;
        }

        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemReselectedListener);

        //panggil fragment yang pertama kali
        loadFragment(new NowPlayingFragment(MainActivity.this));
    }
}
