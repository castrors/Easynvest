package com.castrodev.easynvest.contact;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.castrodev.easynvest.SuccessActivity;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class ContactPresenter implements ContactContract.UserActionsListener {

    @NonNull
    private final ContactContract.View contactView;
    private final Context context;

    public ContactPresenter(Context context, @NonNull ContactContract.View view) {
        contactView = checkNotNull(view);
        this.context = context;
    }

    @Override
    public void submitData() {
        Intent intent = new Intent(context, SuccessActivity.class);
        context.startActivity(intent);
    }

}
