package com.jwrench.friday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jwrench.friday.interest.InterestDetailActivity;
import com.jwrench.friday.interest.InterestDummyRepository;
import com.jwrench.friday.interest.InterestFactory;
import com.jwrench.friday.interest.InterestListFragment;
import com.jwrench.friday.interest.InterestListPresenter;
import com.jwrench.friday.interest.InterestListView;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupInterestListFragment();
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
        } else if (id == R.id.action_create) {
            openInterestDetails();
        }

        return super.onOptionsItemSelected(item);
    }

    private void openInterestDetails() {
        Intent interestDetails = new Intent(this, InterestDetailActivity.class);
        startActivity(interestDetails);
    }

    private void setupInterestListFragment() {
        InterestListFragment interestListFragment = new InterestListFragment();

        InterestListPresenter presenter = InterestFactory.buildInterestListPresenter(interestListFragment, new InterestDummyRepository());
        interestListFragment.setPresenter(presenter);

        getFragmentManager().beginTransaction()
                .add(R.id.interest_list_container, interestListFragment)
                .commit();
    }

}
