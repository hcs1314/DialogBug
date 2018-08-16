package com.example.hechangshou.dialogbug;

import android.app.Activity;
import android.app.DialogFragment;


/**
 * Created by Sensoro on 15/8/5.
 */
public class SettingsBaseDialogFragment extends DialogFragment {
//    OnPositiveButtonClickListener onPositiveButtonClickListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
//            onPositiveButtonClickListener = (OnPositiveButtonClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnPositiveButtonClickListener");
        }
    }
}
