package com.dscudr.gym_buddy.gym_buddy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.dscudr.gym_buddy.gym_buddy.PartWiseExercise;
import com.dscudr.gym_buddy.gym_buddy.R;
public class AdapterPartWise extends RecyclerView.Adapter{
    private  Context context;
    private int image_drawable[];

    public AdapterPartWise(Context context, int[] image_drawable)
    {
        this.context = context;
        this.image_drawable = image_drawable;
    }


    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View myownview = inflater.inflate(R.layout.parts,parent,false);
        return new ImageHolder(myownview,context);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ImageHolder mh = (ImageHolder)holder;
        mh.imageView.setImageResource(image_drawable[position]);

    }


    @Override
    public int getItemCount()
    {
        return image_drawable.length;
    }

    @Override
    public long getItemId(int position) {

        return (position);
    }

    private class ImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Context context;
        ImageView imageView;

        private ImageHolder(View itemView,Context context)
        {
            super(itemView);
            this.context = context;
            imageView = itemView.findViewById(R.id.part);
            imageView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v)
        {
            Intent i = new Intent(context,PartWiseExercise.class);
            i.putExtra("id",getAdapterPosition());
            context.startActivity(i);

        }
    }

}
