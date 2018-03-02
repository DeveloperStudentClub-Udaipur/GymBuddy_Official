package com.dscudr.gym_buddy.gym_buddy;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



class AdapterProduct extends RecyclerView.Adapter{
    private FragmentActivity ctx;
    private int img[];
    private String []details;
    public AdapterProduct(FragmentActivity ct, int[] i,String []detail)
    {
        this.ctx = ct;
        this.img = i;
        this.details=detail;
    }


    @Override
    public Productholder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View myownview = inflater.inflate(R.layout.protien_product,parent,false);
        return new Productholder(myownview,ctx);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        Productholder productholder = (Productholder) holder;
        productholder.product_image.setImageResource(img[position]);
        productholder.Product_detail.setText(details[position]);
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

    private class Productholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        FragmentActivity ctx;
        LinearLayout Product;
        ImageView product_image;
        TextView Product_detail;
        int id;

        private Productholder(View itemView,FragmentActivity context)
        {
            super(itemView);
            this.ctx = context;
            Product = itemView.findViewById(R.id.product);
            product_image = itemView.findViewById(R.id.product_image);
            Product_detail = itemView.findViewById(R.id.Detail);
            Product.setOnClickListener(this);
        }


        @Override
        public void onClick(View v)
        {
            Intent i = new Intent(ctx,ProductDetail.class);
            i.putExtra("id",getAdapterPosition());
            ctx.startActivity(i);
        }
    }

}
