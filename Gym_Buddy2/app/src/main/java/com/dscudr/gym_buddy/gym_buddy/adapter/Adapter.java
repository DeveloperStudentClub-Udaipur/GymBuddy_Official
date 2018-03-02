package com.dscudr.gym_buddy.gym_buddy.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.dscudr.gym_buddy.gym_buddy.DetailedExercise;
import com.dscudr.gym_buddy.gym_buddy.R;

public class Adapter extends RecyclerView.Adapter{
    private Context context;
    private String []exercise_name;
    private int image_drawable[];
    private String current_tab;
    public Adapter(Context context, int[] image_drawable, String[] exercise_name, String current_tab)
    {
        this.context = context;
        this.image_drawable = image_drawable;
        this.exercise_name= exercise_name;
        this.current_tab=current_tab;
    }


    @Override
    public Myownholder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View myownview = inflater.inflate(R.layout.exercise,parent,false);
        return new Myownholder(myownview,context,current_tab);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Myownholder myownholder = (Myownholder)holder;
        myownholder.exercise_name.setText(exercise_name[position]);
        myownholder.image_drawable.setImageResource(image_drawable[position]);
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
    private class Myownholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView exercise_name;
        Context context;
        ImageView image_drawable;
        CardView cardView;
        String current_tab;
        int id;

        private Myownholder(View itemView,Context context,String current_tab)
        {
            super(itemView);
            this.context = context;
            exercise_name = itemView.findViewById(R.id.exe_name);
            image_drawable = itemView.findViewById(R.id.exe_img);
            cardView = itemView.findViewById(R.id.exe_card);
            this.current_tab=current_tab;
            cardView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v)
        {
            exercise_name = itemView.findViewById(R.id.exe_name);
            Intent i = new Intent(context,DetailedExercise.class);
            i.putExtra("name",exercise_name.getText().toString());
            i.putExtra("cur_tab",current_tab);
            id = getAdapterPosition();
            i.putExtra("position",id);
            context.startActivity(i);

        }
    }

}
