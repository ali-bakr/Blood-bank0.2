package com.example.aliaboubakr.faselet_eldam_2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager;
//import android.support.v7.app.ActionBar.Tab;
//import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aliaboubakr.faselet_eldam_2.DonationOrder.OrdesForm;


public class HomeFragment extends Fragment {
/*    public ViewPager viewPager;
    public TabsPagerAdapter mAdapter;
    public ActionBar actionBar;
    public String[] tabs = { "first tap", "tap two" };
  //  public Fragment[] fras = { new HomeTwo(),new FragOne()};

 */

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.navv_fragment_home, container, false);

        FloatingActionButton floatingActionButton =view.findViewById(R.id.fab_1);
floatingActionButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
// new instance
        OrdesForm ordesForm=new OrdesForm();
        //replac the frag on framlayout
        getFragmentManager()
                .beginTransaction().replace(R.id.frag_container,ordesForm).commit();

    }
});

TabLayout taps = view.findViewById(R.id.viewPager_taps_id);
        ViewPager vpager = view.findViewById(R.id.viewPager_taps);
        TabPagerAdaptor tpAdaptor = new TabPagerAdaptor(getChildFragmentManager());
        vpager.setAdapter(tpAdaptor);
        taps.setupWithViewPager(vpager);
        return view;


    }

        /*
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
///////////////////////////////////////////////////////  implementation 'com.android.support.constraint:constraint-layout:1.1.0-beta1'
///////////////////////////// implementation 'com.android.support:support-v4:28.0.0'
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {

    }


*/


}
