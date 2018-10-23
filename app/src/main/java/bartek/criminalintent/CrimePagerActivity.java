package bartek.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.List;
import java.util.UUID;

/**
 * Created by ciulkba4 on 23.10.2018.
 */

public class CrimePagerActivity extends AppCompatActivity {

    private static final String EXTRA_CRIME_ID = "bartek.criminal.intent.crime_id";

    private ViewPager mViewPager;
    private List<Crime> mCrimes;
    private Button lastItemButton;
    private Button firstItemButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        lastItemButton = (Button) findViewById(R.id.last_button);
        firstItemButton = (Button) findViewById(R.id.first_button);
        mViewPager = (ViewPager) findViewById(R.id.crime_view_pager);
        mCrimes = (List<Crime>) CrimeLab.get(this).getCrimes();

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        for (int i=0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

        firstItemButton.setOnClickListener( view  -> mViewPager.setCurrentItem(0) );
        lastItemButton.setOnClickListener( view -> mViewPager.setCurrentItem(mViewPager.getAdapter().getCount() - 1) );

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(mViewPager.getCurrentItem() == 0) {
                    firstItemButton.setEnabled(false);
                } else {
                    firstItemButton.setEnabled(true);
                }

                if(mViewPager.getCurrentItem() == mViewPager.getAdapter().getCount() - 1) {
                    lastItemButton.setEnabled(false);
                } else {
                    lastItemButton.setEnabled(true);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

}
