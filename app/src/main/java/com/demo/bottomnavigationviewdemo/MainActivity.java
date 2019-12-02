package com.demo.bottomnavigationviewdemo;

import android.os.Bundle;
import android.view.MenuItem;

import com.demo.bottomnavigationviewdemo.adapter.FragmentAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager            mViewPager;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView() {
        // BottomNavigationView
        navigation = findViewById(R.id.nav_view);
        // 去除背景底色
        navigation.setItemIconTintList(null);
        // 实例化adapter，得到fragment
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.viewpager);
        // 建立连接
        mViewPager.setAdapter(fragmentAdapter);

        setNavigation();
    }

    /**
     * 设置底部导航栏
     */
    public void setNavigation() {

        // 底部导航栏点击事件
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                resetIcon();
                switchMenu(item);
                return true;
            }
        });

        //viewpager监听事件，当viewpager滑动时得到对应的fragment碎片
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigation.getMenu().getItem(position).setChecked(true);
                switchMenu(navigation.getMenu().getItem(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 导航栏切换方法
     */
    private void switchMenu(MenuItem item){
        switch (item.getItemId()) {
            case R.id.navigation_home:
                item.setIcon(R.drawable.ic_home_selected);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.navigation_show:
                mViewPager.setCurrentItem(1);
                item.setIcon(R.drawable.ic_show_selected);
                break;
            case R.id.navigation_notice:
                mViewPager.setCurrentItem(2);
                item.setIcon(R.drawable.ic_notice_selected);
                break;
            default:
        }
    }

    /**
     * 重置底部导航栏图标
     */
    private void resetIcon() {
        MenuItem home = navigation.getMenu().findItem(R.id.navigation_home);
        home.setIcon(R.drawable.ic_home_black_24dp);
        home = navigation.getMenu().findItem(R.id.navigation_show);
        home.setIcon(R.drawable.ic_dashboard_black_24dp);
        home = navigation.getMenu().findItem(R.id.navigation_notice);
        home.setIcon(R.drawable.ic_notifications_black_24dp);
    }
}
