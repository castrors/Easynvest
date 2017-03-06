package com.castrodev.easynvest.investment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.castrodev.easynvest.R;
import com.castrodev.easynvest.model.Graph;
import com.castrodev.easynvest.model.Info;
import com.castrodev.easynvest.model.InvestmentScreenData;
import com.castrodev.easynvest.model.MoreInfo;
import com.castrodev.easynvest.model.MoreInfoDetail;
import com.castrodev.easynvest.model.Screen;
import com.castrodev.easynvest.repository.Repository;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class InvestmentFragment extends Fragment implements InvestmentContract.View {

    public static final String PERCENTAGE_FORMAT = "%s%%";
    @BindView(R.id.investment_title)
    TextView textViewInvestmentTitle;
    @BindView(R.id.investment_subtitle)
    TextView textViewInvestmentSubtitle;
    @BindView(R.id.investment_what_is_title)
    TextView textViewWhatIsTitle;
    @BindView(R.id.investment_what_is_value)
    TextView textViewWhatIsValue;
    @BindView(R.id.investment_risk_title)
    TextView textViewInvestmentRiskTitle;
    @BindView(R.id.investment_info_risk_title)
    TextView textViewInvestmentInfoRiskTitle;
    @BindView(R.id.monthly_fund_value)
    TextView textViewMonthlyFund;
    @BindView(R.id.monthly_cdi_value)
    TextView textViewMonthlyCDI;
    @BindView(R.id.yearly_fund_value)
    TextView textViewYearlyFund;
    @BindView(R.id.yearly_cdi_value)
    TextView textViewYearlyCDI;
    @BindView(R.id.twelve_months_fund_value)
    TextView textViewTwelveMonthsFund;
    @BindView(R.id.twelve_months_cdi_value)
    TextView textViewTwelveMonthsCDI;
    @BindView(R.id.root_view_info)
    LinearLayout rootViewInfo;

    @BindView(R.id.radio_group_risk)
    RadioGroup radioGroupRisk;
    @BindView(R.id.radio_risk_level_1)
    RadioButton radioRiskLevel1;
    @BindView(R.id.radio_risk_level_2)
    RadioButton radioRiskLevel2;
    @BindView(R.id.radio_risk_level_3)
    RadioButton radioRiskLevel3;
    @BindView(R.id.radio_risk_level_4)
    RadioButton radioRiskLevel4;
    @BindView(R.id.radio_risk_level_5)
    RadioButton radioRiskLevel5;

    @BindView(R.id.investment_graph)
    LineChart mChart;


    private InvestmentContract.UserActionsListener userActionsListener;

    public static InvestmentFragment newInstance() {
        return new InvestmentFragment();
    }

    public InvestmentFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userActionsListener = new InvestmentPresenter(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_investment, container, false);
        ButterKnife.bind(this, root);
        setupView();

        return root;
    }

    private void setupView() {

        InvestmentScreenData investmentScreenData = Repository.providesInvestmentRepository().getInvestmentScreenData(getContext());

        Screen screen = investmentScreenData.getScreen();

        textViewInvestmentTitle.setText(screen.getTitle());
        textViewInvestmentSubtitle.setText(screen.getFundName());
        textViewWhatIsTitle.setText(screen.getWhatIs());
        textViewWhatIsValue.setText(screen.getDefinition());
        textViewInvestmentRiskTitle.setText(screen.getRiskTitle());
        textViewInvestmentInfoRiskTitle.setText(screen.getInfoTitle());

        setupChart(screen.getGraph(), screen.getFundName());

        MoreInfo moreInfo = screen.getMoreInfo();

        MoreInfoDetail month = moreInfo.getMonth();
        textViewMonthlyFund.setText(String.format(PERCENTAGE_FORMAT, month.getFund().toString()));
        textViewMonthlyCDI.setText(String.format(PERCENTAGE_FORMAT, month.getCDI().toString()));

        MoreInfoDetail year = moreInfo.getYear();
        textViewYearlyFund.setText(String.format(PERCENTAGE_FORMAT, year.getFund().toString()));
        textViewYearlyCDI.setText(String.format(PERCENTAGE_FORMAT, year.getCDI().toString()));

        MoreInfoDetail twelvemonths = moreInfo.getTwelvemonths();
        textViewTwelveMonthsFund.setText(String.format(PERCENTAGE_FORMAT, twelvemonths.getFund().toString()));
        textViewTwelveMonthsCDI.setText(String.format(PERCENTAGE_FORMAT, twelvemonths.getCDI().toString()));


        radioGroupRisk.check(findViewToSetSelected(screen.getRisk().intValue()));

        List<Info> infoList = screen.getInfo();
        for (Info info : infoList) {

            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_investment_info, null);
            TextView textViewInvestmentInfoTitle = ButterKnife.findById(view, R.id.investment_info_title);
            TextView textViewInvestmentInfoValue = ButterKnife.findById(view, R.id.investment_info_value);
            textViewInvestmentInfoTitle.setText(info.getName());
            textViewInvestmentInfoValue.setText(info.getData());
            view.setPadding(0, 24, 0, 0);

            rootViewInfo.addView(view);
        }

        List<Info> downInfoList = screen.getDownInfo();
        for (final Info downInfo : downInfoList) {

            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_investment_download_info, null);
            TextView textViewInvestmentInfoDownloadTitle = ButterKnife.findById(view, R.id.investment_info_download_title);
            TextView textViewInvestmentInfoDownloadData = ButterKnife.findById(view, R.id.investment_info_download_data);
            textViewInvestmentInfoDownloadTitle.setText(downInfo.getName());
            textViewInvestmentInfoDownloadData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Baixando " + downInfo.getName() + " data:  " + downInfo.getData(), Toast.LENGTH_SHORT).show();
                }
            });
            view.setPadding(0, 24, 0, 0);

            rootViewInfo.addView(view);
        }


    }

    private void setupChart(Graph graph, String fundName) {

        mChart.getDescription().setEnabled(false);

        mChart.setTouchEnabled(true);

        XAxis xAxis = mChart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMaximum(10f);
        xAxis.setCenterAxisLabels(true);
        xAxis.setAxisMinimum(0f);
        xAxis.setLabelCount(3);
        xAxis.setValueFormatter(new XAxisValueFormatter(graph.getX()));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.setAxisMaximum(40f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);

        leftAxis.setDrawLimitLinesBehindData(true);

        mChart.getAxisRight().setEnabled(false);

        setData(graph, fundName);

        mChart.animateX(2500);

        Legend l = mChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);

    }

    private void setData(Graph graph, String fundName) {

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        List<Float> cdi = graph.getCDI();
        for (int i = 0; i < cdi.size(); i++) {
            yVals1.add(new Entry(i, cdi.get(i)));
        }

        ArrayList<Entry> yVals2 = new ArrayList<Entry>();

        List<Float> fund = graph.getFund();
        for (int i = 0; i < fund.size(); i++) {
            yVals2.add(new Entry(i, fund.get(i)));
        }

        LineDataSet set1, set2;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set2 = (LineDataSet) mChart.getData().getDataSetByIndex(1);
            set1.setValues(yVals1);
            set2.setValues(yVals2);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(yVals1, "CDI");

            set1.setAxisDependency(YAxis.AxisDependency.RIGHT);
            int cdiColor = ContextCompat.getColor(getContext(), R.color.graph_cdi);
            set1.setColor(cdiColor);
            set1.setCircleColor(cdiColor);
            set1.setLineWidth(2f);
            set1.setCircleRadius(3f);
            set1.setFillAlpha(65);
            set1.setFillColor(cdiColor);
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setDrawCircleHole(false);
            set1.setDrawValues(false);

            set2 = new LineDataSet(yVals2, fundName);
            set2.setAxisDependency(YAxis.AxisDependency.RIGHT);
            int fundColor = ContextCompat.getColor(getContext(), R.color.graph_fund);
            set2.setColor(fundColor);
            set2.setCircleColor(fundColor);
            set2.setLineWidth(2f);
            set2.setCircleRadius(3f);
            set2.setFillAlpha(65);
            set2.setFillColor(fundColor);
            set2.setDrawCircleHole(false);
            set2.setHighLightColor(Color.rgb(244, 117, 117));
            set2.setDrawValues(false);

            LineData data = new LineData(set1, set2);

            mChart.setData(data);
        }

    }

    private int findViewToSetSelected(int tag) {
        switch (tag) {
            case 1:
                return radioRiskLevel1.getId();
            case 2:
                return radioRiskLevel2.getId();
            case 3:
                return radioRiskLevel3.getId();
            case 4:
                return radioRiskLevel4.getId();
            case 5:
                return radioRiskLevel5.getId();
        }
        return -1;
    }

    @Override
    public void setProgressIndicator(boolean active) {
        //TODO handle request from API
    }

    @Override
    public void showInvestentData() {
        //TODO handle result from from API

    }
}
