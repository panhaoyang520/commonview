package com.lead.trolley.phy_common_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phy_commonview.DeleteResetAuditPopupWindow;

import cat.customize.dialog.CtToastDialog;

public class MainActivity extends AppCompatActivity {

    private CtToastDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.aaa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteResetAuditPopupWindow<String> deleteResetAuditPopupWindow = new DeleteResetAuditPopupWindow<>(getApplicationContext(), "aa", v);
                deleteResetAuditPopupWindow.showAsDropDown(v,0,-v.getHeight());
            }
        });
    }
}