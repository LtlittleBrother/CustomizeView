package com.fiction.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.commonlibrary.R;

public class CommonTitleView extends ConstraintLayout implements View.OnClickListener {

    private ImageView mLeftCloseIv;
    private TextView mCenterTitleTv;
    private TextView mRightItemTv;

    private OnMainClickListener mMainClickListener;

    public CommonTitleView(Context context) {
        super(context);
        init();
    }

    public CommonTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommonTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.common_title_view,this);
        mLeftCloseIv = findViewById(R.id.left_close_iv);
        mCenterTitleTv = findViewById(R.id.content_title);
        mRightItemTv = findViewById(R.id.right_item);
        mLeftCloseIv.setOnClickListener(this);
        mRightItemTv.setOnClickListener(this);
    }

    public void setLeftCloseIvVisibility(boolean isVisibility){
        mLeftCloseIv.setVisibility(isVisibility ? VISIBLE : GONE);
    }
    public void setLeftCloseIvImage(int res){
        mLeftCloseIv.setImageResource(res);
    }

    public void setCenterTitleText(String text){
        mCenterTitleTv.setText(text);
    }

    public void setCenterTitleTextColor(int res){
        mCenterTitleTv.setTextColor(res);
    }

    public void setRightItemText(String text){
        mRightItemTv.setText(text);
    }

    public void setRightItemTextColor(int res){
        mCenterTitleTv.setTextColor(res);
    }


    @Override
    public void onClick(View v) {
        if (v == mLeftCloseIv){
            if (mMainClickListener != null){
                mMainClickListener.onLeftClick();
            }
        }else if (v == mRightItemTv){
            if (mMainClickListener != null){
                mMainClickListener.onRightClick();
            }
        }
    }

    public void setMainClickListener(OnMainClickListener mainClickListener) {
        mMainClickListener = mainClickListener;
    }

    public interface OnMainClickListener{
        void onLeftClick();

        void onRightClick();
    }

}
