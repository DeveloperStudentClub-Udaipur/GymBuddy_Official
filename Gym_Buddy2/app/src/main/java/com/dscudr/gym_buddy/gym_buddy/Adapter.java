package com.dscudr.gym_buddy.gym_buddy;

/**
 * Created by Monty on 01-02-2018.
 */

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

/**
 * Created by Monty on 30-12-2017.
 */

public class Adapter extends RecyclerView.Adapter{
    FragmentActivity ctx;
    String []s1;
    int img[];
    String current_tab;
    public Adapter(FragmentActivity ct, int[] i, String[] data,String current_tab)
    {
        this.ctx = ct;
        this.img = i;
        this.s1= data;
        this.current_tab=current_tab;
    }


    @Override
    public myownholder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View myownview = inflater.inflate(R.layout.exercise,parent,false);
        return new myownholder(myownview,ctx,current_tab);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        myownholder mh = (myownholder)holder;
        mh.t1.setText(s1[position].toString());
        mh.i1.setImageResource(img[position]);
    }


    @Override
    public int getItemCount()
    {
        return img.length;
    }

    @Override
    public long getItemId(int position) {

        return (position);
    }
    private class myownholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView t1;
        FragmentActivity ctx;
        ImageView i1;
        CardView card;
        String current_tab;
        int id;

        public myownholder(View itemView,FragmentActivity context,String current_tab)
        {
            super(itemView);
            this.ctx = context;
            t1 = (TextView)itemView.findViewById(R.id.exe_name);
            i1 = (ImageView)itemView.findViewById(R.id.exe_img);
            card = (CardView)itemView.findViewById(R.id.exe_card);
            this.current_tab=current_tab;
            card.setOnClickListener(this);
        }


        @Override
        public void onClick(View v)
        {
            t1 = (TextView)itemView.findViewById(R.id.exe_name);
            Intent i = new Intent(ctx,DetailedExercise.class);
            i.putExtra("name",t1.getText().toString());
            i.putExtra("cur_tab",current_tab);
            id = getAdapterPosition();
            i.putExtra("position",id);
            ctx.startActivity(i);

        }
    }

}
