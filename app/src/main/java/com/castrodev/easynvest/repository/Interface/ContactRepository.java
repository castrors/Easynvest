package com.castrodev.easynvest.repository.Interface;

import android.content.Context;

import com.castrodev.easynvest.model.ContactScreenData;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public abstract class ContactRepository {
    public abstract ContactScreenData getContactScreenData(Context context);
}
