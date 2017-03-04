package com.castrodev.easynvest.investment;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class InvestmentContract {

    interface View {

        void setProgressIndicator(boolean active);
        void showInvestentData();

    }

    interface UserActionsListener {

        void submitData();
        void shareData();
        void download();

    }
}
