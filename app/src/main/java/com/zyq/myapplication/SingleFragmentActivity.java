package com.zyq.myapplication;

import android.app.Activity;
//import android.app.Fragment;
//import android.app.Fragment;
//import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
//
//        findViewById(R.id.orgBtn2StartNewBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                System.out.println();
//                Intent i = new Intent(MainActivity.this, AnotherActivity.class);
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

    }

    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
