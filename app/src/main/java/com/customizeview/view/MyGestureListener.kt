package com.customizeview.view

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent

class MyGestureListener(listener: MyRightLeftListener) : GestureDetector.OnGestureListener {



    private var listener: MyRightLeftListener? = null
    // 垂直方向移动的距离，绝对值
    private val distanceY: Float = 0.toFloat()
    // 水平方向移动的距离，绝对值
    private val distanceX: Float = 0.toFloat()
    // 移动距离大于下面的值时，才触发滑动屏幕的监听
    private val distance = 100f

    init {
        this.listener = listener
    }

    /**
     * 点击了触摸屏，但是没有移动和弹起的动作onShowPress和onDown的区别在于 onDown是，
     * 一旦触摸屏按下，就马上产生onDown事件，但是onShowPress是onDown事件产生后，
     * 一段时间内，如果没有移动鼠标和弹起事件，就认为是onShowPress事件。
     */
    override fun onShowPress(e: MotionEvent?) {

    }
    /**
     * 轻击触摸屏后，弹起。如果这个过程中产onLongPress、onScroll和onFling事件， 就不会 产生onSingleTapUp事件。
     */
    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    /**
     * 一旦触摸屏按下，就马上产生onDown事件
     */
    override fun onDown(e: MotionEvent?): Boolean {
        return false
    }
    /**
     * 当手在屏幕上滑动但手离开屏幕时触发
     */
    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {

        // 按下时的x坐标
        val startX = e1!!.x
        // 按下时的y坐标
        val startY = e1.y
        // 抬起时的x坐标
        val endtX = e2!!.x
        // 抬起时的y坐标
        val endtY = e2.y
        /**水平方向移动的绝对值*/
        val distanceX = endtX - startX
        /**垂直方向移动的绝对值*/
        val distanceY = endtY - startY
        Log.d("liutao","startX==$startX\nstartY==$startY\nendtX==$endtX\nendtY==$endtY\n" +
                "distanceX==$distanceX\ndistanceY==$distanceY")
//        if ()

        return false
    }
    /**
     * 当手在屏幕上滑动过程中触发，参数跟onFling一样（注意两者的区别）
     */
    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return false
    }
    /**
     * 长按屏幕时触发
     */
    override fun onLongPress(e: MotionEvent?) {

    }


}