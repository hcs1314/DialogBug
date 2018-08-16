package com.example.hechangshou.dialogbug;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;



/**
 * Created by Sensoro on 15/8/5.
 */
public class SettingsSingleChoiceItemsFragment extends SettingsBaseDialogFragment {

    public static final String ITEMS = "ITEMS";
    public static final String ITEM = "ITEM";
    public static final String INDEX = "INDEX";

    private View dialogView;
    private TextView levelTipsTextView;
    private TextView tipsDetailTextView;

    private int selectedIndex;

    public static SettingsSingleChoiceItemsFragment newInstance(String[] items) {
        SettingsSingleChoiceItemsFragment settingsSingleChoiceItemsFragment = new SettingsSingleChoiceItemsFragment();
        Bundle args = new Bundle();
        args.putStringArray(ITEMS, items);
        settingsSingleChoiceItemsFragment.setArguments(args);
        return settingsSingleChoiceItemsFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        try {
            String[] items = getArguments().getStringArray(ITEMS);
            int index = getArguments().getInt(INDEX);
            selectedIndex = index;

                AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity())
                        .setTitle("BUG呀")
                        .setView(dialogView)
//                        .setMessage(R.string.setting_interval_tips)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Bundle bundle = new Bundle();
                                bundle.putInt(INDEX, selectedIndex);
                                bundle.putString(ITEM, getArguments().getStringArray(ITEMS)[selectedIndex]);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                builder.setSingleChoiceItems(items, index, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedIndex = which;
                    }
                });

                return builder.create();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        dialogView = inflater.inflate(R.layout.dialog_settings_tips_v4, null);
        levelTipsTextView = (TextView) dialogView.findViewById(R.id.settings_tips_v4_tv_level_tips);
        tipsDetailTextView = (TextView) dialogView.findViewById(R.id.settings_tips_v4_tv_tips_detail);
    }




}
