
package com.castrodev.easynvest.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MoreInfoDetail {

    @SerializedName("CDI")
    private Double CDI;
    @SerializedName("fund")
    private Double fund;

    public Double getCDI() {
        return CDI;
    }

    public void setCDI(Double CDI) {
        this.CDI = CDI;
    }

    public Double getFund() {
        return fund;
    }

    public void setFund(Double fund) {
        this.fund = fund;
    }

}
