package com.customizeview.view

interface MyRightLeftListener {

    /**
     * 手指从左往右滑动
     * */
    fun onRight()
    /**
     * 手指从下往上滑动
     */
    fun onUp()
    /**
     * 手指从右往左滑动
     */
    fun onLeft()
    /**
     * 手指从上往下滑动
     */
    fun onDown()
    /**
     * 斜画屏幕
     * */
    fun onSlide()

}