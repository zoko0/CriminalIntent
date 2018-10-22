package bartek.criminalintent;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by ciulkba4 on 08.10.2018.
 */

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
        Random rand = new Random();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String formatDate(Date date) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return df.format(date);
    }
}
