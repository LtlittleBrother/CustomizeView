package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.customizeview.R
/**
 * Camera.rotate*() 三维旋转
 * Camera.rotate*() 一共有四个方法： rotateX(deg) rotateY(deg) rotateZ(deg) rotate(x, y, z)
 * Camera 和 Canvas 一样也需要保存和恢复状态才能正常绘制，不然在界面刷新之后绘制就会出现问题
 * */
class Practice11CameraRotate: View {

    private var cameraLocationZ: Float = 100f
    private var rotateX: Float = 0f

    private var rotateType: Int? = 1

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
        val camera = Camera()

        canvas!!.save()
        camera.save() // 保存 Camera 的状态
        camera.setLocation(0f,0f,cameraLocationZ)//使用 setLocation() 方法来把相机往后移动,避免糊脸效果...
        when(rotateType){
            1 -> {
                camera.rotateX(rotateX) // 旋转 Camera 的三维空间
            }
            2 -> {
                camera.rotateY(rotateX) // 旋转 Camera 的三维空间
            }
            3 -> {
                camera.rotateZ(rotateX) // 旋转 Camera 的三维空间
            }
            4 -> {
                camera.rotate(rotateX,rotateX-30,rotateX-60) // 旋转 Camera 的三维空间
            }
        }
        canvas.translate(300f,200f)// 旋转之后把投影移动回来
        camera.applyToCanvas(canvas) // 把旋转投影到 Canvas
        camera.restore() // 恢复 Camera 的状态
        canvas.translate(-200f,-200f)// 旋转之前把绘制内容移动到轴心（原点）
        canvas.drawBitmap(bitmap,0f, 0f, paint)
        canvas.restore()

    }

    fun setCameraLocation(z: Float){
        val locationZ = z - 500
        this.cameraLocationZ = locationZ
        invalidate()
    }

    fun setRotate(type: Int){
        this.rotateType = type
        invalidate()
    }

    fun setRotateX(rotateX: Float){
        this.rotateX = -rotateX
        invalidate()
    }

}