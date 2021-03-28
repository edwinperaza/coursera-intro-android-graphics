package com.edwinperaza.androidgraphicsweekone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class MyView(context: Context?) : View(context) {

    private var bluePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var redPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val lines = Path()
    private val greenPaint: Paint = Paint()

    init {
        redPaint.style = Paint.Style.STROKE //stroke only no fill
        redPaint.color = Color.RED
        redPaint.strokeWidth = 5f //set the line stroke width to 5

        bluePaint.style = Paint.Style.STROKE //stroke only no fill
        bluePaint.color = Color.BLUE
        bluePaint.strokeWidth = 5f //set the line stroke width to 5

        greenPaint.style = Paint.Style.STROKE //stroke only no fill
        greenPaint.setARGB(255, 0, 255, 0)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Draw a Square and a Circle
        canvas?.drawRect(500F,500F,700F,700F, redPaint)
        canvas?.drawCircle(600F,600F,145F, bluePaint)


        // Draw a Diagonal Line
        lines.moveTo(50F,50F)
        lines.lineTo(200F, 200F)
        lines.lineTo(300F, 55F)
        lines.lineTo(400F, 180F)
        lines.lineTo(450F, 50F)

        canvas?.drawPath(lines, greenPaint)
    }
}