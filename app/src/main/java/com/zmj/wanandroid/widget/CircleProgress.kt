package com.zmj.wanandroid.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zmj.baselibray.log.LogUtil

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/7
 * Description :
 */

class CircleProgress :View {

    constructor(context: Context): super(context)
    constructor(context: Context,attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, style: Int): super(context, attrs,style)

    private var progress: Int = 50
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var rect: RectF? = null
    private var textRect: Rect = Rect()

    fun getProgress():Int{
        return progress
    }
    fun setProgress(progress: Int){
        this.progress = progress
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.RED

        if (rect == null){
            rect = RectF(10f,10f,width.toFloat() -10 ,height.toFloat() - 10)
        }


        canvas?.save()
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4f
        canvas?.drawArc(rect!!,0f,(progress * 3.6f).toFloat(),false,paint)
        paint.textSize = 100f
        paint.style = Paint.Style.FILL

        paint.getTextBounds("W",0,1,textRect)

        canvas?.drawText("W",(width/2f - 50),(height/2f + 20),paint)
        canvas?.restore()
    }

}