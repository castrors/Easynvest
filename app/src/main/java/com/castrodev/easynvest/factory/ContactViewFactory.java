package com.castrodev.easynvest.factory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.castrodev.easynvest.R;
import com.castrodev.easynvest.model.Cell;
import com.squareup.picasso.Picasso;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class ContactViewFactory {
    public static View createView(final Context context, final Cell cell, final LinearLayout rootView) {
        View view = null;
        switch (cell.getType()) {
            case Cell.EDIT_TEXT:
                TextInputLayout textInputLayout = new TextInputLayout(context);
                textInputLayout.setHint(cell.getMessage());
                textInputLayout.setLayoutParams(setLayoutDimensions());

                TextInputEditText editText = new TextInputEditText(context);
                editText.setInputType(getInputType(cell.getTypefield()));
                textInputLayout.addView(editText);
                view = setCommonAttributes(context, cell, textInputLayout);
                break;
            case Cell.TEXT_VIEW:

                TextView textView = new TextView(context);
                textView.setText(cell.getMessage());
                view = setCommonAttributes(context, cell, textView);
                break;
            case Cell.IMAGE_VIEW:

                ImageView imageView = new ImageView(context);
                view = setCommonAttributes(context, cell, imageView);
                Picasso.with(context)
                        .load(cell.getMessage())
                        .error(R.drawable.image_view_default)
                        .into((ImageView) view);
                break;
            case Cell.CHECK_BOX:

                CheckBox checkBox = new CheckBox(context);
                checkBox.setText(cell.getMessage());
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        rootView.findViewById(cell.getShow()).setVisibility(isChecked ? View.VISIBLE : View.GONE);
                    }
                });
                view = setCommonAttributes(context, cell, checkBox);
                break;
            case Cell.BUTTON:

                Button button = new Button(context);
                button.setText(cell.getMessage());
                view = setCommonAttributes(context, cell, button);
                break;
        }
        return view;
    }

    private static int getInputType(@Cell.InputType int typefield) {
        switch (typefield) {
            case Cell.DEFAULT:
                return android.text.InputType.TYPE_CLASS_TEXT;
            case Cell.EMAIL:
                return android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
            case Cell.PHONE:
                return android.text.InputType.TYPE_CLASS_PHONE;
        }
        return 0;
    }


    @NonNull
    private static View setCommonAttributes(Context context, Cell cell, View view) {
        if (view != null) {
            view.setLayoutParams(setLayoutDimensions());
            view.setVisibility(cell.isHidden() ? View.GONE : View.VISIBLE);
            final float scale = context.getResources().getDisplayMetrics().density;
            int marginLeftRight = (int) (16 * scale + 0.5f);
            int marginTop = (int) (cell.getTopSpacing() * scale + 0.5f);
            view.setPadding(marginLeftRight, marginTop, marginLeftRight, 0);
            view.setId(cell.getId().intValue());
        } else {
            view = new View(context);
        }
        return view;
    }

    @NonNull
    private static LinearLayout.LayoutParams setLayoutDimensions() {
        return new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
    }

}
