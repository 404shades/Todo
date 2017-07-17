package com.example.rohanmalik.abpkkatodo;

import android.app.DatePickerDialog;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.wunderlist.slidinglayer.SlidingLayer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.jar.Manifest;

public class ScrollingActivity extends AppCompatActivity {
    RecyclerView recycleBrother;
    TodoAdapter greenAdapter;
    List<Lists> listItems;
    SlidingLayer mSlidingLayerFuck;
    TextView textTitleSlide;
    AutoCompleteTextView editAutoContacts;
    ArrayAdapter adapter;
    EditText dateSet;
    Calendar myCalender;
    Lists listdot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myCalender = Calendar.getInstance();
        dateSet = (EditText)findViewById(R.id.Donot_disturbs);
        String titleCategory =getIntent().getExtras().getString("TitleCategory");
        mSlidingLayerFuck = (SlidingLayer)findViewById(R.id.slidingLayer1);
        setTitle(titleCategory);
        editAutoContacts = (AutoCompleteTextView)findViewById(R.id.add_categoryList_editText);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlidingLayerFuck.openLayer(true);
                fab.setVisibility(View.GONE);
            }
        });
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                myCalender.set(Calendar.YEAR,i);
                myCalender.set(Calendar.MONTH,i1);
                myCalender.set(Calendar.DAY_OF_MONTH,i2);
                updateLabel();
            }
        };
        dateSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ScrollingActivity.this,date,myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DATE)).show();
            }
        });
        textTitleSlide = (TextView)findViewById(R.id.TilteCateg);
        textTitleSlide.setText(titleCategory);
        listItems = new ArrayList<>();
        recycleBrother = (RecyclerView) findViewById(R.id.list_add_recycle);
        greenAdapter = new TodoAdapter(listItems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ScrollingActivity.this);
        recycleBrother.setLayoutManager(layoutManager);
        recycleBrother.setAdapter(greenAdapter);
        Button button = (Button)findViewById(R.id.btn_add_Todo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ToDoTitle =  editAutoContacts.getText().toString();
               listdot = new Lists(ToDoTitle,"Jo marzi");
                listItems.add(listdot);
                greenAdapter.notifyItemInserted(listItems.size());
                mSlidingLayerFuck.closeLayer(true);
                fab.setVisibility(View.VISIBLE);
            }
        });
    }
    public void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dateSet.setText(sdf.format(myCalender.getTime()));

    }
}
