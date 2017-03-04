package com.castrodev.easynvest.repository;

import com.castrodev.easynvest.repository.Implementation.ContactRespositoryImpl;
import com.castrodev.easynvest.repository.Implementation.InvestmentRespositoryImpl;
import com.castrodev.easynvest.repository.Interface.ContactRepository;
import com.castrodev.easynvest.repository.Interface.InvestmentRespository;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public abstract class Repository {

    private static InvestmentRespository investmentRespository;
    private static ContactRepository contactRepository;

    public static InvestmentRespository providesInvestmentRepository() {
        if (investmentRespository == null)
            investmentRespository = new InvestmentRespositoryImpl();
        return investmentRespository;
    }

    public static ContactRepository providesContactRepository() {
        if (contactRepository == null)
            contactRepository = new ContactRespositoryImpl();
        return contactRepository;
    }
}
