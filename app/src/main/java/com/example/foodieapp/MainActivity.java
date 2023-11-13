package com.example.foodieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodieapp.Adaptor.categoryAdoptor;
import com.example.foodieapp.Domain.categoryDomain;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        recyclerViewCategory();

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
        ArrayList<categoryDomain> category=new ArrayList<>();
        category.add(new categoryDomain("pizza", "cat_1"));
        category.add(new categoryDomain("Burger", "cat_2"));
        category.add(new categoryDomain("Hot Dog", "cat_3"));
        category.add(new categoryDomain("soda", "cat_4"));
        category.add(new categoryDomain("Doughnuts", "cat_5"));
        adapter= new categoryAdoptor(category);
        recyclerViewCategoryList.setAdapter(adapter);


    }
}