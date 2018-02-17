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

import com.dscudr.gym_buddy.gym_buddy.DayFragments.FridayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.MondayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.SaturdayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.ThursdayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.TuesdayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.DayFragments.WednesdayFragmentClass;
import com.dscudr.gym_buddy.gym_buddy.diet_types_fragment.NonVegFragment;
import com.dscudr.gym_buddy.gym_buddy.diet_types_fragment.VegFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DietPlans extends Fragment {


    public DietPlans() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plans, container, false);
        TabLayout tab = (TabLayout)view.findViewById(R.id.tabLayout_diet);
        final ViewPager mypage = (ViewPager)view.findViewById(R.id.mypager_diet);
        mypage.setAdapter(new pagerAdapter_diet(getChildFragmentManager()));

        tab.setupWithViewPager(mypage);
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
class pagerAdapter_diet extends FragmentPagerAdapter {

    String data[] ={"Veg.","Non Veg."};

    public pagerAdapter_diet(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0) {
            return new VegFragment();
        }
        if (position == 1) {
            return new NonVegFragment();
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

