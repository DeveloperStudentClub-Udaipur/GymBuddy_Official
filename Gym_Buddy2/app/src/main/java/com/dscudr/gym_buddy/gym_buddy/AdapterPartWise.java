package com.dscudr.gym_buddy.gym_buddy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Monty on 03-02-2018.
 */

public class AdapterPartWise extends RecyclerView.Adapter{
    Context ctx;
    int img[];

    public AdapterPartWise(Context ct, int[] i)
    {
        this.ctx = ct;
        this.img = i;
    }


    @Override
    public imageholder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View myownview = inflater.inflate(R.layout.parts,parent,false);
        return new imageholder(myownview,ctx);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        imageholder mh = (imageholder)holder;
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

    private class imageholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Context ctx;
        ImageView i1;
        int id;

        public imageholder(View itemView,Context context)
        {
            super(itemView);
            this.ctx = context;
            i1 = (ImageView)itemView.findViewById(R.id.part);
            i1.setOnClickListener(this);
        }


        @Override
        public void onClick(View v)
        {
            Intent i = new Intent(ctx,PartWiseExercise.class);
            i.putExtra("id",getAdapterPosition());
            ctx.startActivity(i);

        }
    }

}
