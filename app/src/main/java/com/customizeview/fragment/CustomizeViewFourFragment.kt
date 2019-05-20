package com.customizeview.fragment

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.customizeview.R
import com.customizeview.view4.*
import com.fiction.util.ToastUtil


class CustomizeViewFourFragment : Fragment(){

    private val TAB_FRAGMENT_TYPE_DATA = "customize_view_four_fragment"

    private var mView: View? = null

    private var mIsPrepare: Boolean = false//视图还没准备好
    private var mIsVisible: Boolean = false//不可见
    private var mIsFirstLoad: Boolean = true//第一次加载

    private lateinit var rotaeSeekBar: SeekBar
    private lateinit var cameraSeekBar: SeekBar

    private lateinit var mOneTv: TextView
    private lateinit var mTwoTv: TextView

    private lateinit var rotateRadioGroup: RadioGroup
    private lateinit var rotateXRadioButton: RadioButton
    private lateinit var rotateYRadioButton: RadioButton
    private lateinit var rotateZRadioButton: RadioButton
    private lateinit var rotateXYZRadioButton: RadioButton

    private lateinit var data: String

    private lateinit var mRadiusLl: LinearLayout
    private lateinit var mRadiusTv: TextView
    private lateinit var mRadiusSeekBar: SeekBar

    private lateinit var mScaleLl: LinearLayout
    private lateinit var mScaleTv: TextView
    private lateinit var mScaleSeekBar: SeekBar

    /**view*/
    private lateinit var clipRect: Practice01ClipRect
    private lateinit var clipPath: Practice02ClipPath
    private lateinit var translate: Practice03Translate
    private lateinit var rotate: Practice04Rotate
    private lateinit var scale: Practice05Scale
    private lateinit var skew: Practice06Skew
    private lateinit var matrixTranslate: Practice07MatrixTranslate
    private lateinit var matrixScale: Practice08MatrixScale
    private lateinit var matrixRotate: Practice09MatrixRotate
    private lateinit var matrixSkew: Practice10MatrixSkew
    private lateinit var cameraRotate: Practice11CameraRotate
    private lateinit var cameraRotateFixed: Practice12CameraRotateFixed
    private lateinit var cameraRotateHittingFace: Practice13CameraRotateHittingFace
    private lateinit var flipboard: Practice14Flipboard
    private lateinit var setPolyToPoly: SetPolyToPoly

    fun newInstance(data: String): CustomizeViewFourFragment{
        val fragment = CustomizeViewFourFragment()
        val bundle = Bundle()
        bundle.putSerializable(TAB_FRAGMENT_TYPE_DATA,data)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val arguments = arguments
        data = arguments!!.getString(TAB_FRAGMENT_TYPE_DATA)
        if (mView == null){
            mView = inflater.inflate(R.layout.customize_view_four_fragment_layout,container,false)
        }
        findView(mView!!)
        setEvent()
        return mView
    }

