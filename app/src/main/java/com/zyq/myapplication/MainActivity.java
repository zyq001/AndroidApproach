package com.zyq.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.my_layout);
        findViewById(R.id.orgBtn2StartNewBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.println();
                Intent i = new Intent(MainActivity.this, AnotherActivity.class);
                i.putExtra("transferDate", "transferedData!");

                Bundle bundle = new Bundle();
                bundle.putInt("int", 1);
                bundle.putString("string", "string");
                Bundle newBundle = new Bundle();
                newBundle.putString("newString", "newstring");
                bundle.putBundle("newbundle", newBundle);
                i.putExtra("b", bundle);

                startActivity(i);
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://jiekexueyuan.com")));
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
