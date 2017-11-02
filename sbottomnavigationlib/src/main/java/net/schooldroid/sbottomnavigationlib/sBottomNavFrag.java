package net.schooldroid.sbottomnavigationlib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


public class sBottomNavFrag extends Fragment {

    BottomNavigationViewEx btm;
    Menu menu;

    boolean setTitle, setIcon, setFrag;
    String title1,title2,title3,title4,title5;
    @DrawableRes int icon1,icon2,icon3,icon4,icon5;
    Fragment fragment1,fragment2,fragment3,fragment4,fragment5;

    public sBottomNavFrag() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_s_bottom_nav, container, false);

        Log.d("Hehe","Hehe");

        btm = view.findViewById(R.id.btmFrag);
        menu = btm.getMenu();

        if(setTitle) {
            applyTitle();
        }
        if(setIcon){
            applyIcon();
        }
        if(setFrag){
            applyFragment();
        }

        return view;
    }

    public void setIcon (@DrawableRes int icon1, @DrawableRes int icon2 , @DrawableRes int icon3 , @DrawableRes int icon4 , @DrawableRes int icon5){
        setIcon = true;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.icon3 = icon3;
        this.icon4 = icon4;
        this.icon5 = icon5;
    }

    public void setTitle (String title1, String title2, String title3, String title4, String title5){
        setTitle = true;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.title4 = title4;
        this.title5 = title5;
    }

    public void setFragment (Fragment fragment1, Fragment fragment2, Fragment fragment3, Fragment fragment4, Fragment fragment5){
        setFrag = true;
        this.fragment1 = fragment1;
        this.fragment2 = fragment2;
        this.fragment3 = fragment3;
        this.fragment4 = fragment4;
        this.fragment5 = fragment5;
        Log.d("SET","FRAGMENT");
    }

    private void applyIcon (){
        menu.findItem(R.id.item1).setIcon(icon1);
        menu.findItem(R.id.item2).setIcon(icon2);
        menu.findItem(R.id.item3).setIcon(icon3);
        menu.findItem(R.id.item4).setIcon(icon4);
        menu.findItem(R.id.item5).setIcon(icon5);
    }

    private void applyTitle (){
        menu.findItem(R.id.item1).setTitle(title1);
        menu.findItem(R.id.item2).setTitle(title2);
        menu.findItem(R.id.item3).setTitle(title3);
        menu.findItem(R.id.item4).setTitle(title4);
        menu.findItem(R.id.item5).setTitle(title5);
    }

    private void applyFragment (){
        btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getChildFragmentManager();
                FragmentTransaction t = manager.beginTransaction();

                int i = item.getItemId();
                if (i == R.id.item1 && fragment1!=null) {
                    t.replace(R.id.contentFrag,fragment1).commit();
                    return true;
                }
                if (i == R.id.item2 && fragment2!=null){
                    t.replace(R.id.contentFrag,fragment2).commit();
                    return true;
                }
                if (i == R.id.item3 && fragment3!=null){
                    t.replace(R.id.contentFrag,fragment3).commit();
                    return true;
                }
                if (i == R.id.item4 && fragment4!=null){
                    t.replace(R.id.contentFrag,fragment4).commit();
                    return true;
                }
                if (i == R.id.item5 && fragment5!=null){
                    t.replace(R.id.contentFrag,fragment5).commit();
                    return true;
                }

                return false;
            }
        });

        btm.setSelectedItemId(R.id.item1);
    }

}