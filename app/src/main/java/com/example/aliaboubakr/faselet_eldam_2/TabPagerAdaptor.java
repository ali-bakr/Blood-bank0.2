package com.example.aliaboubakr.faselet_eldam_2;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_articles.Frag_Article;
import com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_orders.Frag_Orders;

public class TabPagerAdaptor extends FragmentStatePagerAdapter {

    String [] TapArray={"طلبات التبرع","المقالات"};
    Integer num=2;
    public TabPagerAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TapArray[position];

    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                Frag_Orders f_orders=new Frag_Orders();
                return f_orders;
            case 1:
                Frag_Article f_article=new Frag_Article();
                return f_article;
                    }
        return null;
    }

    @Override
    public int getCount() {
        return num ;
    }
}
