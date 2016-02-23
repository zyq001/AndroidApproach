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

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private List<Crime> crimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_crime_pager);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

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
                                      return CrimeFragment.newInstance(crime.getId());
                                  }
                              }
        );

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
