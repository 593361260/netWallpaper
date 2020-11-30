package com.mingo.baselibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BaseLayout extends FrameLayout {
    private Context mContext;
    private LayoutInflater mInflater;
    private View mLayout;

    public BaseLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    public BaseLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initLayout();
    }

    private void initLayout() {
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = mInflater.inflate(getLayoutId(), this, false);
        this.addView(mLayout);
    }

    public Context getmContext() {
        return mContext;
    }

    public abstract int getLayoutId();

}
