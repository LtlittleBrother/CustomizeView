package com.customizeview.view6

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.util.AttributeSet
import android.view.View
import android.view.animation.*
import android.view.animation.Interpolator
import com.customizeview.R
/**
 * 先加速再减速。这是默认的 Interpolator，也就是说如果你不设置的话，那么动画将会使用这个  Interpolator
 * */
class InterpolatorView: View {

    private var progress = 0f
    private val DURATION_MAX = 500L
    private var point = Point(100,300)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.music)
        canvas!!.drawBitmap(bitmap,progress,point.y.toFloat(),paint)
    }

    fun setProgress(progress: Float){
        this.progress = progress
        invalidate()
    }

    fun getProgress():Float{
        return progress
    }

    fun start(progress: Float,type: Int){
        val objectAnimator = ObjectAnimator.ofFloat(this,"progress",0f,progress)
        objectAnimator.interpolator = updateInterpolator(type)
        objectAnimator.duration = DURATION_MAX
        objectAnimator.start()
    }

    fun updateInterpolator(type: Int): Interpolator{
        var interpolator: Interpolator? = null
        when(type){
            0 -> interpolator = AccelerateDecelerateInterpolator()
            /**先加速再减速。这是默认的 Interpolator，也就是说如果你不设置的话，那么动画将会使用这个  Interpolator。*/
            1 -> interpolator = LinearInterpolator()
            2 -> interpolator = AccelerateInterpolator()
            3 -> interpolator = DecelerateInterpolator()
            4 -> interpolator = AnticipateInterpolator()
            5 -> interpolator = OvershootInterpolator()
            6 -> interpolator = AnticipateOvershootInterpolator()
            7 -> interpolator = BounceInterpolator()
            8 -> interpolator = CycleInterpolator(0.5f)
            9 -> {
                val path = Path()
                // 先以「动画完成度 : 时间完成度 = 1 : 1」的速度匀速运行 85%
                path.lineTo(0.85f, 0.85f)
                // 然后瞬间跳跃到 150% 的动画完成度
                path.moveTo(0.85f, 1.5f)
                // 再匀速倒车，返回到目标点
                path.lineTo(1f, 1f)
                interpolator = PathInterpolator(path)
            }
            10 -> interpolator = FastOutLinearInInterpolator()
            11 -> interpolator = FastOutSlowInInterpolator()
            12 -> interpolator = LinearOutSlowInInterpolator()
        }
        return interpolator!!
    }

}