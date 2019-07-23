package util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.commonlibrary.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wuning on 2016-09-13 11:09.
 */
public class ViewUtil {

    private static int statusBarHeight = -1;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);


    /**
     * 测量这个view，最后通过getMeasuredWidth()获取宽度和高度.
     *
     * @param v 要测量的view
     * @return 测量过的view
     */
    public static void measureView(View v) {
        if (v == null) {
            return;
        }
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        v.measure(w, h);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 描述：根据分辨率获得字体大小.
     *
     * @param screenWidth  the screen width
     * @param screenHeight the screen height
     * @param textSize     the text size
     * @return the int
     */
    public static int resizeTextSize(int screenWidth, int screenHeight, int textSize) {
        float ratio = 1;
        try {
            float ratioWidth = (float) screenWidth / 480;
            float ratioHeight = (float) screenHeight / 800;
            ratio = Math.min(ratioWidth, ratioHeight);
        } catch (Exception e) {
        }
        return Math.round(textSize * ratio);
    }

    /**
     * 描述：dip转换为px
     *
     * @param context
     */
    public static int dip2px(Context context, float dip) {
        if(context == null){
            return 0;
        }
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, context.getResources().getDisplayMetrics()));
    }

    /**
     * 描述：px转换为dip
     *
     * @param context
     * @param px
     * @return
     * @throws
     */
    public static int px2dip(Context context, float px) {
         final float scale = context.getResources().getDisplayMetrics().density;
         return (int) (px / scale + 0.5f);
    }

    /**
     * 打开键盘
     */
    public static void showSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        //imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    /**
     * 关闭键盘
     */
    public static void hideSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
    }

    /**
     * EditText获取焦点并显示软键盘
     */
    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    public static void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    /**
     * 获取底部导航栏高度
     *
     * @param mCtx
     * @return
     */
    public static int getNavigationBarHeight(Context mCtx) {
        int height = 0;
        try {
            Resources resources = mCtx.getResources();
            int resourceId = resources.getIdentifier("navigation_bar_height",
                    "dimen", "android");
            // 获取NavigationBar的高度
            height = resources.getDimensionPixelSize(resourceId);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        return height;
    }

    /**
     * 获取状态栏高度
     *
     * @param mCtx
     * @return
     */
    public static int getStatusBarHeight(Context mCtx) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = mCtx.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return sbar;
    }


    /**判断系统是否有Navigation Bar */
    public static boolean hasNavBar(Resources resources) {
        int id = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            return resources.getBoolean(id);
        }
        return false;
    }

    public static boolean hasNavigationBar(Context activity) {

        //通过判断设备是否有返回键、菜单键(不是虚拟键,是手机屏幕外的按键)来确定是否有navigation bar
        boolean hasMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);

        return !hasMenuKey && !hasBackKey;
    }

    /**
     * Generate a value suitable for use in {@link #setId(int)}.
     * This value will not collide with ID values generated at build time by aapt for R.id.
     *
     * @return a generated ID value
     */
    public static int generateViewId() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            for (;;) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    return result;
                }
            }
        } else {
            return View.generateViewId();
        }
    }

    /**视图转化成图像数据
     * @param size 目标图像大小，width-size[0],height-size[1]
     * */
    public static Bitmap viewToBitmap(View v, int []size) {
        Bitmap newb = Bitmap.createBitmap(size[0], size[1], Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(newb);
        v.draw(canvas);
        return newb;
    }

    /**
     * 设置tabLayout 宽度跟字体宽度一样宽
     * @param tabLayout tabLayout
     */
    public static void setTabLayoutWith(final TabLayout tabLayout) {
        if (tabLayout == null || tabLayout.getChildCount() < 1) {
            return;
        }
        //线的宽度是根据 tabView的宽度来设置的
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout tabStrip = (LinearLayout) tabLayout.getChildAt(0);
                    if (tabStrip == null) {
                        return;
                    }

                    int dp10 = dip2px(tabLayout.getContext(), 10);

                    for (int i = 0; i < tabStrip.getChildCount(); i++) {
                        View tabView = tabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field textViewField = tabView.getClass().getDeclaredField("mTextView");
                        textViewField.setAccessible(true);

                        TextView textView = (TextView) textViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = textView.getWidth();
                        if (width == 0) {
                            textView.measure(0, 0);
                            width = textView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width;
                        params.leftMargin = dp10;
                        params.rightMargin = dp10;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public static void setTabLayoutWith(final TabLayout tabLayout, final float paddingDp) {
        if (tabLayout == null || tabLayout.getChildCount() < 1) {
            return;
        }
        //线的宽度是根据 tabView的宽度来设置的
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout tabStrip = (LinearLayout) tabLayout.getChildAt(0);
                    if (tabStrip == null) {
                        return;
                    }
                    int dp = dip2px(tabLayout.getContext(), paddingDp);
                    int count = tabStrip.getChildCount();
                    for (int i = 0; i < count; i++) {
                        View tabView = tabStrip.getChildAt(i);
                        if (tabView == null) {
                            return;
                        }

                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field textViewField = tabView.getClass().getDeclaredField("mTextView");
                        if (textViewField == null) {
                            return;
                        }
                        textViewField.setAccessible(true);

                        TextView textView = (TextView) textViewField.get(tabView);
                        if (textView == null) {
                            return;
                        }

                        tabView.setPadding(0, 0, 0, 0);

                        //字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = textView.getWidth();
                        if (width == 0) {
                            textView.measure(0, 0);
                            width = textView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width;
                        params.leftMargin = dp;
                        params.rightMargin = dp;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }


//    /**
//     * 改变recyclerView scrollbars颜色
//     */
//    public static void tintScrollbarColor(Context context, RecyclerView recyclerView) {
//        try {
//            //通过反射一层层的获取对象，直到获取到进度条
//            Class<View> clazz = View.class;
//            Method method = clazz.getDeclaredMethod("getScrollCache");
//            method.setAccessible(true);
//            Object scrollabilityCacheObj = method.invoke(recyclerView);
//            Class<?> scrollabilityCacheClazz = scrollabilityCacheObj.getClass();
//            Field scrollBarField = scrollabilityCacheClazz.getField("scrollBar");
//
//            Object scrollbarObj = scrollBarField.get(scrollabilityCacheObj);
//            Class<?> scrollbarClass = scrollbarObj.getClass();
//
//            Field verticalThumbField = scrollbarClass.getDeclaredField("mVerticalThumb");
//            Field horizontalThumbField = scrollbarClass.getDeclaredField("mHorizontalThumb");
//            verticalThumbField.setAccessible(true);
//            horizontalThumbField.setAccessible(true);
//            Drawable verticalThumb = (Drawable) verticalThumbField.get(scrollbarObj);
//            Drawable horizontalThumb = (Drawable) horizontalThumbField.get(scrollbarObj);
//            //对显示的drawable着色
//            Drawable verticalThumbTint = context.getResources().getDrawable(R.drawable.dianyou_common_scrollbar_bg);
//            Drawable horizontalThumbTint = context.getResources().getDrawable(R.drawable.dianyou_common_scrollbar_bg);
//            //设置新的drawable
//            verticalThumbField.set(scrollbarObj, verticalThumbTint);
//            horizontalThumbField.set(scrollbarObj, horizontalThumbTint);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
