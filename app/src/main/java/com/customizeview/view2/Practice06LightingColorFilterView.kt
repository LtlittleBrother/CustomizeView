package com.customizeview.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

/**
 * 使用 Paint.setColorFilter() 来设置 LightingColorFilter
 * 第一个 LightingColorFilter：去掉红色部分
 * 第二个 LightingColorFilter：增强绿色部分
 *
 * LightingColorFilter 是用来模拟简单的光照效果的。
 * 构造方法是 LightingColorFilter(int mul, int add)
 * 参数：
 * 参数里的 mul 和 add 都是和颜色值格式相同的 int 值
 * mul 用来和目标像素相乘，add 用来和目标像素相加
 *
 * R(red)红、G(green)绿、B(blue)蓝
 *
 * 具体用法：
 * 一个「保持原样」的「基本 LightingColorFilter 」，
 * mul 为 0xffffff，add 为 0x000000（也就是0），那么对于一个像素，它的计算过程就是：
 * R' = R * 0xff / 0xff + 0x0 = R // R' = R
 * G' = G * 0xff / 0xff + 0x0 = G // G' = G
 * B' = B * 0xff / 0xff + 0x0 = B // B' = B
 *
 *
 * 基于这个「基本 LightingColorFilter 」，你就可以修改一下做出其他的 filter
 * 比如，如果你想去掉原像素中的红色，可以把它的 mul 改为 0x00ffff （红色部分为 0 ）
 * ，那么它的计算过程就是：
 * R' = R * 0x0 / 0xff + 0x0 = 0 // 红色被移除
 * G' = G * 0xff / 0xff + 0x0 = G
 * B' = B * 0xff / 0xff + 0x0 = B
 * */
class Practice06LightingColorFilterView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_red)


        /**原图*/
        val lightingColorFilter = LightingColorFilter(0xffffff,0x000000)
        paint.colorFilter = lightingColorFilter
        canvas!!.drawBitmap(bitmap,0f,0f,paint)

        /**
         * 去掉红色
         * */
        val lightingColorFilterDleRed = LightingColorFilter(0x00ffff,0x000000)
        paint.colorFilter = lightingColorFilterDleRed
        canvas.drawBitmap(bitmap,300f,0f,paint)

        /**去掉绿色*/
        val lightingColorFilterDleGreen = LightingColorFilter(0xff00ff,0x000000)
        paint.colorFilter = lightingColorFilterDleGreen
        canvas.drawBitmap(bitmap,600f,0f,paint)

        /**去掉蓝色*/
        val lightingColorFilterDleBlue = LightingColorFilter(0xffff00,0x000000)
        paint.colorFilter = lightingColorFilterDleBlue
        canvas.drawBitmap(bitmap,900f,0f,paint)

        /**原图加强红色*/
        val lightingColorFilterFirmRed = LightingColorFilter(0xffffff,0x300000)
        paint.colorFilter = lightingColorFilterFirmRed
        canvas.drawBitmap(bitmap,0f,400f,paint)

        /**原图加强绿色*/
        val lightingColorFilterFirmGreen = LightingColorFilter(0xffffff,0x003000)
        paint.colorFilter = lightingColorFilterFirmGreen
        canvas.drawBitmap(bitmap,300f,400f,paint)

        /**原图加强蓝色*/
        val lightingColorFilterFirmBlue = LightingColorFilter(0xffffff,0x000030)
        paint.colorFilter = lightingColorFilterFirmBlue
        canvas.drawBitmap(bitmap,600f,400f,paint)

    }
}