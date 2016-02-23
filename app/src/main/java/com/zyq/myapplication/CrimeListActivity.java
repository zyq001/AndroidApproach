package com.zyq.myapplication;

//import android.app.Fragment;
//import android.app.Fragment;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
//import android.support.v4.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_crime_list);
//    }

    @Override
    protected Fragment createFragment() {
        return new CrimeListActivityFragment();
    }

}
