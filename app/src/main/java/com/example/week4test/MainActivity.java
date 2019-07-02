package com.example.week4test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.week4test.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements CoffeeListFragment.OnListFragmentInteractionListener {
    FragmentManager fragmentManager;
    CoffeeListFragment coffeeListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        coffeeListFragment = CoffeeListFragment.newInstance(1);
        fragmentManager.beginTransaction().add(R.id.fgCoffeeList, coffeeListFragment).commit();


    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
