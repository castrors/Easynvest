package com.castrodev.easynvest.repository.Interface;

import android.content.Context;

import com.castrodev.easynvest.model.InvestmentScreenData;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public abstract class InvestmentRespository {
    public abstract InvestmentScreenData getInvestmentScreenData(Context context);
}
