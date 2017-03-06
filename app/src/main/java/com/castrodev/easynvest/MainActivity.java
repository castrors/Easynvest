package com.castrodev.easynvest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.castrodev.easynvest.adapter.ActionsFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.castrodev.easynvest.SuccessActivity.SEND_NEW_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    boolean sendNewMessage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(SEND_NEW_MESSAGE)) {
            sendNewMessage = extras.getBoolean(SEND_NEW_MESSAGE, false);
        }
        ButterKnife.bind(this);
        setupViewPagerAndTabs();
    }

    private void setupViewPagerAndTabs() {
        viewPager.setAdapter(new ActionsFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));
        tabLayout.setupWithViewPager(viewPager);

        if (sendNewMessage) {
            tabLayout.getTabAt(1).select();
        }
    }


}
