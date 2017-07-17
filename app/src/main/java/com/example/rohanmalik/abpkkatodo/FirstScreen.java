package com.example.rohanmalik.abpkkatodo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class FirstScreen extends AppCompatActivity {
    EditText nameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Button buttonFirstScreen = (Button) findViewById(R.id.first_screen_button);
        nameText = (EditText)findViewById(R.id.name_category);
        SharedPreferences sharedPreferences = getSharedPreferences("abcd", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        if(sharedPreferences.getString("name",null)!=null){
            nameText.setVisibility(View.GONE);
            buttonFirstScreen.setVisibility(View.GONE);
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   Intent mainIntent = new Intent(FirstScreen.this,ToDoActivity.class);
                   startActivity(mainIntent);
                   finish();
               }
           },2000);
        }

        buttonFirstScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstScreen.this, ToDoActivity.class);
                String name = nameText.getText().toString();
                editor.putString("name",name);
                editor.commit();
                startActivity(intent);
            }
        });
    }
}
