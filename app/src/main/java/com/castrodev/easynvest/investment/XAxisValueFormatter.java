package com.castrodev.easynvest.investment;


import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.List;

/**
 * Created by rodrigocastro on 05/03/17.
 */

class XAxisValueFormatter implements IAxisValueFormatter {


    private final List<String> labels;

    public XAxisValueFormatter(List<String> labels) {
        this.labels = labels;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        switch ((int) value) {
            case 0:
                return labels.get(0);
            case 3:
                return labels.get(1);
            case 6:
                return labels.get(2);

        }
        return "";
    }
}
