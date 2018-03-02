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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class DayWise extends Fragment {

    View view;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.mypager)
    ViewPager mypager;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_day_wise, container, false);
        unbinder = ButterKnife.bind(this, view);

        mypager.setAdapter(new pagerAdapter(getChildFragmentManager()));

        tabLayout.setupWithViewPager(mypager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
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

class pagerAdapter extends FragmentPagerAdapter {

    String data[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public pagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MondayFragmentClass();
        }
        if (position == 1) {
            return new TuesdayFragmentClass();
        }
        if (position == 2) {
            return new WednesdayFragmentClass();
        }
        if (position == 3) {
            return new ThursdayFragmentClass();
        }
        if (position == 4) {
            return new FridayFragmentClass();
        }
        if (position == 5) {
            return new SaturdayFragmentClass();
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

