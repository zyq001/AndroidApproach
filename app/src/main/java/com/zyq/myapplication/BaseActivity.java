package com.zyq.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by zangyq on 2016/3/1.
 */
public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private LinearLayout rootLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
        super.setContentView(R.layout.activity_base);
        addToolbar();
    }
    private void addToolbar() {
//        toolbar = (Toolbar)findViewById(R.id.org_toolbar);
        toolbar = (Toolbar)findViewById(R.id.org_toolbar);
        if(toolbar != null){
            toolbar.setTitle("CrimeRecd");
            setSupportActionBar(toolbar);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////        super.onCreateOptionsMenu(menu, inflater);
//        getMenuInflater().inflate(R.menu.menu_crime_list, menu);
//        return true;
//    }

    @Override
    public void setContentView(int layoutId) {
        setContentView(View.inflate(this, layoutId, null));
    }

    @Override
    public void setContentView(View view) {
        rootLayout = (LinearLayout) findViewById(R.id.root_layout);
        if (rootLayout == null) return;
        rootLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addToolbar();
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.new_crime:
//                Crime newCrime = new Crime();
//                CrimeLab.getCrimeLab(this).addCrime(newCrime);
//                Intent i = new Intent(this, CrimePagerActivity.class);
//                i.putExtra(CrimeFragment.EXTRA_CRIME_ID, newCrime.getId());
////                ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
//                startActivityForResult(i, 0);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
