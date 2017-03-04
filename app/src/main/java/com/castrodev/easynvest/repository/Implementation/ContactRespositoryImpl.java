package com.castrodev.easynvest.repository.Implementation;

import android.content.Context;

import com.castrodev.easynvest.R;
import com.castrodev.easynvest.model.ContactScreenData;
import com.castrodev.easynvest.repository.Interface.ContactRepository;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class ContactRespositoryImpl extends ContactRepository {

    @Override
    public ContactScreenData getContactScreenData(Context context) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.cells);
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));

        Gson gson = new Gson();
        return gson.fromJson(reader, ContactScreenData.class);
    }
}
