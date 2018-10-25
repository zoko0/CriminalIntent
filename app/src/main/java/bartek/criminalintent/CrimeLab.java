package bartek.criminalintent;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ciulkba4 on 09.10.2018.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;


    static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new LinkedList<>();
    }

    public LinkedList<Crime> getCrimes() {
        return (LinkedList<Crime>) mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }

    public void addCimre(Crime crime) {
        mCrimes.add(crime);
    }

}
