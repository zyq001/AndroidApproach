package com.zyq.myapplication;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zangyq on 2016/2/22.
 * 记录集合类
 */
public class CrimeLab {
    private static CrimeLab crimeLab;
    private Context context;
    private ArrayList<Crime> crimeArrayList;
    private CrimeLab(Context _context){
        this.context = _context;
        crimeArrayList = new ArrayList<Crime>(100);
        for(int i = 0; i < 3; i++){
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setmSloved(i % 2 == 0);
            crimeArrayList.add(c);
        }
    }

    public static CrimeLab  getCrimeLab(Context _context){
        if(crimeLab == null){
            crimeLab = new CrimeLab(_context.getApplicationContext());
        }
        return crimeLab;
    }

    public void addCrime(Crime c){
        crimeArrayList.add(c);
    }
    public Crime getCrime(UUID uuid){
        for(Crime crime: crimeArrayList){
            if(crime.getId().equals(uuid))
                return crime;
        }
        return null;
    }

    public List<Crime> getCrimes(){
        return crimeArrayList;
    }
}
