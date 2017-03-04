package com.castrodev.easynvest.investment;

import android.support.annotation.NonNull;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by rodrigocastro on 04/03/17.
 */

class InvestmentPresenter implements InvestmentContract.UserActionsListener {
    @NonNull
    private final InvestmentContract.View mHistoryView;

    public InvestmentPresenter(@NonNull InvestmentContract.View view) {
        mHistoryView = checkNotNull(view);
    }

    @Override
    public void submitData() {

    }

    @Override
    public void shareData() {

    }

    @Override
    public void download() {

    }

}
