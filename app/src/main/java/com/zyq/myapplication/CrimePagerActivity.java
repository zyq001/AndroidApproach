package com.zyq.myapplication;

//import android.app.Fragment;
//import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;
import java.util.UUID;

/**
 * 可滑动切换详情页容器Activity
 * 使用ViewPager（自定义一个空的id资源）
 * 使用PagerAdapter获取要显示的fragment（记录详情-CrimeFragment）
 * */
//public class CrimePagerActivity extends AppCompatActivity {
public class CrimePagerActivity extends BaseActivity {

    public ViewPager getmViewPager() {
        return mViewPager;
    }

    private ViewPager mViewPager;
    private List<Crime> crimes;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_crime_pager);

//        mViewPager = new ViewPager(this);
//        mViewPager.setId(R.id.viewPager);

        setContentView(R.layout.activity_crime_parger);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
//        toolbar = (Toolbar) findViewById(R.id.crime_pager_toolbar);
////        toolbar.setTitle("CrimeRecd");
//        setSupportActionBar(toolbar);


        crimes = CrimeLab.getCrimeLab(this).getCrimes();
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
                                  @Override
                                  public int getCount() {
                                      return crimes.size();
                                  }

                                  @Override
                                  public android.support.v4.app.Fragment getItem(int position) {
                                      Crime crime = crimes.get(position);
//                                      setTitle(crime.getTitle());//此处crime是预测下一个要显示的crime，故不能再这里setTitle
                                      return CrimeFragment.newInstance(crime.getId());
                                  }
                              }
        );

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {

                Crime current = crimes.get(position);
                if(current.getTitle() != null){
                    setTitle(current.getTitle());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        UUID selectedCrimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for(int i = 0; i < crimes.size(); i++){
            if(crimes.get(i).getId().equals(selectedCrimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
//        mViewPager.setCurrentItem();
    }


//    @Override
//    protected Fragment createFragment() {
//        UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
//        return CrimeFragment.newInstance(crimeId);
//    }

}
