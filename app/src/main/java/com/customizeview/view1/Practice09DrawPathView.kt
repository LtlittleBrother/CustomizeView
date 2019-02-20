package com.customizeview.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
//        练习内容：使用 canvas.drawPath() 方法画心形
/**前面的这些方法，都是绘制某个给定的图形，而 drawPath() 可以绘制自定义图形。当你要绘制的图形比较特殊，使用前面的那些方法做不到的时候，就可以使用 drawPath() 来绘制*/
/**drawPath(path) 这个方法是通过描述路径的方式来绘制图形的，它的 path 参数就是用来描述图形路径的对象。path 的类型是 Path ，使用方法大概像下面这样：*/

class Practice09DrawPathView :View{

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        var path = Path()
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.color = Color.RED
//        path.addArc(200f, 200f, 400f, 400f, -225f, 225f)
        path.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
//        path.lineTo(400f, 542f)
        canvas!!.drawPath(path,paint)
    }
}