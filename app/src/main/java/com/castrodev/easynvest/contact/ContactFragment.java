package com.castrodev.easynvest.contact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castrodev.easynvest.R;

import butterknife.ButterKnife;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class ContactFragment extends Fragment implements ContactContract.View {

    private ContactContract.UserActionsListener mActionListener;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    public ContactFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionListener = new ContactPresenter(this);
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
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, root);
        setupView();

        return root;
    }

    private void setupView() {
    }

    @Override
    public void setProgressIndicator(boolean active) {

    }

    @Override
    public void showContactData() {

    }
}
