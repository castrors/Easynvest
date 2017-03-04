package com.castrodev.easynvest.contact;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class ContactContract {

    interface View {

        void setProgressIndicator(boolean active);
        void showContactData();

    }

    interface UserActionsListener {

        void submitData();
        void sendNewMessage();

    }
}
