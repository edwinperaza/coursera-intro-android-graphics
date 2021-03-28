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
    private var redFillPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val lines = Path()
    private val greenPaint: Paint = Paint()
    private val blackPaint: Paint = Paint()

    init {
        redPaint.style = Paint.Style.STROKE //stroke only no fill
        redPaint.color = Color.RED
        redPaint.strokeWidth = 5f //set the line stroke width to 5

        bluePaint.style = Paint.Style.STROKE //stroke only no fill
        bluePaint.color = Color.BLUE
        bluePaint.strokeWidth = 5f //set the line stroke width to 5

        greenPaint.style = Paint.Style.STROKE //stroke only no fill
        greenPaint.setARGB(255, 0, 255, 0)

        redFillPaint.style = Paint.Style.FILL
        redFillPaint.setARGB(255, 255, 0, 0)
        blackPaint.style = Paint.Style.STROKE
        blackPaint.color = Color.WHITE

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Draw a Square and a Circle
        canvas?.drawRect(500F,500F,700F,700F, redPaint)
        canvas?.drawCircle(600F,600F,145F, bluePaint)

        // Draw a Polyline
        // Start Values
//        lines.moveTo(0F, 100F)
//        lines.lineTo(200F, 400F)
//        lines.lineTo(300F, 150F)
//        lines.lineTo(400F, 400F)
//        lines.lineTo(500F, 60F)

        // 2 -> 1 -> 3 -> 4 -> 0
//        lines.moveTo(300F, 150F)
//        lines.lineTo(200F, 400F)
//        lines.lineTo(0F, 100F)
//        lines.lineTo(400F, 400F)
//        lines.lineTo(500F, 60F)

        // 0 -> 1 -> 3 -> 2 -> 4
//        lines.moveTo(0F, 100F)
//        lines.lineTo(200F, 400F)
//        lines.lineTo(400F, 400F)
//        lines.lineTo(300F, 150F)
//        lines.lineTo(500F, 60F)

        // 4 -> 1 -> 3 -> 2 -> 0
        lines.moveTo(500F, 60F)
        lines.lineTo(200F, 400F)
        lines.lineTo(400F, 400F)
        lines.lineTo(300F, 150F)
        lines.lineTo(0F, 100F)

//        canvas?.drawPath(lines, greenPaint)
//        canvas?.drawCircle(185F, 356F, 250F, redPaint)

        // Draw a Polygon
//        lines.close() // This close the stroke but the polygon is still filled without it
        canvas?.drawPath(lines, redFillPaint)
        canvas?.drawPath(lines, blackPaint)
    }
}