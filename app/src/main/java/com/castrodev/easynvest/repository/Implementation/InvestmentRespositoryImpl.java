package com.castrodev.easynvest.repository.Implementation;

import android.content.Context;

import com.castrodev.easynvest.R;
import com.castrodev.easynvest.model.InvestmentScreenData;
import com.castrodev.easynvest.repository.Interface.InvestmentRespository;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class InvestmentRespositoryImpl extends InvestmentRespository {
    @Override
    public InvestmentScreenData getInvestmentScreenData(Context context) {

        InputStream inputStream = context.getResources().openRawResource(R.raw.fund);
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));

        Gson gson = new Gson();
        return gson.fromJson(reader, InvestmentScreenData.class);
    }
}