    private fun setEvent() {
        rotaeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("liutao", "progress == $progress")
                rotateProgress(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        cameraSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                cameraProgress(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        mRadiusSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                radiusProgress(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        mScaleSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                scaleProgress(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        rotateXRadioButton.setOnClickListener {
            cameraRotateType(1)
        }
        rotateYRadioButton.setOnClickListener {
            cameraRotateType(2)
        }
        rotateZRadioButton.setOnClickListener {
            cameraRotateType(3)
        }
        rotateXYZRadioButton.setOnClickListener {
            cameraRotateType(4)
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    fun findView(mView: View){

        mOneTv = mView.findViewById(R.id.rotate_tv)
        mTwoTv = mView.findViewById(R.id.camera_tv)
        cameraSeekBar = mView.findViewById(R.id.camera_seek_bar)
        rotaeSeekBar = mView.findViewById(R.id.rotate_seek_bar)

        mRadiusLl = mView.findViewById(R.id.radius_ll)
        mRadiusTv = mView.findViewById(R.id.radius_tv)
        mRadiusSeekBar = mView.findViewById(R.id.radius_sb)

        mScaleLl = mView.findViewById(R.id.scale_ll)
        mScaleTv = mView.findViewById(R.id.scale_tv)
        mScaleSeekBar = mView.findViewById(R.id.scale_sb)

        rotateRadioGroup = mView.findViewById(R.id.selector_type)
        rotateXRadioButton = mView.findViewById(R.id.rotate_x_rbt)
        rotateYRadioButton = mView.findViewById(R.id.rotate_y_rbt)
        rotateZRadioButton = mView.findViewById(R.id.rotate_z_rbt)
        rotateXYZRadioButton = mView.findViewById(R.id.rotate_xyz_rbt)

        when (data) {
            "Practice01ClipRect" -> {
                clipRect = mView.findViewById(R.id.practice_01_clip_rect)
                cameraSeekBar.max = 1400
                rotaeSeekBar.max = 1200
                mOneTv.text = "Y轴"
                mTwoTv.text = "X轴"
                clipRect.visibility = View.VISIBLE
            }
            "Practice02ClipPath" ->{
                clipPath = mView.findViewById(R.id.practice_02_clip_path)
                cameraSeekBar.max = 1400
                rotaeSeekBar.max = 1200
                mOneTv.text = "Y轴"
                mTwoTv.text = "X轴"
                mRadiusSeekBar.max = 500
                mRadiusLl.visibility = View.VISIBLE
                rotateRadioGroup.visibility = View.VISIBLE
                clipPath.visibility = View.VISIBLE
            }
            "Practice03Translate" -> {
                translate = mView.findViewById(R.id.practice_03_translate)
                cameraSeekBar.max = 1000
                rotaeSeekBar.max = 1200
                translate.visibility = View.VISIBLE
                mOneTv.text = "Y轴"
                mTwoTv.text = "X轴"
            }
            "Practice04Rotate" -> {
                rotate = mView.findViewById(R.id.practice_04_rotate)
                cameraSeekBar.max = 1400
                rotaeSeekBar.max = 1200
                mRadiusSeekBar.max = 720
                mRadiusSeekBar.progress = 360
                mOneTv.text = "Y轴"
                mTwoTv.text = "X轴"
                mRadiusTv.text = "旋转角度"
                mRadiusLl.visibility = View.VISIBLE
                rotate.visibility = View.VISIBLE
            }
            "Practice05Scale" -> {
                scale = mView.findViewById(R.id.practice_05_cale)
                cameraSeekBar.max = 1400
                rotaeSeekBar.max = 1200
                mRadiusSeekBar.max = 200
                mRadiusSeekBar.progress = 100
                mScaleSeekBar.max = 200
                mScaleSeekBar.progress = 100
                mOneTv.text = "Y轴"
                mTwoTv.text = "X轴"
                mRadiusTv.text = "放缩X"
                mScaleTv.text = "放缩Y"
                mScaleLl.visibility = View.VISIBLE
                mRadiusLl.visibility = View.VISIBLE
                scale.visibility = View.VISIBLE
            }
            "Practice06Skew" -> {
                skew = mView.findViewById(R.id.practice_06_skew)
                cameraSeekBar.max = 200
                cameraSeekBar.progress = 100
                rotaeSeekBar.max = 200
                rotaeSeekBar.progress = 100
                mOneTv.text = "Y轴"
                mTwoTv.text = "X轴"
                rotateRadioGroup.visibility = View.VISIBLE
                rotateXRadioButton.text = "负方向"
                rotateYRadioButton.text = "正方向"
                skew.visibility = View.VISIBLE
            }
            "Practice07MatrixTranslate" -> {
                matrixTranslate = mView.findViewById(R.id.practice_07_matrix_translate)
                matrixTranslate.visibility = View.VISIBLE
            }
            "Practice08MatrixScale" -> {
                matrixScale = mView.findViewById(R.id.practice_08_matrix_scale)
                matrixScale.visibility = View.VISIBLE
            }
            "Practice09MatrixRotate" -> {
                matrixRotate = mView.findViewById(R.id.practice_09_matrix_rotate)
                matrixRotate.visibility = View.VISIBLE
            }
            "Practice10MatrixSkew" -> {
                matrixSkew = mView.findViewById(R.id.practice_10_matrix_skew)
                matrixSkew.visibility = View.VISIBLE
            }
            "Practice11CameraRotate" -> {
                cameraRotate = mView.findViewById(R.id.practice_11_matrix_camera_rotate)
                cameraSeekBar.max = 1000
                cameraSeekBar.progress = 500
                rotaeSeekBar.max = 360
                cameraRotate.visibility = View.VISIBLE
                rotateRadioGroup.visibility = View.VISIBLE
            }
            "Practice12CameraRotateFixed" -> {
                cameraRotateFixed = mView.findViewById(R.id.practice_12_matrix_camera_rotate_fixed)
                rotaeSeekBar.max = 720
                rotaeSeekBar.progress = 360
                cameraRotateFixed.visibility = View.VISIBLE
            }
            "Practice13CameraRotateHittingFace" -> {
                cameraRotateHittingFace = mView.findViewById(R.id.practice_13_matrix_camera_rotate_hitting_face)
                cameraRotateHittingFace.visibility = View.VISIBLE
                rotaeSeekBar.max = 10000
                rotaeSeekBar.progress = 3000
                mOneTv.text = "进度"

            }
            "Practice14Flipboard" -> {
                flipboard = mView.findViewById(R.id.practice_14_flipboard)
                flipboard.visibility = View.VISIBLE
            }
            "SetPolyToPoly" -> {
                setPolyToPoly = mView.findViewById(R.id.set_poly_to_poly)
                setPolyToPoly.visibility = View.VISIBLE
            }
        }
    }

    /**X轴移动*/
    fun cameraProgress(progress: Int){
        when (data) {
            "Practice01ClipRect" -> {
                clipRect.setClipY(progress)
            }
            "Practice02ClipPath" ->{
                clipPath.setCircleX(progress)
            }
            "Practice03Translate" -> {
                translate.setTranslateX(progress.toFloat())
            }
            "Practice04Rotate" -> {
                rotate.setPx(progress)
            }
            "Practice05Scale" -> {
                scale.setPx(progress)
            }
            "Practice06Skew" -> {
                skew.setSkewX(progress)
            }
            "Practice07MatrixTranslate" -> {

            }
            "Practice08MatrixScale" -> {

            }
            "Practice09MatrixRotate" -> {

            }
            "Practice10MatrixSkew" -> {

            }
            "Practice11CameraRotate" -> {
                cameraRotate.setCameraLocation(progress.toFloat())
            }
            "Practice12CameraRotateFixed" -> {
                cameraRotateFixed.setLocationZ(progress)
            }
            "Practice13CameraRotateHittingFace" -> {

            }
            "Practice14Flipboard" -> {

            }
            "SetPolyToPoly" -> {

            }
        }
    }

    fun radiusProgress(progress: Int){
        when (data) {
            "Practice01ClipRect" -> {

            }
            "Practice02ClipPath" ->{
                clipPath.setRadius(progress)
            }
            "Practice03Translate" -> {

            }
            "Practice04Rotate" -> {
                rotate.setRotateDegree(progress)
            }
            "Practice05Scale" -> {
                scale.setSx(progress)
            }
            "Practice06Skew" -> {

            }
            "Practice07MatrixTranslate" -> {

            }
            "Practice08MatrixScale" -> {

            }
            "Practice09MatrixRotate" -> {

            }
            "Practice10MatrixSkew" -> {

            }
            "Practice11CameraRotate" -> {
                cameraRotate.setCameraLocation(progress.toFloat())
            }
            "Practice12CameraRotateFixed" -> {

            }
            "Practice13CameraRotateHittingFace" -> {

            }
            "Practice14Flipboard" -> {

            }
            "SetPolyToPoly" -> {

            }
        }
    }
    /**放缩*/
    fun scaleProgress(progress: Int){
        when (data) {
            "Practice01ClipRect" -> {

            }
            "Practice02ClipPath" ->{

            }
            "Practice03Translate" -> {

            }
            "Practice04Rotate" -> {

            }
            "Practice05Scale" -> {
                scale.setSy(progress)
            }
            "Practice06Skew" -> {

            }
            "Practice07MatrixTranslate" -> {

            }
            "Practice08MatrixScale" -> {

            }
            "Practice09MatrixRotate" -> {

            }
            "Practice10MatrixSkew" -> {

            }
            "Practice11CameraRotate" -> {

            }
            "Practice12CameraRotateFixed" -> {

            }
            "Practice13CameraRotateHittingFace" -> {

            }
            "Practice14Flipboard" -> {

            }
            "SetPolyToPoly" -> {

            }
        }
    }

    /**Y轴移动*/
    fun rotateProgress(progress: Int){
        when (data) {
            "Practice01ClipRect" -> {
                clipRect.setClipX(progress)
            }
            "Practice02ClipPath" ->{
                clipPath.setCircleY(progress)

            }
            "Practice03Translate" -> {
                translate.setTranslateY(progress.toFloat())
            }
            "Practice04Rotate" -> {
                rotate.setPy(progress)
            }
            "Practice05Scale" -> {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         6
                scale.setPy(progress)
            }
            "Practice06Skew" -> {
                skew.setSkewY(progress)
            }
            "Practice07MatrixTranslate" -> {

            }
            "Practice08MatrixScale" -> {

            }
            "Practice09MatrixRotate" -> {

            }
            "Practice10MatrixSkew" -> {

            }
            "Practice11CameraRotate" -> {
                cameraRotate.setRotateX(progress.toFloat())
            }
            "Practice12CameraRotateFixed" -> {
                cameraRotateFixed.setDegree(progress)
            }
            "Practice13CameraRotateHittingFace" -> {
                cameraRotateHittingFace.setStartAngle(progress)
            }
            "Practice14Flipboard" -> {

            }
            "SetPolyToPoly" -> {

            }
        }
    }

    fun cameraRotateType(type: Int){
        when (data) {
            "Practice01ClipRect" -> {

            }
            "Practice02ClipPath" ->{
                clipPath.setRegionType(type)
            }
            "Practice03Translate" -> {

            }
            "Practice04Rotate" -> {

            }
            "Practice05Scale" -> {

            }
            "Practice06Skew" -> {
                skew.setDirection(type)
            }
            "Practice07MatrixTranslate" -> {

            }
            "Practice08MatrixScale" -> {

            }
            "Practice09MatrixRotate" -> {

            }
            "Practice10MatrixSkew" -> {

            }
            "Practice11CameraRotate" -> {
                cameraRotate.setRotate(type)
            }
            "Practice12CameraRotateFixed" -> {

            }
            "Practice13CameraRotateHittingFace" -> {

            }
            "Practice14Flipboard" -> {

            }
            "SetPolyToPoly" -> {

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mIsPrepare = true
        lazyLoad()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser){
            mIsVisible = true
            lazyLoad()
        }else{
            mIsVisible = false
        }
        super.setUserVisibleHint(isVisibleToUser)
    }

    private fun lazyLoad(){
        if (mIsPrepare || mIsVisible || !mIsFirstLoad){
            return
        }
        loadData()
        //数据加载完毕,恢复标记,防止重复加载
        mIsFirstLoad = false
    }

    private fun loadData(){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        //如果Fragment销毁的话，还应该将三个标志位进行默认值初始化：
        mIsFirstLoad = true
        mIsVisible = false
        mIsPrepare = false
        if (mView != null){
            (mView!!.parent as ViewGroup).removeView(mView)
        }
    }
}