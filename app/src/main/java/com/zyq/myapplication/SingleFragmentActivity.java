package com.zyq.myapplication;

//import android.app.Fragment;
//import android.app.Fragment;
//import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * 使用layout/activity_fragment视图的容器Activity，作为不同盛载fragment的activity的基类
 * */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
        setContentView(R.layout.activity_fragment);
        addToolbar();


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

    }

    private void addToolbar() {
//        toolbar = (Toolbar)findViewById(R.id.org_toolbar);
        toolbar = (Toolbar)findViewById(R.id.activity_fragment_toolbar);
        toolbar.setTitle("CrimeRecd");
        setSupportActionBar(toolbar);
    }

    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
