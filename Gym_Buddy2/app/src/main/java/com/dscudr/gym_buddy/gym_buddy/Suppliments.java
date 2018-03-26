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

public class Suppliments extends Fragment {


    public Suppliments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_suppliments, container, false);
        TabLayout tab = view.findViewById(R.id.tabLayout_suppliment);
        final ViewPager mypage = view.findViewById(R.id.mypager_suppliment);
        mypage.setAdapter(new pagerAdapter_suppliment(getChildFragmentManager()));

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
class pagerAdapter_suppliment extends FragmentPagerAdapter {

    private String data[] ={"Products","Details"};

    public pagerAdapter_suppliment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0) {
            return new Products();
        }
        if (position == 1) {
            return new Protiens();
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

