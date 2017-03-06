
package com.castrodev.easynvest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Graph {

    @SerializedName("CDI")
    private List<Float> CDI;
    @SerializedName("fund")
    private List<Float> fund;
    @SerializedName("x")
    private List<String> x;

    public List<Float> getCDI() {
        return CDI;
    }

    public void setCDI(List<Float> CDI) {
        this.CDI = CDI;
    }

    public List<Float> getFund() {
        return fund;
    }

    public void setFund(List<Float> fund) {
        this.fund = fund;
    }

    public List<String> getX() {
        return x;
    }

    public void setX(List<String> x) {
        this.x = x;
    }

}
