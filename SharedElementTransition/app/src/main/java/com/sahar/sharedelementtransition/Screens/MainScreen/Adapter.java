package com.sahar.sharedelementtransition.Screens.MainScreen;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.sahar.sharedelementtransition.Model.Place;
import com.sahar.sharedelementtransition.R;
import com.sahar.sharedelementtransition.Screens.SecondScreen.Activity2;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private Place[] mDataset ;
    MainActivity mainActivity;
    int indx ;
    ImageView img;

    public Adapter(Place [] mDataset ,MainActivity mainActivity){
        this.mDataset = mDataset;
        this.mainActivity = mainActivity ;
        indx = 0 ;

    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view ;
        public TextView textView ;
        public ImageView imageView ;
        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.imageView = view.findViewById(R.id.imageView);
            this.textView = view.findViewById(R.id.textView);
        }
    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        TextView textView = viewHolder.view.findViewById(R.id.textView);
        indx = i ;
        textView.setText(mDataset[indx].getPlaceName());

        FrameLayout frameLayout = viewHolder.view.findViewById(R.id.frameLayout);
       // img = (ImageView) frameLayout.getChildAt(0);
        img = viewHolder.view.findViewById(R.id.imageView);
        img.setBackgroundResource(mDataset[indx].getImgRec());

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity, Activity2.class);
                intent.putExtra("Img",mDataset[indx].getImgRec());
                intent.putExtra("Name",mDataset[indx].getPlaceName());
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(mainActivity,img,img.getTransitionName()).toBundle();
                mainActivity.startActivity(intent,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }





}
