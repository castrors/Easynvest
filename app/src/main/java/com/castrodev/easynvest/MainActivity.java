package com.castrodev.easynvest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.castrodev.easynvest.adapter.ActionsFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager) ViewPager viewPager;
    @BindView(R.id.tab_layout) TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        InvestmentScreenData investmentScreenData = Repository.providesInvestmentRepository().getInvestmentScreenData(this);
//        ContactScreenData contactScreenData = Repository.providesContactRepository().getContactScreenData(this);


        setupViewPagerAndTabs();
    }

    private void setupViewPagerAndTabs() {
        viewPager.setAdapter(new ActionsFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));
        tabLayout.setupWithViewPager(viewPager);
    }

}
