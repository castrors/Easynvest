package com.castrodev.easynvest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by rodrigocastro on 05/03/17.
 */

public class SuccessActivity extends AppCompatActivity {

    public static final String SEND_NEW_MESSAGE = "send_new_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.text_send_new_message)
    public void sendNewMessage(View view){
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        intent.putExtra(SEND_NEW_MESSAGE, true);
        startActivity(intent);
    }
}
