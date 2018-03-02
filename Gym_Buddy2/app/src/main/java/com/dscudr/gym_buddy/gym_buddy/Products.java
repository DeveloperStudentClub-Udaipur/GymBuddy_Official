package com.dscudr.gym_buddy.gym_buddy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class Products extends Fragment {

    String name[];
    int img[] = {R.drawable.mt_01,R.drawable.mt_02,R.drawable.mt_03,R.drawable.mt_04,R.drawable.on_01,R.drawable.on_02,R.drawable.on_03,R.drawable.on_04,R.drawable.dm_01,R.drawable.dm_02,R.drawable.dm_03,R.drawable.dm_04,R.drawable.bm_01,R.drawable.bm_02,R.drawable.bm_03,R.drawable.bm_04,R.drawable.un_01,R.drawable.un_02,R.drawable.un_03,R.drawable.un_04};
    AdapterProduct adapterProduct;
    @BindView(R.id.recycle_product)
    RecyclerView recycleProduct;
    Unbinder unbinder;

    public Products() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);
        unbinder = ButterKnife.bind(this, view);
        name = getResources().getStringArray(R.array.protien_name);
        adapterProduct = new AdapterProduct(getActivity(), img, name);
        recycleProduct = view.findViewById(R.id.recycle_product);
        recycleProduct.setAdapter(adapterProduct);
        int col;
        if(getResources().getBoolean(R.bool.ori))
        {
            col = 2;
        }
        else
        {
            col=4;
        }

        recycleProduct.setLayoutManager(new GridLayoutManager(getActivity(), col));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
