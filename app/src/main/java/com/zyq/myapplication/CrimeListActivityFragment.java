package com.zyq.myapplication;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class CrimeListActivityFragment extends ListFragment {

//    public static String EXTRA_CRIME_ID = "CrimeListActivityFragment.EXTRA_CRIME_ID";
    private List<Crime> crimeList ;
    private String TAG = "CrimeListActivityFragment";
    public CrimeListActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        crimeList = CrimeLab.getCrimeLab(getActivity()).getCrimes();
//        ArrayAdapter<Crime> arrayAdapter = new ArrayAdapter<Crime>(getActivity(), R.layout.support_simple_spinner_dropdown_item, crimeList);
        setListAdapter(new CrimeAdapter(crimeList));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        System.out.println("iterm" + v + " is clicked");
        Log.d(TAG, "iterm" + v + " is clicked");
        Crime c = ((CrimeAdapter) getListAdapter()).getItem(position);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
        startActivity(intent);
    }

    private class CrimeAdapter extends ArrayAdapter<Crime>{
        public CrimeAdapter(List<Crime> crimes){
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_iterm_crime, null);

            }

            Crime c = getItem(position);
            TextView titleTextView= (TextView) convertView.findViewById(R.id.crime_list_titleTextView);
            titleTextView.setText(c.getTitle());
            TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_dateTextView);
            dateTextView.setText(c.getmDate().toString());
            CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_solvedCheckBox);
            solvedCheckBox.setChecked(c.ismSloved());
            return convertView;
        }
    }
    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_crime_list, container, false);
//    }
}
