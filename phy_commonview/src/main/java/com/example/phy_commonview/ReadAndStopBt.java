package com.example.phy_commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ReadAndStopBt extends ConstraintLayout implements View.OnClickListener {
    private View view;
    private TextView startRFID, stopRFID, reset, powerSet;
    private ConstraintLayout RFIDingCl;
    private ReadAndStopListener readAndStopListener;
    public ReadAndStopBt(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        view = LayoutInflater.from(context).inflate(R.layout.read_and_stop, this, false);
        startRFID = view.findViewById(R.id.startRFID);
        stopRFID = view.findViewById(R.id.stopRFID);
        reset = view.findViewById(R.id.reset);
        powerSet = view.findViewById(R.id.powerSet);
        RFIDingCl = view.findViewById(R.id.RFIDingCl);
        startRFID.setOnClickListener(this);
        stopRFID.setOnClickListener(this);
        powerSet.setOnClickListener(this);
        powerSet.setOnClickListener(this);
        addView(view);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.startRFID) {
            readAndStopListener.onOnClickStartRFID();
            RFIDingCl.setVisibility(View.GONE);
        } else if (id == R.id.stopRFID) {
            readAndStopListener.onOnClickStopRFID();
            RFIDingCl.setVisibility(View.VISIBLE);
        } else if (id==R.id.reset){
            readAndStopListener.onClickReset();
        } else if (id==R.id.powerSet){
            readAndStopListener.powerSet();
        }
    }

    private interface ReadAndStopListener{
        void onClickReset();
        void onOnClickStartRFID();
        void onOnClickStopRFID();
        void powerSet();
    }

    public void setReadAndStopListener(ReadAndStopListener listener){
        readAndStopListener = listener;
    }

    public void setPowerSet(String text){
        this.powerSet.setText(text);
    }
}
