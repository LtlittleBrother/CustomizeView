package com.fiction.util;

public interface DYPostListener<T> {
    void onSuccess(T t);

    /**
     * @param alert
     *            是否需要进行提示（有些错误已经统一处理掉了alert 会为false，未处理的alert就会为true）
     */
    void onFailure(Throwable t, int errorNo, String strMsg, boolean alert);
}
