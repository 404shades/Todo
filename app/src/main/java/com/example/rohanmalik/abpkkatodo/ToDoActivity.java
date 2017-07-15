package com.example.rohanmalik.abpkkatodo;

import android.icu.util.ULocale;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ToDoActivity extends AppCompatActivity {
    List<Category_Todo> category_todoList;
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        category_todoList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_content);
        categoryAdapter = new CategoryAdapter(category_todoList);
     StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(categoryAdapter);
        Category_Todo category_todo = new Category_Todo("Rohan",R.drawable.birthday,50);
        category_todoList.add(category_todo);
        Category_Todo category_todo1 = new Category_Todo("Rohan",R.drawable.meeting,60);
        category_todoList.add(category_todo1);
        Category_Todo category_todo2 = new Category_Todo("Rohan",R.drawable.grocery,60);
        category_todoList.add(category_todo2);
        Category_Todo category_todo3 = new Category_Todo("Rohan",R.drawable.reminder,60);
        category_todoList.add(category_todo3);
        Category_Todo category_todo4 = new Category_Todo("Rohan",R.drawable.fb,60);
        category_todoList.add(category_todo4);
//        fab = (FloatingActionButton)findViewById(R.id.fab_add_category);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("goua","happbc");
//                Category_Todo category_todo = new Category_Todo("Rohan",R.drawable.fb,50);
//                category_todoList.add(category_todo);
//                categoryAdapter.notifyDataSetChanged();
//            }
//        });
    }
}
