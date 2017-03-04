
package com.castrodev.easynvest.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Cell {

    @SerializedName("hidden")
    private Boolean hidden;
    @SerializedName("id")
    private Long id;
    @SerializedName("message")
    private String message;
    @SerializedName("required")
    private Boolean required;
    @SerializedName("show")
    private Object show;
    @SerializedName("topSpacing")
    private Double topSpacing;
    @SerializedName("type")
    private Long type;
    @SerializedName("typefield")
    private Object typefield;

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Object getShow() {
        return show;
    }

    public void setShow(Object show) {
        this.show = show;
    }

    public Double getTopSpacing() {
        return topSpacing;
    }

    public void setTopSpacing(Double topSpacing) {
        this.topSpacing = topSpacing;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Object getTypefield() {
        return typefield;
    }

    public void setTypefield(Object typefield) {
        this.typefield = typefield;
    }

}
