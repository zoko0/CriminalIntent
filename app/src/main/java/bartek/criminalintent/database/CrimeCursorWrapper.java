package bartek.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

import bartek.criminalintent.Crime;
import bartek.criminalintent.database.CrimeDbShema.CrimeTable;


public class CrimeCursorWrapper extends CursorWrapper {

    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));

        Date dateDate = new Date(date);

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(dateDate);
        crime.setTime(new Time(dateDate.getTime()));
        crime.setSolved(isSolved != 0);

        return crime;
    }
}
