package com.customizeview.view6

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.Animation
import com.customizeview.R
import com.fiction.util.LogTool

class ViewPropertyAnimatorView: View {
    private val TAG = "ViewPropertyAnimatorView"
    private var point = Point(100,200)

    private var transX = 0f

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.music)
        canvas!!.drawBitmap(bitmap,point.x.toFloat(),point.y.toFloat(),paint)
        animate().translationX(transX)
        animate().setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                /**当动画通过 setRepeatMode() / setRepeatCount() 或 repeat() 方法重复执行时，这个方法被调用。
                 * 由于 ViewPropertyAnimator 不支持重复，所以这个方法对 ViewPropertyAnimator 相当于无效。*/
                LogTool.D(TAG,"onAnimationRepeat被调用")
            }

            override fun onAnimationEnd(animation: Animator?) {
                /**当动画结束时，这个方法被调用。*/
                LogTool.D(TAG,"onAnimationEnd被调用")
            }

            override fun onAnimationCancel(animation: Animator?) {
                /**
                 * 当动画被通过 cancel() 方法取消时，这个方法被调用。
                 * 需要说明一下的是，就算动画被取消，onAnimationEnd() 也会被调用。
                 * 所以当动画被取消时，如果设置了  AnimatorListener，那么 onAnimationCancel() 和 onAnimationEnd() 都会被调用。
                 * onAnimationCancel() 会先于 onAnimationEnd() 被调用。
                 * */
                LogTool.D(TAG,"onAnimationCancel被调用")
            }

            override fun onAnimationStart(animation: Animator?) {
                /**当动画开始执行时，这个方法被调用*/
                LogTool.D(TAG,"onAnimationStart被调用")
            }
        })
    }

    fun setTranX(x: Float){
        this.transX = x
        invalidate()
    }

    fun reset(){
        transX = 0f
        invalidate()
    }

}