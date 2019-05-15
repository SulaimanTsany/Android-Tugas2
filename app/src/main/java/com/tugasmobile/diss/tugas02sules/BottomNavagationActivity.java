package com.tugasmobile.diss.tugas02sules;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.exceptions.RealmMigrationNeededException;

public class BottomNavagationActivity extends AppCompatActivity {

    private Fragment fragment;
    private Realm realm;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                String userInput = newText.toLowerCase();
//                ArrayList<Movie> newListMovie = new ArrayList<>();
////                for (String title : movies) {
////                    if (title.toLowerCase().constrains(userInput));
////                        newListMovie.add(movies);
////                }
////                adapter.updateList(newListMovie);
//                return false;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_search:
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_notification:
                Toast.makeText(this, getResources().getText(R.string.notification), Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_change_language:
                Intent i = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(i);
                return true;
            case R.id.menu_credit:
                Toast.makeText(this, getResources().getText(R.string.credit), Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_popular:
                    fragment = new PopularFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_upcoming:
                    fragment = new UpcomingFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_favorite:
                    fragment = new FavoriteFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_other:
//                    fragment = new OtherFragment();
//                    loadFragment(fragment);
//                    Intent intent = new Intent(this, SearchActivity.class);
//                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navagation);
        Realm.init(this);

        try {
            realm = Realm.getDefaultInstance();
        } catch (RealmMigrationNeededException r) {
            Realm.deleteRealm(realm.getDefaultConfiguration());
            realm = Realm.getDefaultInstance();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_nav_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragment = new HomeFragment();
        loadFragment(fragment);
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit();
        }
    }

}
