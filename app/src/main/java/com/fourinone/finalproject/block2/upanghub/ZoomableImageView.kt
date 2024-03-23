package com.fourinone.finalproject.block2.upanghub

import android.content.Context
import android.graphics.Matrix
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector

class ZoomableImageView(context: Context, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatImageView(context, attrs),
    ScaleGestureDetector.OnScaleGestureListener {

    private var scaleGestureDetector: ScaleGestureDetector? = null
    private var matrix: Matrix = Matrix()
    private var mode = NONE
    private var last = PointF()
    private var start = PointF()
    private var minScale = 1f
    private var maxScale = 3f

    companion object {
        private const val NONE = 0
        private const val DRAG = 1
        private const val ZOOM = 2
    }

    init {
        scaleGestureDetector = ScaleGestureDetector(context, this)
        setImageMatrix(matrix)
        scaleType = ScaleType.MATRIX

        // Set an OnClickListener to handle click events
        setOnClickListener {
            // Perform the desired action when the image is clicked
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleGestureDetector!!.onTouchEvent(event)
        val currentPoint = PointF(event.x, event.y)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                last.set(currentPoint)
                start.set(last)
                mode = DRAG
            }
            MotionEvent.ACTION_MOVE -> if (mode == DRAG) {
                val deltaX = currentPoint.x - last.x
                val deltaY = currentPoint.y - last.y
                matrix.postTranslate(deltaX, deltaY)
                last.set(currentPoint.x, currentPoint.y)
            }
            MotionEvent.ACTION_UP -> mode = NONE
        }

        imageMatrix = matrix
        invalidate()
        return true
    }

    override fun onScale(detector: ScaleGestureDetector): Boolean {
        val scaleFactor = detector.scaleFactor
        val focusX = detector.focusX
        val focusY = detector.focusY

        val origScale = getMatrixScale(matrix)
        val newScale = origScale * scaleFactor

        if (newScale < maxScale && newScale > minScale) {
            matrix.postScale(scaleFactor, scaleFactor, focusX, focusY)
        }

        imageMatrix = matrix
        invalidate()
        return true
    }

    override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
        return true
    }

    override fun onScaleEnd(detector: ScaleGestureDetector) {}

    private fun getMatrixScale(matrix: Matrix): Float {
        val values = FloatArray(9)
        matrix.getValues(values)
        return values[Matrix.MSCALE_X]
    }
}