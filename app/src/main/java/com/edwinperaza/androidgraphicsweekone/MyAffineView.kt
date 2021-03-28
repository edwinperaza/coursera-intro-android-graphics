package com.edwinperaza.androidgraphicsweekone

import android.content.Context
import android.graphics.*
import android.view.View

class MyAffineView(context: Context?) : View(context) {

    private var linearGradient: LinearGradient =
        LinearGradient(50F, 300F, 300F, 200F, Color.BLUE, Color.RED, Shader.TileMode.MIRROR)
    private var gradientPaint: Paint = Paint()
    private val whitePaint: Paint = Paint()
    var points = arrayListOf<Point>()

    init {
        // Set style, shader and stroke of our Paints
        gradientPaint.style = Paint.Style.FILL
        gradientPaint.shader = linearGradient

        whitePaint.style = Paint.Style.STROKE
        whitePaint.strokeWidth = 10F
        whitePaint.color = Color.WHITE

        // Set initial values of our points
        points.add(Point(50, 300))
        points.add(Point(150, 400))
        points.add(Point(180, 340))
        points.add(Point(240, 420))
        points.add(Point(300, 200))
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Draw first polygon (before translation)
        var lines = updatePath(points)
        lines?.let {
            canvas?.drawPath(it, gradientPaint)
        }

        // Apply translation
        val newPoints = translate(points, 20, 40)

        // Draw second polygon (AFTER translation)
        lines = updatePath(newPoints)
        lines?.let {
            canvas?.drawPath(it, whitePaint)
        }

    }

    /**
     * Creates a Path variable called lines in a way that we can create a Polygon later
     *
     * @param points array of Point(x,y) that we are going to use to create the path
     *
     * @return a path if the list of points is non null
     */
    private fun updatePath(points: ArrayList<Point>): Path? {
        if (points.size == 0) return null

        val lines = Path()
        lines.reset()
        lines.moveTo(points[0].x.toFloat(), points[0].y.toFloat())
        for (p in 1 until points.size) {
            lines.lineTo(points[p].x.toFloat(), points[p].y.toFloat())
        }
        lines.close()

        return lines
    }

    /**
     * Creates a homogeneous matrix with the values that we'll use to transform our polygon
     *
     * @param input list of elements that we want to transform
     * @param px value that we want to add to the X axis
     * @param py value that we want to add to the Y axis
     *
     * @return a list of points transformed
     */
    private fun translate(input: ArrayList<Point>, px: Int, py: Int): ArrayList<Point> {
        val myMatrix = ArrayList<ArrayList<Int>>()
        myMatrix.add(arrayListOf(1, 0, px))
        myMatrix.add(arrayListOf(0, 1, py))
        myMatrix.add(arrayListOf(0, 0, 1))
        return affineTransformation(input, myMatrix)
    }

    /**
     * An affine transformation is any transformation that preserves collinearity
     * (i.e., all points lying on a line initially still lie on a line after transformation)
     * and ratios of distances (e.g., the midpoint of a line segment remains the midpoint
     * after transformation)
     *
     * @param vertices list of vertices/points that we want to transform/translate
     * @param myMatrix homogeneous matrix (2D list) to be apply for transformation
     *
     * @return list of vertices transformed
     */
    private fun affineTransformation(vertices: ArrayList<Point>, myMatrix: ArrayList<ArrayList<Int>>): ArrayList<Point> {
        val pointResult = arrayListOf<Point>()

        for (i in 0 until vertices.size) {
            val t = (myMatrix[0][0] * vertices[i].x + myMatrix[0][1] * vertices[i].y + myMatrix[0][2])
            val u = (myMatrix[1][0] * vertices[i].x + myMatrix[1][1] * vertices[i].y + myMatrix[1][2])
            pointResult.add(Point(t, u))
        }
        return pointResult
    }
}