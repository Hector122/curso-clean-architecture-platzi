package com.example.android.minipaint

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.core.content.res.ResourcesCompat


private const val STROKE_WIDTH = 12f // has to be float

class MyCanvasView(context: Context) : View(context) {
    
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    
    private val backgroundColor = ResourcesCompat.getColor(resources, R.color.colorBackground, null)
    
    private val drawColor = ResourcesCompat.getColor(resources, R.color.colorPaint, null)
    
    private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop
    
    // Set up the paint with which to draw.
    private val paint = Paint().apply {
        color = drawColor // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias =
            true // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }
    
    private var path = Path()
    
    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f
    
    //cache the latest x and y values. After the user stops moving and lifts their touch
    private var currentX = 0f
    private var currentY = 0f
    
    private lateinit var frame: Rect
    
    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        
        // for avoid memory leak
        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        
        extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor) //Specify the background color in which to fill extraCanvas.
        
        // Calculate a rectangular frame around the picture.
        val inset = 40
        frame = Rect(inset, inset, width - inset, height - inset)
    }
    
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        
        canvas?.drawBitmap(extraBitmap, 0f, 0f, null)
        
        // Draw a frame around the canvas.
        canvas?.drawRect(frame, paint)
    }
    
    private fun touchStart() {
        path.reset()
        path.moveTo(motionTouchEventX, motionTouchEventY)
        currentX = motionTouchEventX
        currentY = motionTouchEventY
    }
    
    /**
     * 1. Calculate the distance that has been moved (dx, dy).
     * 2. If the movement was further than the touch tolerance, add a segment to the path.
     * 3. Set the starting point for the next segment to the endpoint of this segment.
     * 4. Using quadTo() instead of lineTo() create a smoothly drawn line without corners. See Bezier Curves.
     * 5. Call invalidate() to (eventually call onDraw() and) redraw the view.
     */
    private fun touchMove() {
        val dx = Math.abs(motionTouchEventX - currentX)
        val dy = Math.abs(motionTouchEventY - currentY)
        if (dx >= touchTolerance || dy >= touchTolerance) {
            // QuadTo() adds a quadratic bezier from the last point,
            // approaching control point (x1,y1), and ending at (x2,y2).
            path.quadTo(currentX, currentY,
                    (motionTouchEventX + currentX) / 2,
                    (motionTouchEventY + currentY) / 2)
            currentX = motionTouchEventX
            currentY = motionTouchEventY
            // Draw the path in the extra bitmap to cache it.
            extraCanvas.drawPath(path, paint)
        }
        invalidate()
    }
    
    private fun touchUp() {
        // Reset the path so it doesn't get drawn again.
        path.reset()
    }
    
    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y
        
        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
        
        return true
    }
    
    /**
     * In the current app, the cumulative drawing information is cached in a bitmap.
     * While this is a good solution, it is not the only possible way. How you store your drawing
     * history depends on the app, and your various requirements. For example, if you are drawing shapes,
     * you could save a list of shapes with their location and dimensions. For the MiniPaint app,
     * you could save the path as a Path. Below is the general outline on how to do that,
     * if you want to try it.
     *
     * Remove all the code for extraCanvas and extraBitmap.
     * Add variables for the path so far, and the path being drawn currently.
    // Path representing the drawing so far
    private val drawing = Path()
    
    // Path representing what's currently being drawn
    private val curPath = Path()
    In onDraw(), instead of drawing the bitmap, draw the stored and current paths.
    // Draw the drawing so far
    canvas.drawPath(drawing, paint)
    // Draw any current squiggle
    canvas.drawPath(curPath, paint)
    // Draw a frame around the canvas
    canvas.drawRect(frame, paint)
    In touchUp() , add the current path to the previous path and reset the current path.
    // Add the current path to the drawing so far
    drawing.addPath(curPath)
    // Rewind the current path for the next touch
    curPath.reset()
    Run your app, and yes, there should be no difference whatsoever.
     */
}