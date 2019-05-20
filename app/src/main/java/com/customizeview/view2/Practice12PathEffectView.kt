package com.customizeview.view2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.graphics.DashPathEffect
import android.graphics.DiscretePathEffect
import android.graphics.PathEffect




/**
 * setPathEffect(PathEffect effect)
 *
 * 使用 PathEffect 来给图形的轮廓设置效果。对 Canvas 所有的图形绘制有效，也就是 drawLine() drawCircle() drawPath() 这些方法
 *
 * PathEffect 在有些情况下不支持硬件加速，需要关闭硬件加速才能正常使用：
 * Canvas.drawLine() 和 Canvas.drawLines() 方法画直线时，setPathEffect() 是不支持硬件加速的；
 * PathDashPathEffect 对硬件加速的支持也有问题，所以当使用 PathDashPathEffect 的时候，最好也把硬件加速关了。
 * */
class Practice12PathEffectView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.isAntiAlias = true

        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        val pathEffect = DashPathEffect(floatArrayOf(10f, 5f), 10f)
        paint.pathEffect = pathEffect
        canvas!!.drawCircle(300f,300f,200f,paint)
        paint.textSize = 30f
        canvas.drawText("DashPathEffect",150f,300f,paint)
        canvas.drawText("原图形",100f,550f,paint)

        val paint1 = Paint()
        paint1.style = Paint.Style.STROKE
        paint1.isAntiAlias = true
        val path = Path()
        path.moveTo(100f,600f)
        path.lineTo(300f,900f)
        path.lineTo(500f,600f)
        path.lineTo(700f,900f)
        path.lineTo(900f,600f)
        path.lineTo(1100f,900f)
        path.lineTo(1300f,600f)
        canvas.drawPath(path,paint1)

        canvas.drawText("添加PathEffect后",100f,950f,paint)

        /**
         * CornerPathEffect
         * 把所有拐角变成圆角。
         * 它的构造方法 CornerPathEffect(float radius) 的参数 radius 是圆角的半径。
         * */
//        cancasCornerPathEffect(canvas, paint1)

        /**
         * DiscretePathEffect
         * 把线条进行随机的偏离，让轮廓变得乱七八糟。乱七八糟的方式和程度由参数决定。
         * DiscretePathEffect(20, 5);
         * */
//        cancasDiscretePathEffect(canvas, paint1)

        /**
         * DashPathEffect
         * 使用虚线来绘制线条
         * 列：DashPathEffect(new float[]{20, 10, 5, 10}, 0);
         * */
//        cancasDashPathEffect(canvas, paint1)

        /**
         * PathDashPathEffect
         * 这个方法比 DashPathEffect 多一个前缀 Path ，所以顾名思义，它是使用一个 Path 来绘制「虚线」。具体看图吧：
         * 列：PathDashPathEffect(Path, 40, 0,
        PathDashPathEffectStyle.TRANSLATE);
         * */
//        cancasPathDashPathEffect(canvas, paint1)

        /**
         * SumPathEffect
         * 这是一个组合效果类的 PathEffect 。它的行为特别简单，就是分别按照两种 PathEffect 分别对目标进行绘制。
         * 列：SumPathEffect(PathEffect, PathEffect);
         * */
//        cancasSumPathEffect(canvas, paint1)

        /**
         * ComposePathEffect
         * 这也是一个组合效果类的 PathEffect 。不过它是先对目标 Path 使用一个 PathEffect，然后再对这个改变后的 Path 使用另一个 PathEffect。
         * 列：ComposePathEffect(PathEffect, PathEffect);
         * */
