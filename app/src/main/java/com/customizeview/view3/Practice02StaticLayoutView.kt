package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
/**
 * Canvas.drawText() 只能绘制单行的文字，而不能换行,不能在换行符 \n 处换行
 * 如果需要绘制多行的文字，你必须自行把文字切断后分多次使用 drawText() 来绘制，或者——使用  StaticLayout 。
 *
 * StaticLayout 并不是一个 View 或者 ViewGroup ，而是 android.text.Layout 的子类，它是纯粹用来绘制文字的。
 * StaticLayout 支持换行，它既可以为文字设置宽度上限来让文字自动换行，也会在 \n 处主动换行。
 *
 * StaticLayout 的构造方法是
 * StaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad)，
 * 其中参数里：
 * width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
 * align 是文字的对齐方向；
 * spacingmult 是行间距的倍数，通常情况下填 1 就好；
 * spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
 * includepad 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
 *
 * 如果你需要进行多行文字的绘制，并且对文字的排列和样式没有太复杂的花式要求，那么使用  StaticLayout 就好。
 *
 * */
class Practice02StaticLayoutView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        val paint = Paint()
//        paint.textSize = 30f
//        val text = "我是Canvas.drawText()，只能绘制单行的文字，而不能换行，也不能在换行符处换行"
//        canvas!!.drawText(text,100f,200f,paint)

        val textPaint = TextPaint()
        textPaint.textSize = 30f
        textPaint.color = Color.RED
        val text2 = "Canvas.drawText()，只能绘制单行的文字，而不能换行,StaticLayout 并不是一个 View 或者 ViewGroup ，而是 android.text.Layout 的子类，是纯粹用来绘制文字的。" +
                "我支持换行，既可以为文字设置宽度上限来让文字自动换行，也会在换行符处主动换行"
        val staticLayout = StaticLayout(text2,textPaint,800, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)
        canvas!!.save()
        canvas.translate(50f, 100f)
        staticLayout.draw(canvas)
    }
}