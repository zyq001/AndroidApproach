package com.zyq.myapplication;


import android.os.Bundle;
//import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        crime = CrimeLab.getCrimeLab(getActivity()).getCrime((UUID) getActivity().getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID));
        UUID crimeId = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
        crime = CrimeLab.getCrimeLab(getActivity()).getCrime(crimeId);
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
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editeTest.setText(crime.getTitle());

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
//        TextView textView = new TextView(getActivity());
//        textView.setText(R.string.hello_blank_fragment);
        return v;
    }



}
