package com.dscudr.gym_buddy.gym_buddy;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class Competitions extends Fragment {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.mypager)
    ViewPager mypager;
    Unbinder unbinder;

    public Competitions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_compititions, container, false);
        unbinder = ButterKnife.bind(this, view);

        mypager.setAdapter(new competitionsAdapter(getChildFragmentManager()));

        tabLayout.setupWithViewPager(mypager);
        if(getResources().getBoolean(R.bool.ori))
        {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
        else
        {
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mypager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

class competitionsAdapter extends FragmentPagerAdapter {

    private String data[] = {"Body Building", "Physique", "Weight Lifting", "Power Lifting"};

    public competitionsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new BodyBuilding();
        }
        if (position == 1) {
            return new Physique();
        }
        if (position == 2) {
            return new WeightLifting();
        }
        if (position == 3) {
            return new PowerLifting();
        }
        return null;
    }

    @Override
    public int getCount() {
        return data.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return data[position];
    }

}
