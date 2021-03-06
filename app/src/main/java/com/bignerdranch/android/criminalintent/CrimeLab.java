package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lety02 on 2017. 1. 12..
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for(int i = 0 ; i < 100; i++)
        {
            Crime crime = new Crime();
            crime.setTitle("범죄 #" + i);
            crime.setSolved(i % 2 == 0); // 짝수 번째 요소에는 true를 임의 설정한다.
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id)
    {
        for(Crime crime : mCrimes)
        {
            if(crime.getId().equals(id))
            {
               return crime;
            }
        }
        return null;
    }
}

