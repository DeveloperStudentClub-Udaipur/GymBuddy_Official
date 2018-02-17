package com.dscudr.gym_buddy.gym_buddy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Monty on 08-02-2018.
 */

class AdapterProduct extends RecyclerView.Adapter{
    FragmentActivity ctx;
    int img[],price[];
    String []details;
    public AdapterProduct(FragmentActivity ct, int[] i,String []detail,int []price)
    {
        this.ctx = ct;
        this.img = i;
        this.details=detail;
        this.price=price;
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
        productholder.Product_price.setText(price[position]+"");
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
        TextView Product_detail,Product_price;
        int id;

        public Productholder(View itemView,FragmentActivity context)
        {
            super(itemView);
            this.ctx = context;
            Product = (LinearLayout) itemView.findViewById(R.id.product);
            product_image = (ImageView)itemView.findViewById(R.id.product_image);
            Product_detail = (TextView)itemView.findViewById(R.id.Detail);
            Product_price = (TextView)itemView.findViewById(R.id.rate);
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
