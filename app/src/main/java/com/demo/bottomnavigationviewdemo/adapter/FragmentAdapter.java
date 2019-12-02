package com.demo.bottomnavigationviewdemo.adapter;

import com.demo.bottomnavigationviewdemo.fragment.HomeFragment;
import com.demo.bottomnavigationviewdemo.fragment.NoticeFragment;
import com.demo.bottomnavigationviewdemo.fragment.ShowFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * FileName:   FragmentAdapter
 * Author:     nizonglong
 * CreateTime: 2019/12/2 17:03
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    // 私有成员mFragments，加载页面碎片
    private List<Fragment> mFragments = new ArrayList<>();

    public FragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        // 加载初始化Fragment
        mFragments.add(new HomeFragment());
        mFragments.add(new ShowFragment());
        mFragments.add(new NoticeFragment());
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = mFragments.get(0);
                break;
            case 1:
                fragment = mFragments.get(1);

                break;
            case 2:
                fragment = mFragments.get(2);

                break;
            case 3:
                fragment = mFragments.get(3);
                break;
            default:
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
