
package com.castrodev.easynvest.model;

import android.support.annotation.IntDef;

import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Retention;

import javax.annotation.Generated;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Cell {

    @Retention(SOURCE)
    @IntDef({EDIT_TEXT, TEXT_VIEW, IMAGE_VIEW, CHECK_BOX, BUTTON})
    public @interface ViewType {}
    public static final int EDIT_TEXT = 1;
    public static final int TEXT_VIEW = 2;
    public static final int IMAGE_VIEW = 3;
    public static final int CHECK_BOX = 4;
    public static final int BUTTON = 5;

    @Retention(SOURCE)
    @IntDef({DEFAULT, EMAIL, PHONE})
    public @interface InputType {}
    public static final int DEFAULT = 1;
    public static final int PHONE = 2;
    public static final int EMAIL = 3;

    @SerializedName("hidden")
    private Boolean hidden;
    @SerializedName("id")
    private Long id;
    @SerializedName("message")
    private String message;
    @SerializedName("required")
    private Boolean required;
    @SerializedName("show")
    private int show;
    @SerializedName("topSpacing")
    private Double topSpacing;
    @SerializedName("type")
    private int type;
    @SerializedName("typefield")
    private int typefield;

    public Boolean isHidden() {
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

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public Double getTopSpacing() {
        return topSpacing;
    }

    public void setTopSpacing(Double topSpacing) {
        this.topSpacing = topSpacing;
    }

    @ViewType
    public int getType() {
        return type;
    }

    public void setType(@ViewType int type) {
        this.type = type;
    }

    @InputType
    public int getTypefield() {
        return typefield;
    }

    public void setTypefield(@InputType int typefield) {
        this.typefield = typefield;
    }

}
