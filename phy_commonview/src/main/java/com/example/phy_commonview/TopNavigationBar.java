package com.example.phy_commonview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class TopNavigationBar extends ConstraintLayout implements View.OnClickListener {
    private View view;
    private ImageView backView;
    private TextView titleTv, secondTitleTv, rightTv;
    private Context context;
    private TopNavigationBarListener listener;

    public TopNavigationBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        view = LayoutInflater.from(context).inflate(R.layout.top_navigation_bar, this, false);
        backView = view.findViewById(R.id.backView);
        titleTv = view.findViewById(R.id.titleTv);
        secondTitleTv = view.findViewById(R.id.secondTitleTv);
        rightTv = view.findViewById(R.id.rightTv);

        if (attrs != null) {
            @SuppressLint("Recycle") TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopNavigationBar);
            if (typedArray.getString(R.styleable.TopNavigationBar_title)!=null){
                titleTv.setText(typedArray.getString(R.styleable.TopNavigationBar_title));
                titleTv.setVisibility(VISIBLE);
            }
            if (typedArray.getString(R.styleable.TopNavigationBar_SecondTitle)!=null){
                secondTitleTv.setText(typedArray.getString(R.styleable.TopNavigationBar_SecondTitle));
                secondTitleTv.setVisibility(VISIBLE);
            }
            if (typedArray.getString(R.styleable.TopNavigationBar_rightTextWidget)!=null){
                rightTv.setText(typedArray.getString(R.styleable.TopNavigationBar_rightTextWidget));
                rightTv.setVisibility(VISIBLE);
            }
        }
        addView(view);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.backView) {
            this.listener.onClickBack();
        }
        if (view.getId() == R.id.rightTv) {
            this.listener.onClickRightTv();
        }
    }

    public interface TopNavigationBarListener {
        void onClickBack();

        void onClickRightTv();
    }

    public void setTopNavigationBarListener(TopNavigationBarListener topNavigationBarListener) {
        this.listener = topNavigationBarListener;
    }

    public void setTextRightTv(String text) {
        if (text != null && !text.equals("")) {
            rightTv.setVisibility(VISIBLE);
            rightTv.setText(text);
        }
    }
    public void setTextTitleTv(String title){
        if (title!=null&&!title.equals("")){
            titleTv.setVisibility(VISIBLE);
            titleTv.setText(title);
        }
    }

    public void setSecondTitle(String title){
        if (title!=null&&!title.equals("")){
            secondTitleTv.setVisibility(VISIBLE);
            secondTitleTv.setText(title);
        }
    }
}
