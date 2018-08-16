package com.example.hechangshou.dialogbug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SettingsSingleChoiceItemsFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String[] items = new String[16];
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 16; i++) {
            items[i]="选项："+i;
        }
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFragment = SettingsSingleChoiceItemsFragment.newInstance(items);
                dialogFragment.show(getFragmentManager(), "bug");
            }
        });

    }
}
