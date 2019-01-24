package com.fiction.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.fiction.util.ActivityStackControlUtil;
import com.fiction.util.LogTool;
import com.fiction.util.SystemBarHelper;

public abstract class BaseActivity extends AppCompatActivity {

    protected View titleView;

    /** 是否沉浸状态栏 **/
    private boolean isSetStatusBar = false;

    /**状态栏高度*/
    private int mStatusBarHeaght = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        ActivityStackControlUtil.add(this);
        mStatusBarHeaght = getStatusBarHeight(this);
        init(savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initStatusBarAndTitleBar();
    }

    private void init(Bundle savedInstanceState) {
        fetchArgsFromIntent(savedInstanceState);
        findViews();
        initUI();
        setEvent();
        initData();
        if (isSetStatusBar) {
            steepStatusBar();
        }
    }

    /**
     * 获取
     */
    protected void fetchArgsFromIntent(Bundle savedInstanceState) {
    }

    /**
     * 根据布局id或自定义View设置ContentView
     */
    private void setContentView() {
        View tmpContentView = generateContentView();
        if (null == tmpContentView) {
            int layoutResId = getLayoutResId();
            if (layoutResId > 0) {
                long start = System.currentTimeMillis();
                setContentView(layoutResId);
                Log.d("circleJump","base setContentView by Id >>"
                        + (System.currentTimeMillis() - start));
            }
        } else {
            long start = System.currentTimeMillis();
            setContentView(tmpContentView);
            Log.d("circleJump","base setContentView by dynamic View >>"
                    + (System.currentTimeMillis() - start));
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T findView(int id) {
        return (T) super.findViewById(id);
    }

    protected View generateContentView() {
        return null;
    }

    /**
     * 设置布局id
     */
    protected abstract int getLayoutResId();

    /**
     * findViewById
     */
    protected abstract void findViews();

    /**
     * 设置监听器
     */
    protected abstract void setEvent();

    /**
     * 初始化各视图
     */
    protected abstract void initUI();

    /**
     * 初始化数据
     */
    protected abstract void initData();


    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * 是否设置沉浸状态栏
     * @param isSetStatusBar
     */
    public void setSteepStatusBar(boolean isSetStatusBar,View view) {
        view.setPadding(0,mStatusBarHeaght,0,0);
        this.isSetStatusBar = isSetStatusBar;
    }


    /**开启隐藏软键盘*/
    public void setHideKeyboard(final View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }

    protected void initStatusBarAndTitleBar() {

        SystemBarHelper.setStatusBarDarkMode(this);
        SystemBarHelper.statusBarTransparent(this);
        if (titleView != null) {
            LogTool.d("initStatusBarAndTitleBar","titleview");
            SystemBarHelper.setHeightAndPadding(this, titleView);
        }
    }

    /**
     * 获取状态栏高度
     * */
    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
