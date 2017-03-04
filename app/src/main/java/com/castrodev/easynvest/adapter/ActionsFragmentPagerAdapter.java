package com.castrodev.easynvest.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.castrodev.easynvest.contact.ContactFragment;
import com.castrodev.easynvest.investment.InvestmentFragment;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class ActionsFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final String TAB_INVESTMENT = "INVESTMENT";
    private static final String TAB_CONTACT = "CONTACT";

    private static final int POSITION_INVESTMENT = 0;
    private static final int POSITION_CONTACT = 1;


    final int TABS_COUNT = 2;
    private String tabTitles[] = new String[]{TAB_INVESTMENT, TAB_CONTACT};
    private Context context;

    public ActionsFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case POSITION_INVESTMENT:
                return InvestmentFragment.newInstance();
            case POSITION_CONTACT:
                return ContactFragment.newInstance();
        }
        return new Fragment();
    }

    @Override
    public int getCount() {
        return TABS_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

