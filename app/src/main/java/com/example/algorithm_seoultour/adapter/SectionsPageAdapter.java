/**
 * 메인페이지의 Fragment 전환을 위한 어댑터
 */
package com.example.algorithm_seoultour.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SectionsPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public void addFragment(Fragment fragment,String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public SectionsPageAdapter(FragmentManager fm){
        super(fm);
    }

    public CharSequence getPageTitle(int position){
        return  mFragmentTitleList.get(position);
    }

    @Override
    public @NotNull Fragment getItem(int position){
        return mFragmentList.get(position);

    }

    @Override
    public int getCount(){
        return mFragmentList.size();
    }

}
