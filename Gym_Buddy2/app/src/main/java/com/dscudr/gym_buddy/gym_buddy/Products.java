package com.dscudr.gym_buddy.gym_buddy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Products extends Fragment {

    String name[] = {"Whey Protien"};
    int img[] = {R.drawable.whey_box};
    int price[] = {134};
    AdapterProduct adapterProduct;
    RecyclerView recyclerView;
    public Products()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);
        adapterProduct = new AdapterProduct(getActivity(),img,name,price);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycle_product);
        recyclerView.setAdapter(adapterProduct);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return  view;
    }

}
