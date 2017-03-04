
package com.castrodev.easynvest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Graph {

    @SerializedName("CDI")
    private List<Double> CDI;
    @SerializedName("fund")
    private List<Double> fund;
    @SerializedName("x")
    private List<String> x;

    public List<Double> getCDI() {
        return CDI;
    }

    public void setCDI(List<Double> CDI) {
        this.CDI = CDI;
    }

    public List<Double> getFund() {
        return fund;
    }

    public void setFund(List<Double> fund) {
        this.fund = fund;
    }

    public List<String> getX() {
        return x;
    }

    public void setX(List<String> x) {
        this.x = x;
    }

}
