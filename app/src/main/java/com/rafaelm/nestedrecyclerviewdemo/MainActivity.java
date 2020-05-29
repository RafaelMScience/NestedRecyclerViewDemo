package com.rafaelm.nestedrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Initialize variable
    RecyclerView rvGroup;
    ArrayList<String> arrayListGroup;
    LinearLayoutManager layoutManagerGroup;
    GroupAdp adaterGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGroup = findViewById(R.id.rv_group);

        //Using for loop to add multiple group
        arrayListGroup = new ArrayList<>();
        for (int i=1; i<=10; i++){
            arrayListGroup.add("Group "+i);
        }

        //Iniatilize group adapter
        adaterGroup = new GroupAdp(MainActivity.this, arrayListGroup);

        //Initalize layou Manager
        layoutManagerGroup = new LinearLayoutManager(this);
        rvGroup.setLayoutManager(layoutManagerGroup);

        //set adapter
        rvGroup.setAdapter(adaterGroup);
    }
}
