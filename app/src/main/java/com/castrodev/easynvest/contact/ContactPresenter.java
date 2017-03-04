package com.castrodev.easynvest.contact;

import android.support.annotation.NonNull;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class ContactPresenter implements ContactContract.UserActionsListener {

    @NonNull
    private final ContactContract.View mHistoryView;

    public ContactPresenter(@NonNull ContactContract.View view) {
        mHistoryView = checkNotNull(view);
    }

    @Override
    public void submitData() {

    }

    @Override
    public void sendNewMessage() {

    }
}
