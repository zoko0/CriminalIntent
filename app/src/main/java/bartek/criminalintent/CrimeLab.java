package bartek.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ciulkba4 on 09.10.2018.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private Map<UUID, Crime> mCrimes;


    static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new LinkedHashMap<>();

        // Generating some crimes
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.put(crime.getId(), crime);
        }

    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        return mCrimes.get(id);
    }
}
