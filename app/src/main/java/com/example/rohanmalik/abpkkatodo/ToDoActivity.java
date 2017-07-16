    package com.example.rohanmalik.abpkkatodo;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.icu.util.ULocale;
import android.media.Image;
import android.nfc.TagLostException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wunderlist.slidinglayer.LayerTransformer;
import com.wunderlist.slidinglayer.SlidingLayer;
import com.wunderlist.slidinglayer.transformer.SlideJoyTransformer;

import java.util.ArrayList;
import java.util.List;

public class ToDoActivity extends AppCompatActivity implements CategoryAdapter.TodoClickListener{
    List<Category_Todo> category_todoList;
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    private SlidingLayer mSlidingLayer;
    private TextView swipeText;
    private AutoCompleteTextView editText;
    ImageView imageBell;
    int covers[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        category_todoList = new ArrayList<>();
        String titles[] = {"Birthday","Meeting","Reminder","Gym","Groceries","Others","Marriage","Anniversary","Insurance"};
        recyclerView = (RecyclerView) findViewById(R.id.recycler_content);
        categoryAdapter = new CategoryAdapter(category_todoList,this);
     StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(categoryAdapter);
        editText = (AutoCompleteTextView) findViewById(R.id.add_category_editText);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,titles);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        editText.setAdapter(adapter);
        imageBell = (ImageView)findViewById(R.id.bell);
        imageBell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlidingLayer.openLayer(true);

            }
        });
        covers = new int[]{
                R.drawable.birthday,
                R.drawable.insuure,
                R.drawable.marriage,
                R.drawable.fb,
                R.drawable.grocery,
                R.drawable.gogle,
                R.drawable.anivers,
                R.drawable.meeting,
                R.drawable.reminder,
                R.drawable.gymie};
        final FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.fab_add_category);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlidingLayer.openLayer(true);
                floatingActionButton.setVisibility(View.GONE);
            }
        });
        final Button btnClose = (Button)findViewById(R.id.buttonClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category_Todo category_todo;
                String text =  editText.getText().toString();
                if(!text.isEmpty()) {
                    switch (text){
                        case "Birthday" :
                            category_todo = new Category_Todo(text,covers[0],50);
                            break;
                        case "Insurance" :
                            category_todo = new Category_Todo(text,covers[1],50);
                            break;
                        case "Marriage" :
                            category_todo = new Category_Todo(text,covers[2],50);
                            break;
                        case "Others" :
                            category_todo = new Category_Todo(text,covers[3],50);
                            break;
                        case "Groceries" :
                            category_todo = new Category_Todo(text,covers[4],50);
                            break;
                        case "Anniversary" :
                            category_todo = new Category_Todo(text,covers[6],50);
                            break;
                        case "Meeting" :
                            category_todo = new Category_Todo(text,covers[7],50);
                            break;
                        case "Reminder" :
                            category_todo = new Category_Todo(text,covers[8],50);
                            break;
                        case "Gym" :
                            category_todo = new Category_Todo(text,covers[9],50);
                            break;
                        default:
                            category_todo = new Category_Todo(text,covers[5],50);
                    }
                    category_todoList.add(category_todo);
                    categoryAdapter.notifyItemInserted(category_todoList.size());
                    editText.setText("");
                    text="";
                    mSlidingLayer.closeLayer(true);
                    floatingActionButton.setVisibility(View.VISIBLE);
                }
                else {
                    Toast.makeText(ToDoActivity.this,"Please Enter Category title",Toast.LENGTH_SHORT).show();
                }
            }
        });
        mSlidingLayer = (SlidingLayer)findViewById(R.id.slidingLayer1);
        setUpSlidingLayerPosition("left");
        setUpSlidingLayerTransform("slide");
    }

    private void setUpSlidingLayerTransform(String slide) {
        LayerTransformer transformer;
        transformer = new SlideJoyTransformer();
        mSlidingLayer.setLayerTransformer(transformer);
    }

    private void setUpSlidingLayerPosition(String left){

        ViewGroup.LayoutParams rlp = (ViewGroup.LayoutParams) mSlidingLayer.getLayoutParams();
        mSlidingLayer.setStickTo(SlidingLayer.STICK_TO_BOTTOM);
        mSlidingLayer.setLayoutParams(rlp);
    }

    @Override
    public void onItemClick(View view, int position) {
        Category_Todo category = category_todoList.get(position);
        Snackbar.make(recyclerView,category.getTitle(),Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onDeleteClick(int position) {
        category_todoList.remove(position);
        categoryAdapter.notifyItemRemoved(position);

    }
}
