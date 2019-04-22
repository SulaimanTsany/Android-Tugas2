package com.tugasmobile.diss.tugas02sules;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class BottomNavagationActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_notification:
                Toast.makeText(this, getResources().getText(R.string.notification), Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_change_language:
                Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(intent);
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
                case R.id.menu_favorite:
                    fragment = new FavoriteFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_other:
                    fragment = new OtherFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navagation);

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
