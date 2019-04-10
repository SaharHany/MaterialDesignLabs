package com.sahar.sharedelementtransition.Screens.SecondScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.sahar.sharedelementtransition.R;

public class Activity2 extends AppCompatActivity {

    ImageView imageView ;
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        imageView = findViewById(R.id.imageView2);
        textView  = findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        imageView.setBackgroundResource(bundle.getInt("Img"));
        textView.setText(bundle.getString("Name"));
        Transition transition = TransitionInflater.from(this)
                            .inflateTransition(R.transition.elementtrans);
        getWindow().setSharedElementEnterTransition(transition);


    }
}
