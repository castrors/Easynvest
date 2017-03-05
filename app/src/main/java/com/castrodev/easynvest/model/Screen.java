
package com.castrodev.easynvest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Screen {

    @SerializedName("definition")
    private String definition;
    @SerializedName("downInfo")
    private List<Info> downInfo;
    @SerializedName("fundName")
    private String fundName;
    @SerializedName("graph")
    private Graph graph;
    @SerializedName("info")
    private List<Info> fnfo;
    @SerializedName("infoTitle")
    private String infoTitle;
    @SerializedName("moreInfo")
    private MoreInfo moreInfo;
    @SerializedName("risk")
    private Long risk;
    @SerializedName("riskTitle")
    private String riskTitle;
    @SerializedName("title")
    private String title;
    @SerializedName("whatIs")
    private String whatIs;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<Info> getDownInfo() {
        return downInfo;
    }

    public void setDownInfo(List<Info> downInfo) {
        this.downInfo = downInfo;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public List<Info> getInfo() {
        return fnfo;
    }

    public void setInfo(List<Info> info) {
        fnfo = info;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public MoreInfo getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(MoreInfo moreInfo) {
        this.moreInfo = moreInfo;
    }

    public Long getRisk() {
        return risk;
    }

    public void setRisk(Long risk) {
        this.risk = risk;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public void setRiskTitle(String riskTitle) {
        this.riskTitle = riskTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }

}
