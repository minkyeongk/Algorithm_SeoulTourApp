/**
 * 앱의 메인 화면
 */
package com.example.algorithm_seoultour.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import com.example.algorithm_seoultour.R;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.util.Log;
import com.example.algorithm_seoultour.adapter.SectionsPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: Starting.");

        ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tap1_fragment(),"최단거리 추천");
        adapter.addFragment(new Tap2_fragment(),"관광지 리스트");
        adapter.addFragment(new Tap3_fragment(),"기타 여행정보");
        viewPager.setAdapter(adapter);
    }
}
