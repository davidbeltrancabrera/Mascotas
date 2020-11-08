package com.davidbeltran.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import com.davidbeltran.mascotas.adapter.PageAdapter;
import com.davidbeltran.mascotas.fragment.PerfilFragment;
import com.davidbeltran.mascotas.fragment.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView mTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(myToolbar);

        //Fragments
        toolbar = (Toolbar)  findViewById(R.id.toolbar);
        tabLayout = (TabLayout)  findViewById(R.id.tablayout);
        viewPager = (ViewPager)  findViewById(R.id.viewPager);

        setUpViewPager();

       if (toolbar != null){
            setSupportActionBar(toolbar);
        }


    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.casadog);
        tabLayout.getTabAt(1).setIcon(R.drawable.perfildog);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_about:
                Intent intent2 = new Intent(this, AboutActivity.class);
                startActivity(intent2);
                return true;

            case R.id.action_contacto:
                Intent intent1 = new Intent(this, ContactoActivity.class);
                startActivity(intent1);
                return true;

            case R.id.action_favorite:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}