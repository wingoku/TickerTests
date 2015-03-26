package com.wingoku.tickers;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by WinGoku on 3/13/15.
 */
public class Ticker extends RelativeLayout{

    Context mContext;
    TextView mTextView, mTextView2;

    public Ticker(Context context) {
        super(context);

        mContext = context;
        init();
    }

    public Ticker(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        init();
    }

    public Ticker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        init();
    }

    private void init()
    {
        mTextView = new TextView(mContext);
        mTextView.setText("Winter is coming. Valar morghulis -- Valar dohaeris");
        mTextView.setTextColor(Color.BLACK);

        mTextView2 = new TextView(mContext);
        mTextView2.setText("Winter is coming. Valar morghulis -- Valar dohaeris");
        mTextView2.setTextColor(Color.BLACK);


        /*RelativeLayout.LayoutParams parentParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, sizeInPixel(150, getResources().getDisplayMetrics().density));
        parentParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        setLayoutParams(parentParams);

        RelativeLayout.LayoutParams textViewParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mTextView.setLayoutParams(textViewParams);
        mTextView2.setLayoutParams(textViewParams);*/

/*
        mTextView.layout(-300, 0, 100, 150);
        mTextView2.layout(350, 0, 450, 150);
*/

        addView(mTextView);
        addView(mTextView2);

/*        mTextView.setTranslationX(-500f);
        mTextView2.setTranslationX(500f);*/
        animateTextView();
    }

    private void animateTextView()
    {
        TranslateAnimation tAnim = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1, Animation.RELATIVE_TO_PARENT, 1, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0);
        tAnim.setRepeatCount(Animation.INFINITE);
        tAnim.setDuration(9000);
        tAnim.setInterpolator(new LinearInterpolator());

        mTextView.startAnimation(tAnim);

        final TranslateAnimation tAnim2 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1, Animation.RELATIVE_TO_PARENT, 1, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0);
        tAnim2.setRepeatCount(Animation.INFINITE);
        tAnim2.setDuration(9000);
        tAnim2.setInterpolator(new LinearInterpolator());

        mTextView2.startAnimation(tAnim2);
    }

    private int sizeInPixel(int dp, float dpi)
    {
        return (int)(dp * dpi);
    }

    int l,t,r,b;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //super.onLayout(changed, l, t, r, b);

        this.l = l;
        this.t = t;
        this.r = r;
        this.b = b;

/*
        this.layout(l, t, r, b);
*/

        if(mTextView != null)
            mTextView.layout(-((r/2)-500), t, (r/2), b);

        if(mTextView2 != null)
            mTextView2.layout((r/2)+100, t, r+((r/2)+100), b);
    }
}
