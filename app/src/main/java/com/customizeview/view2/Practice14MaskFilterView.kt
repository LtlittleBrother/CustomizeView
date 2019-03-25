package com.customizeview.view2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R
import android.graphics.EmbossMaskFilter



/**
 * setMaskFilter(MaskFilter maskfilter)
 * 为之后的绘制设置 MaskFilter。上一个方法 setShadowLayer() 是设置的在绘制层下方的附加效果；而这个 MaskFilter 和它相反，设置的是在绘制层上方的附加效果。
 * MaskFilter 有两种：
 * BlurMaskFilter ：
 * 模糊效果的 MaskFilter
 * 它的构造方法 BlurMaskFilter(float radius, BlurMaskFilter.Blur style) 中， radius 参数是模糊的范围， style 是模糊的类型。一共有四种：
 * NORMAL: 内外都模糊绘制
 * SOLID: 内部正常绘制，外部模糊
 * INNER: 内部模糊，外部不绘制
 * OUTER: 内部不绘制，外部模糊（什么鬼？）
 *
 *
 * EmbossMaskFilter ：
 * 浮雕效果的 MaskFilter
 * 它的构造方法  EmbossMaskFilter(float[] direction, float ambient, float specular, float blurRadius) 的参数里，
 * direction 是一个 3 个元素的数组，指定了光源的方向；
 * ambient 是环境光的强度，数值范围是 0 到 1；
 * specular 是炫光的系数；
 * blurRadius 是应用光线的范围。
 * */

class Practice14MaskFilterView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_red)
        paint.maskFilter = BlurMaskFilter(50f,BlurMaskFilter.Blur.NORMAL)
        canvas!!.drawBitmap(bitmap,100f,100f,paint)

        paint.maskFilter = EmbossMaskFilter(floatArrayOf(0f, 3f, 3f), 0.8f, 8f, 10f)
        canvas.drawBitmap(bitmap,400f,100f,paint)
    }
}