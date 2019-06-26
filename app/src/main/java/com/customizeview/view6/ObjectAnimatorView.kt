package com.customizeview.view6

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.animation.ObjectAnimator
import android.graphics.*
import java.text.DecimalFormat


class ObjectAnimatorView: View {

    private var point = Point(300,300)
    private var radius = 200
    private var startAngle = 0f
    private var endAngle = 65f
    private var text = ""
    private val DURATION_MAX = 10000L

    val decimalFormat = DecimalFormat("0.00")

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()

        paint.strokeWidth = 20f
        paint.style = Paint.Style.STROKE
        paint.color = Color.parseColor("#ff5548")
        canvas!!.drawArc((point.x-radius).toFloat(),(point.y-radius).toFloat(),(point.x+radius).toFloat(),(point.y+radius).toFloat(),startAngle,endAngle,false,paint)

        val textPaint = Paint()
        textPaint.textSize = 60f
        textPaint.color = Color.parseColor("#ff5548")
        canvas.drawText(text,(point.x.toFloat()-getTextWidth(text,textPaint)/2),(point.y.toFloat()+getTextHeght(text,textPaint)/2),textPaint)
        canvas.drawPoint(point.x.toFloat(),point.y.toFloat(),textPaint)

    }

    fun getEndAngle(): Float{
        return endAngle
    }

    fun setEndAngle(endAngle:Float){
        this.endAngle = endAngle
        invalidate()
    }

    fun setText(text: Float){
        val percentage = decimalFormat.format(endAngle/360*100)
        this.text = "$percentage%"
        invalidate()
    }

    fun start(pro: Float){
        /**外圆的动画效果*/
        val animator = ObjectAnimator.ofFloat(this, "endAngle", startAngle, pro)
        animator.duration = DURATION_MAX
        // 执行动画
        animator.start()

        /**文字的动画效果*/
        val animatorText = ObjectAnimator.ofFloat(this, "text", startAngle, pro)
        animatorText.duration = DURATION_MAX
        // 执行动画
        animatorText.start()
    }

    fun getTextWidth(text: String,paint: Paint): Int{
        val rect = Rect()
        paint.getTextBounds(text,0,text.length,rect)
        return rect.width()
    }

    fun getTextHeght(text: String,paint: Paint): Int{
        val rect = Rect()
        paint.getTextBounds(text,0,text.length,rect)
        return rect.height()
    }

}