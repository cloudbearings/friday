package com.jwrench.friday;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jwrench.friday.interest.InterestDummyRepository;
import com.jwrench.friday.interest.InterestListFragment;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupInterestListFragment(createInterestListRepository());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private InterestDummyRepository createInterestListRepository() {
        return new InterestDummyRepository();
    }

    private void setupInterestListFragment(InterestDummyRepository repository) {
        InterestListFragment interestListFragment = new InterestListFragment();

        interestListFragment.setRepository(repository);

        getFragmentManager().beginTransaction()
                .add(R.id.interest_list_container, interestListFragment)
                .commit();
    }

}
