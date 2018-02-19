package com.dscudr.gym_buddy.gym_buddy;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dscudr.gym_buddy.gym_buddy.DayFragments.FridayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.MondayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.SaturdayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.ThursdayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.TuesdayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.WednesdayFragmentClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class Competitions extends Fragment {

    public Competitions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compititions, container, false);
        TabLayout tab = (TabLayout)view.findViewById(R.id.tabLayout);
        final ViewPager mypage = (ViewPager)view.findViewById(R.id.mypager);
        mypage.setAdapter(new competitionsAdapter(getChildFragmentManager()));

        tab.setupWithViewPager(mypage);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                mypage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });

        return view;
    }

}
class competitionsAdapter extends FragmentPagerAdapter {

    String data[] ={"Body Building","Physique","Weight Lifting","Power Lifting"};

    public competitionsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
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
    public int getCount()
    {
        return data.length;
    }


    @Override
    public CharSequence getPageTitle(int position)
    {
        return data[position];
    }

}
