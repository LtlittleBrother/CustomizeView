package com.fiction.util;

import android.util.Log;

import java.io.File;

/***/
public class LogTool {
    public static String TAG = "DY";
    public static boolean isDebug = true;

    static{
        isDebug = new File("/data/local/tmp/.dydebug").exists();
    }

//    public static void setDebugEnable(boolean isDebug) {
//        LogTool.isDebug = isDebug;
//    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(TAG, tag + ">>" + msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(TAG, tag + ">>" + msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(TAG, tag + ">>" + msg);
        }
    }

    public static void D(String msgFormat, Object... args) {
        if (isDebug) {
            Log.d(TAG, String.format(msgFormat, args));
        }
    }

    public static void L(String tag, String msg) {
        if (isDebug) {
            Log.d(TAG, tag + ">>" + msg);
        }
    }

    public static void E(String tag, String msg, Throwable throwable){
        if(isDebug){
            Log.e(TAG,tag + ">>" + msg,throwable);
        }
    }


    public static void e(String tag, Throwable e) {
        if (isDebug) {
            Log.e(TAG, tag + ">>" + (e == null ? "" :e.getMessage()),e);
        }
    }
}
