package com.zyq.myapplication;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
//import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrimeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String EXTRA_CRIME_ID = "CrimeListActivityFragment.EXTRA_CRIME_ID";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Crime crime;
    private EditText editeTest;
    private CheckBox mCheckBoxSolved;
    private Button mButtonCrimeDate;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * 记录详情fragment，可自带参数args
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrimeFragment newInstance(String param1, String param2) {
        CrimeFragment fragment = new CrimeFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_CRIME_ID, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static CrimeFragment newInstance(UUID uuid) {

        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID, uuid);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CrimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimePagerActivity)getActivity()).getmViewPager().getAdapter().notifyDataSetChanged();
//        CrimeListActivityFragment.notifyChange();
//        ((CrimePagerActivity)getActivity())
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        crime = CrimeLab.getCrimeLab(getActivity()).getCrime((UUID) getActivity().getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID));
        UUID crimeId = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);//按返回键回到某Fragment时 并未putExtr传参数
        if(crime == null) crime = CrimeLab.getCrimeLab(getActivity()).getCrime(crimeId);//故此处可能拿一个空crimeId去取crime
        setHasOptionsMenu(true);
//        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.activity_fragment_toolbar);
//        toolbar.setTitle("CrimeRecd");
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        setHasOptionsMenu(true);
//        setRetainInstance(true);//保留frag
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(EXTRA_CRIME_ID);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
//        crime =
        editeTest = (EditText) v.findViewById(R.id.crimeTitle);
        editeTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                crime.setTitle(s.toString());
//                getActivity().
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if(crime.getTitle() != null) editeTest.setText(crime.getTitle());

        mButtonCrimeDate = (Button) v.findViewById(R.id.button_crime_date);
        mButtonCrimeDate.setText(crime.getmDate().toString());
        mButtonCrimeDate.setEnabled(false);

        mCheckBoxSolved = (CheckBox) v.findViewById(R.id.checkBox);
        mCheckBoxSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crime.setmSloved(isChecked);
            }
        });
        mCheckBoxSolved.setChecked(crime.ismSloved());

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB){
            if(NavUtils.getParentActivityName(getActivity()) != null){
                ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

//        TextView textView = new TextView(getActivity());
//        textView.setText(R.string.hello_blank_fragment);
        return v;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_crime_list, menu);
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_crime:
                Crime newCrime = new Crime();
                CrimeLab.getCrimeLab(getActivity()).addCrime(newCrime);
                Intent i = new Intent(getActivity(), CrimePagerActivity.class);
                i.putExtra(CrimeFragment.EXTRA_CRIME_ID, newCrime.getId());
//                ((CrimeListActivityFragment.CrimeAdapter)CrimeListActivityFragment.getListAdapter()).notifyDataSetChanged();
//                CrimeListActivityFragment.notifyChange();
                ((CrimePagerActivity)getActivity()).getmViewPager().getAdapter().notifyDataSetChanged();
                startActivityForResult(i, 0);
                return true;
            case R.id.home:
                if(NavUtils.getParentActivityName(getActivity()) != null){
                    NavUtils.navigateUpFromSameTask(getActivity());
                }
//                onBackPressed();
                return true;//忘写的话 会导致toolbar初始化出问题，导致getSupportActionBar()返回null
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
