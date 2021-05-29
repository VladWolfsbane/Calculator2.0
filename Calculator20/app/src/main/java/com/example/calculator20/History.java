package com.example.calculator20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    FloatingActionButton btn3;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        lst = findViewById(R.id.listView);

        DB db = new DB(History.this);
        List<Model> allData = db.getAllData();

        ArrayAdapter arrayAdapter = new ArrayAdapter<Model>(History.this, android.R.layout.simple_list_item_1, allData);
        lst.setAdapter(arrayAdapter);

        btn3 = findViewById(R.id.floatingActionButton2);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    public void goBack(){
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }
}