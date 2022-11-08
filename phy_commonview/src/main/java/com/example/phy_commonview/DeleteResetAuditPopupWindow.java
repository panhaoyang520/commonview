package com.example.phy_commonview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class DeleteResetAuditPopupWindow<T> extends PopupWindow implements View.OnClickListener {
    private Context mContext;
    private View view;
    private int mWidth, mHeight;
    private TextView draPWDeleteTv, draPWResetTV, draPWUploadTV;
    //    private PopItemClickLicence popItemClickLicence;
    private String mTaskId;
    private T model;
    private DeleteResetAuditPopupWindowLicence<T> deleteResetAuditPopupWindow;

    public DeleteResetAuditPopupWindow(Context context, T model, View parentView) {
        mContext = context;
        this.model = model;
        mWidth = parentView.getWidth();
        mHeight = parentView.getHeight();
        init();
    }

    private void init() {
        view = LayoutInflater.from(mContext).inflate(R.layout.delete_reset_audit_popup_window, null);
        draPWDeleteTv = view.findViewById(R.id.draPWDeleteTv);
        draPWResetTV = view.findViewById(R.id.draPWResetTv);
        draPWUploadTV = view.findViewById(R.id.draPWUploadTv);
        draPWUploadTV.setOnClickListener(this);
        draPWResetTV.setOnClickListener(this);
        draPWUploadTV.setOnClickListener(this);
        this.setContentView(view);
        this.setWidth(mWidth);
        this.setHeight(mHeight);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new ColorDrawable());
        this.setFocusable(true);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.draPWDeleteTv) {
            this.deleteResetAuditPopupWindow.ItemDelete(model);
        }
        if (view.getId() == R.id.draPWResetTv) {
            this.deleteResetAuditPopupWindow.ItemDelete(model);
        }
        if (view.getId() == R.id.draPWUploadTv) {
            this.deleteResetAuditPopupWindow.ItemDelete(model);
        }
    }

    public interface DeleteResetAuditPopupWindowLicence<T> {
        void ItemDelete(T model);

        void ItemReset(T model);

        void ItemUpload(T model);
    }

    public void setDraPWDeleteTv(String text) {
        draPWDeleteTv.setText(text);
    }

    public void setDraPWDeleteTvVisibility(int visibility) {
        draPWDeleteTv.setVisibility(visibility);
    }

    public void setDraPWResetTV(String text) {
        draPWResetTV.setText(text);
    }

    public void setDraPWResetTVVisibility(int visibility) {
        draPWResetTV.setVisibility(visibility);
    }

    public void setDraPWUploadTV(String text) {
        draPWUploadTV.setText(text);
    }

    public void setDraPWUploadTVVisibility(int visibility) {
        draPWUploadTV.setVisibility(visibility);
    }

    public void setDeleteResetAuditPopupWindowLicence(DeleteResetAuditPopupWindowLicence<T> popItemClickLicence) {
        this.deleteResetAuditPopupWindow = popItemClickLicence;
    }
}
