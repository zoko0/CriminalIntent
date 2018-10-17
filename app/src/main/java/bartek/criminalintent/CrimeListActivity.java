package bartek.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by ciulkba4 on 09.10.2018.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