//        cancasPathDashPathEffect(canvas, paint1)


    }

    private fun cancasCornerPathEffect(canvas: Canvas?, paint: Paint){
        val path = Path()
        //添加CornerPathEffect
        val cornerPathEffect = CornerPathEffect(30f)
        paint.pathEffect = cornerPathEffect
        path.moveTo(100f,1000f)
        path.lineTo(300f,1300f)
        path.lineTo(500f,1000f)
        path.lineTo(700f,1300f)
        path.lineTo(900f,1000f)
        path.lineTo(1100f,1300f)
        path.lineTo(1300f,1000f)
        canvas!!.drawPath(path,paint)
    }

    private fun cancasDiscretePathEffect(canvas: Canvas?, paint: Paint){
        //添加DiscretePathEffect
        val discretePathEffect = DiscretePathEffect(20f,5f)
        val path = Path()
        paint.pathEffect = discretePathEffect
        path.moveTo(100f,1000f)
        path.lineTo(300f,1300f)
        path.lineTo(500f,1000f)
        path.lineTo(700f,1300f)
        path.lineTo(900f,1000f)
        path.lineTo(1100f,1300f)
        path.lineTo(1300f,1000f)
        canvas!!.drawPath(path,paint)
    }

    private fun cancasDashPathEffect(canvas: Canvas?, paint: Paint){
        val path = Path()
        //添加DashPathEffect
        val dashPathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)
        paint.pathEffect = dashPathEffect
        path.moveTo(100f,1000f)
        path.lineTo(300f,1300f)
        path.lineTo(500f,1000f)
        path.lineTo(700f,1300f)
        path.lineTo(900f,1000f)
        path.lineTo(1100f,1300f)
        path.lineTo(1300f,1000f)
        canvas!!.drawPath(path,paint)
    }

    private fun cancasPathDashPathEffect(canvas: Canvas?, paint: Paint){
        val dashPath = Path()
        dashPath.moveTo(50f,0f)
        dashPath.lineTo(0f,50f)
        dashPath.lineTo(100f,50f)
        dashPath.lineTo(50f,0f)
        val path = Path()
        /**TRANSLATE：位移
         * ROTATE：旋转
         * MORPH：变体*/
        val pathDashPathEffect = PathDashPathEffect(dashPath, 40f, 0f,PathDashPathEffect.Style.TRANSLATE)
        paint.pathEffect = pathDashPathEffect
        path.moveTo(100f,1000f)
        path.lineTo(300f,1300f)
        path.lineTo(500f,1000f)
        path.lineTo(700f,1300f)
        path.lineTo(900f,1000f)
        path.lineTo(1100f,1300f)
        path.lineTo(1300f,1000f)
        canvas!!.drawPath(path,paint)
    }

    private fun cancasSumPathEffect(canvas: Canvas?, paint: Paint){
        val path = Path()
        val dashEffect = DashPathEffect(floatArrayOf(20f, 10f), 0f)
        val discreteEffect = DiscretePathEffect(20f, 5f)
        val sumPathEffect = SumPathEffect(dashEffect,discreteEffect)
        paint.pathEffect = sumPathEffect
        path.moveTo(100f,1000f)
        path.lineTo(300f,1300f)
        path.lineTo(500f,1000f)
        path.lineTo(700f,1300f)
        path.lineTo(900f,1000f)
        path.lineTo(1100f,1300f)
        path.lineTo(1300f,1000f)
        canvas!!.drawPath(path,paint)
    }

    private fun cancasComposePathEffect(canvas: Canvas?, paint: Paint){
        val path = Path()
        val dashEffect = DashPathEffect(floatArrayOf(20f, 10f), 0f)
        val discreteEffect = DiscretePathEffect(20f, 5f)
        val sumPathEffect = ComposePathEffect(dashEffect,discreteEffect)
        paint.pathEffect = sumPathEffect
        path.moveTo(100f,1000f)
        path.lineTo(300f,1300f)
        path.lineTo(500f,1000f)
        path.lineTo(700f,1300f)
        path.lineTo(900f,1000f)
        path.lineTo(1100f,1300f)
        path.lineTo(1300f,1000f)
        canvas!!.drawPath(path,paint)
    }
}