package com.sahar.sharedelementtransition.Screens.MainScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sahar.sharedelementtransition.Model.Place;
import com.sahar.sharedelementtransition.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    RecyclerView.Adapter recyclerViewAdapter ;
    RecyclerView.LayoutManager recyclerViewLayoutManager ;
    Place[] myData = {new Place("Giza",R.drawable.giza)
            ,new Place("Dubai",R.drawable.dubai)
            ,new Place("Paris",R.drawable.paris)
            ,new Place("TajMahl",R.drawable.tajmahl)
            ,new Place("Toronto",R.drawable.toronto)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting linear layout manager
        this.recyclerView = findViewById(R.id.recyclerView);
        this.recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        //setting adapter
        recyclerViewAdapter = new Adapter(myData , this);
        recyclerView.setAdapter(recyclerViewAdapter);



    }


}
