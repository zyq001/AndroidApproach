package com.zyq.myapplication;

import android.app.Activity;
//import android.app.Fragment;
import android.app.FragmentManager;
import android.os.PersistableBundle;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeDetailsActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        UUID uuid = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(uuid);
//        return new CrimeFragment();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_fragment);
//        setContentView(R.layout.activity_fragment);
//
//        FragmentManager fragmentManager = getFragmentManager();
//        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
//        if (fragment == null) {
//            fragment = new CrimeFragment();
//            fragmentManager.beginTransaction()
//                    .add(R.id.fragmentContainer, fragment)
//                    .commit();
//        }
//
//        findViewById(R.id.orgBtn2StartNewBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                System.out.println();
//                Intent i = new Intent(CrimeDetailsActivity.this, AnotherActivity.class);
//                i.putExtra("transferDate", "transferedData!");
//
//                Bundle bundle = new Bundle();
//                bundle.putInt("int", 1);
//                bundle.putString("string", "string");
//                Bundle newBundle = new Bundle();
//                newBundle.putString("newString", "newstring");
//                bundle.putBundle("newbundle", newBundle);
//                i.putExtra("b", bundle);
//
//                startActivity(i);
////                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://jiekexueyuan.com")));
//            }
//        });
//
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//
//    }
}
