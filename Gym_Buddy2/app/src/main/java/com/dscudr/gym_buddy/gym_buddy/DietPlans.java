package com.dscudr.gym_buddy.gym_buddy;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dscudr.gym_buddy.gym_buddy.diet_types_fragment.NonVegFragment;
import com.dscudr.gym_buddy.gym_buddy.diet_types_fragment.VegFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class DietPlans extends Fragment {


    @BindView(R.id.tabLayout_diet)
    TabLayout tabLayoutDiet;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.mypager_diet)
    ViewPager mypagerDiet;
    Unbinder unbinder;

    public DietPlans() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plans, container, false);
        unbinder = ButterKnife.bind(this, view);

        mypagerDiet.setAdapter(new pagerAdapter_diet(getChildFragmentManager()));
        tabLayoutDiet.setupWithViewPager(mypagerDiet);
        tabLayoutDiet.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mypagerDiet.setCurrentItem(tab.getPosition());
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

class pagerAdapter_diet extends FragmentPagerAdapter {

    private  String data[] = {"Veg.", "Non Veg."};

    public pagerAdapter_diet(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new VegFragment();
        }
        if (position == 1) {
            return new NonVegFragment();
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

