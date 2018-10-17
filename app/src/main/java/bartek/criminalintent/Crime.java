package bartek.criminalintent;

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
    private int mRequiresPolice;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            mRequiresPolice = 0;
        } else {
            mRequiresPolice = 1;
        }
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

    public int isRequiresPolice() {
        return mRequiresPolice;
    }

    public void setRequiresPolice(int requiresPolice) {
        mRequiresPolice = requiresPolice;
    }
}