package com.example.markwang.testdraw;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopBar extends RelativeLayout {
    TypedArray typedArray;
    Context context;
    Button leftButton;
    Button rightButton;
    TextView titleView;
    AttributeSet attrs;
    LayoutParams leftLayoutParams;
    LayoutParams rightLayoutParams;
    LayoutParams titleLayoutParams;

    int leftTextColor;
    Drawable leftBackground;
    String leftText;

    int rightTextColor;
    Drawable rightBackground;
    String rightText;

    float titleTextSize;
    int titleTextColor;
    String titleName;

    public TopBar(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }


    public void init(Context context) {
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        leftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        leftText = typedArray.getString(R.styleable.TopBar_leftText);

        rightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        rightText = typedArray.getString(R.styleable.TopBar_rightText);

        titleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 10);
        titleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);
        titleName = typedArray.getString(R.styleable.TopBar_titleName);

        typedArray.recycle();

        leftButton = new Button(context);
        rightButton = new Button(context);
        titleView = new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        titleView.setText(titleName);
        titleView.setTextColor(titleTextColor);
        titleView.setTextSize(titleTextSize);

        leftLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        this.addView(leftButton, leftLayoutParams);

        rightLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        this.addView(rightButton, rightLayoutParams);

        titleLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        this.addView(titleView, titleLayoutParams);

        rightButton.setVisibility(View.VISIBLE);
        rightButton.setVisibility(View.GONE);
    }


}
