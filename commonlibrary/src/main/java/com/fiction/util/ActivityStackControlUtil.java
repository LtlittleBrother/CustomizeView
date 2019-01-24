package com.fiction.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity栈管理工具
 */
public class ActivityStackControlUtil {
    private static Activity homePage;

    private ActivityStackControlUtil() {
    }

    private static List<Activity> activityList = new ArrayList<Activity>();

    public static void finish(Activity activity) {
        LogTool.d("ActivityStackControlUtil", "remove and finish: " + activity.getLocalClassName());
        activityList.remove(activity);
        activity.finish();
    }

    public static void remove(Activity activity) {
        LogTool.d("ActivityStackControlUtil", "remove : " + activity.getLocalClassName());
        activityList.remove(activity);
    }

    public static void add(Activity activity) {
        LogTool.d("ActivityStackControlUtil", "add : " + activity.getLocalClassName());
        activityList.add(activity);
    }

    public static void finishProgram() {
        for (Activity activity : activityList) {
            LogTool.d("ActivityStackControlUtil", "finishProgram : " + activity.getLocalClassName());
            activity.finish();
        }
        activityList.clear();
    }

    /**
     * 销毁除exclusiveActivity 之外的activities
     */
    public static void finish(Class exclusiveActivity) {
        for (Activity activity : activityList) {
            if (!activity.getClass().equals(exclusiveActivity)) {
                LogTool.d("ActivityStackControlUtil", "finishProgram : " + activity.getLocalClassName());
                activity.finish();
            }
        }
    }

    public static boolean isEmpty() {
        return activityList.isEmpty();
    }

    /**
     * 查找avtivity栈中是否有该activity
     *
     * @param exclusiveActivity
     * @return true:有，false:没有
     */
    public static boolean findActivity(Class exclusiveActivity) {
        for (Activity activity : activityList) {
            if (activity.getClass().equals(exclusiveActivity)) {
                LogTool.d("ActivityStackControlUtil", "findActivity : " + activity.getLocalClassName());
                return true;
            }
        }
        return false;
    }


    public static boolean findActivity(String exclusiveActivityName) {
        for (Activity activity : activityList) {
            if (activity.getClass().getCanonicalName().contains(exclusiveActivityName)) {
                LogTool.d("ActivityStackControlUtil", "findActivity : " + activity.getLocalClassName());
                return true;
            }
        }
        return false;
    }


    /**
     * 关闭除过最底下activity上面的所有activity
     */
    public static void finishActivityExceptTop() {
        for (int i = 0; i < activityList.size(); i++) {
            if (i != 0) {
                activityList.get(i).finish();
            }
        }
    }

    /**
     * 关闭栈顶num个Activity
     *
     * @param num
     */
    public static void finishTopActivity(int num) {
        for (int i = 0; i < num; i++) {
            activityList.get(activityList.size() - i - 1).finish();
        }
    }

    /**
     * 获取主页
     *
     * @return
     */
    public static Activity getHomePage() {
        return homePage;
    }

    /**
     * 设置主页
     *
     * @param activity
     */
    public static void setHomePage(Activity activity) {
        homePage = activity;
    }

    /**
     * 意出持有的主页的引用
     */
    public static void removeHomePage() {
        homePage = null;
    }


    /**
     * 获取栈顶的Activity
     */
    public static Activity getTopActivity() {
        return activityList.get(activityList.size() - 1);
    }
}