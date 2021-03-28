package com.edwinperaza.androidgraphicsweekone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyView(context: Context?) : View(context) {

    private var bluePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var redPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        redPaint.style = Paint.Style.STROKE //stroke only no fill
        redPaint.color = Color.RED
        redPaint.strokeWidth = 5f //set the line stroke width to 5

        bluePaint.style = Paint.Style.STROKE //stroke only no fill
        bluePaint.color = Color.BLUE
        bluePaint.strokeWidth = 5f //set the line stroke width to 5
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        canvas?.drawCircle(300F,300F,250F, redPaint)
//        canvas?.drawCircle(500F,450F,50F, bluePaint)

        canvas?.drawRect(500F,500F,700F,700F, redPaint)
        canvas?.drawCircle(600F,600F,145F, bluePaint)
    }
}