package com.edwinperaza.androidgraphicsweekone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyPlottingView(context: Context?) : View(context) {

    private var bluePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var redPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var greenPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        bluePaint.style = Paint.Style.FILL
        redPaint.style = Paint.Style.FILL
        greenPaint.style = Paint.Style.FILL
        bluePaint.color = Color.BLUE
        redPaint.color = Color.RED
        greenPaint.color = Color.GREEN
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //20, 15, 34, 19, 38 = 126
        //16%, 12%, 27%, 15%, 30%
        canvas?.drawArc(0F, 0F, 500F, 500F, 0F, 57F, true, bluePaint)
        canvas?.drawArc(0F, 0F, 500F, 500F, 57F, 43F, true, redPaint)
        canvas?.drawArc(0F, 0F, 500F, 500F, 100F, 133F, true, greenPaint)
        canvas?.drawArc(0F, 0F, 500F, 500F, 233F, 54F, true, bluePaint)
        canvas?.drawArc(0F, 0F, 500F, 500F, 287F, 73F, true, redPaint)

    }

}