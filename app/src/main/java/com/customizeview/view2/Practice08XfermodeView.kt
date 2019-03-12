package com.customizeview.view2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

class Practice08XfermodeView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.dianyou_cash)
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.dianyou_red)
        val xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN) /**更改模式以看更多的效果*/

        canvas!!.drawBitmap(bitmap1,0f,0f,paint) // 画方
        paint.xfermode = xfermode // 设置 Xfermode
        canvas.drawBitmap(bitmap2,50f,100f,paint)// 画圆
        paint.xfermode = null// 用完及时清除 Xfermode

        /**离屏缓冲*/

        /**
         * Canvas.saveLayer()    更高的性能
         * */
        val saved = canvas.saveLayer(null,null,Canvas.ALL_SAVE_FLAG)
        canvas.drawBitmap(bitmap1,500f,0f,paint) // 画方
        paint.xfermode = xfermode // 设置 Xfermode
        canvas.drawBitmap(bitmap2,550f,100f,paint)// 画圆
        paint.xfermode = null// 用完及时清除 Xfermode
        canvas.restoreToCount(saved)

        /**
         * View.setLayerType()   相对Canvas.saveLayer()比较损耗性能
         * 是直接把整个 View 都绘制在离屏缓冲中。
         * setLayerType(LAYER_TYPE_HARDWARE) 是使用 GPU 来缓冲，
         * setLayerType(LAYER_TYPE_SOFTWARE) 是直接直接用一个 Bitmap 来缓冲
         * */
    }
}