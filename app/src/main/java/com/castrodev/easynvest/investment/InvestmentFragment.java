package com.castrodev.easynvest.investment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.castrodev.easynvest.R;
import com.castrodev.easynvest.model.Info;
import com.castrodev.easynvest.model.InvestmentScreenData;
import com.castrodev.easynvest.model.MoreInfo;
import com.castrodev.easynvest.model.MoreInfoDetail;
import com.castrodev.easynvest.model.Screen;
import com.castrodev.easynvest.repository.Repository;

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


    private InvestmentContract.UserActionsListener mActionListener;

    public static InvestmentFragment newInstance() {
        return new InvestmentFragment();
    }

    public InvestmentFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionListener = new InvestmentPresenter(this);
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

    }

    @Override
    public void showInvestentData() {

    }
}
