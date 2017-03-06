package com.castrodev.easynvest.contact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.castrodev.easynvest.R;
import com.castrodev.easynvest.factory.ContactViewFactory;
import com.castrodev.easynvest.model.Cell;
import com.castrodev.easynvest.model.ContactScreenData;
import com.castrodev.easynvest.repository.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class ContactFragment extends Fragment implements ContactContract.View {

    @BindView(R.id.root_view_contact)
    LinearLayout rootViewContact;

    private ContactContract.UserActionsListener userActionListener;

    private View.OnClickListener submitClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            userActionListener.submitData();
        }
    };

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    public ContactFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userActionListener = new ContactPresenter(getContext(), this);
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

        ContactScreenData contactScreenData = Repository.providesContactRepository().getContactScreenData(getContext());

        for (Cell cell : contactScreenData.getCells()) {
            rootViewContact.addView(ContactViewFactory.createView(getContext(), cell, rootViewContact, submitClickListener));
        }

        final float scale = getResources().getDisplayMetrics().density;
        int margin = (int) (16 * scale + 0.5f);
        rootViewContact.setPadding(margin, margin, margin, margin);
    }

    @Override
    public void setProgressIndicator(boolean active) {

    }

    @Override
    public void showContactData() {

    }
}
