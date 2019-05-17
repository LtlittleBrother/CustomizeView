package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.customizeview.R
/**
 *Matrix.setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex, int pointCount) 用点对点映射的方式设置变换
 * 参数里，src 和 dst 是源点集合目标点集；srcIndex 和 dstIndex 是第一个点的偏移；pointCount 是采集的点的个数（个数不能大于 4，因为大于 4 个点就无法计算变换了）。
 *
 *
 * poly 就是「多」的意思。setPolyToPoly() 的作用是通过多点的映射的方式来直接设置变换。
 * 「多点映射」的意思就是把指定的点移动到给出的位置，从而发生形变。
 * 例如：(0, 0) -> (100, 100) 表示把 (0, 0) 位置的像素移动到 (100, 100) 的位置，这个是单点的映射，单点映射可以实现平移。
 * 而多点的映射，就可以让绘制内容任意地扭曲
 * */
class SetPolyToPoly : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)
        setLayerType(View.LAYER_TYPE_SOFTWARE,null)
        /**左上坐标*/
        val oneLeft = 0f
        val oneTop = bitmap.height.toFloat()

        val oneRight = bitmap.width.toFloat()
        val oneBottom = (bitmap.height*2).toFloat()

        val twoLeft = 0f
        val twoTop = bitmap.height.toFloat()

        val twoRight = bitmap.width.toFloat()
        val twoBottom = (bitmap.height*2).toFloat()

        canvas!!.drawBitmap(bitmap, 0f, 0f, paint)
        val pointsSrc = floatArrayOf(oneLeft,oneTop,oneRight,twoTop,twoLeft,oneBottom,twoRight,twoBottom)
        val pointsDst = floatArrayOf(oneLeft-10,oneTop+150,oneRight+200,twoTop+90,twoLeft+60,oneBottom-20,twoRight+100,twoBottom+60)
        val matrix = matrix
        canvas.save()
        matrix.reset()
        matrix.setPolyToPoly(pointsSrc, 0, pointsDst, 0, 4)
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, 0f, bitmap.height.toFloat(), paint)
        canvas.restore()
    }
}