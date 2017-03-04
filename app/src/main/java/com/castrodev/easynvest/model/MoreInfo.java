
package com.castrodev.easynvest.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MoreInfo {

    @SerializedName("month")
    private MoreInfoDetail month;
    @SerializedName("twelvemonths")
    private MoreInfoDetail twelvemonths;
    @SerializedName("year")
    private MoreInfoDetail year;

    public MoreInfoDetail getMonth() {
        return month;
    }

    public void setMonth(MoreInfoDetail month) {
        this.month = month;
    }

    public MoreInfoDetail getTwelvemonths() {
        return twelvemonths;
    }

    public void setTwelvemonths(MoreInfoDetail twelvemonths) {
        this.twelvemonths = twelvemonths;
    }

    public MoreInfoDetail getYear() {
        return year;
    }

    public void setYear(MoreInfoDetail year) {
        this.year = year;
    }

}
