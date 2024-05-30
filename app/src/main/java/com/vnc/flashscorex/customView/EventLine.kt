package com.vnc.flashscorex.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import com.vnc.flashscorex.model.event.GoalModel

class EventLine @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val linePaint = Paint().apply {
        color = Color.GRAY
        strokeWidth = 5f
    }

    private var y: Float = 0.0f

    private var listEvent = listOf<String>()
    private var listMinute = listOf<Int>()

    fun setData(listEvent: List<String>, listMinute: List<Int>){
        this.listEvent = listEvent
        this.listMinute = listMinute
    }

    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = 25f
    }

    private val textPaintEvent = Paint().apply {
        color = Color.BLACK
        textSize = 35f
    }

    private val circlePaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
    }

    private val circleStrokePaint = Paint().apply {
        color = Color.GRAY
        style = Paint.Style.STROKE
        strokeWidth = 4f
    }
//    val minutes = listOf(10, 20, 30, 45, 60, 75, 90)
//    val events = listOf("Event 1", "Event 2", "Event 3", "Halftime", "Event 4", "Event 5", "Match End")

    private val circleRadius = 25f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawLineVertical(canvas)
        displayEventsVertical(canvas, listMinute, listEvent)
    }

    private fun drawLineVertical(canvas: Canvas) {
        val startX = (canvas.width / 2).toFloat()
        val startY = 10f
        val endY = (canvas.height - 10).toFloat()
        canvas.drawLine(startX, startY, startX, endY, linePaint)
    }

    private fun displayEventsVertical(canvas: Canvas, minutes: List<Int>, events: List<String>) {
        if (minutes.size != events.size) return

        val startY = 10f
        val endY = (canvas.height - 10).toFloat()
        val length = endY - startY
        val x = (canvas.width / 2).toFloat()

        for (i in minutes.indices) {
            // Adjust 'y' value slightly upwards
            val max: Int = minutes.maxOrNull() ?: 0
            if ( max > 119 ){
                 y = startY + (minutes[i] * length) / 120 - 25
            } else{
                 y = startY + (minutes[i] * length) / 90 - 25
            }

            // Draw minute number in the center of the circle
            textPaint.textSize = 20f // Adjust text size for minutes
            textPaint.typeface = Typeface.DEFAULT_BOLD // Make minutes text bold
            val textWidth = textPaint.measureText(minutes[i].toString()) // Measure text width
            val textBaselineY = y - textPaint.ascent()
            // Draw circle stroke first
            canvas.drawCircle(x, y, circleRadius, circleStrokePaint)
            // Draw circle over the minute number
            canvas.drawCircle(x, y, circleRadius, circlePaint)
            canvas.drawText(minutes[i].toString(), x - textWidth / 2, textBaselineY - 10, textPaint) // Center text on circle
            // Draw event text below circle
            canvas.drawText(events[i], x + 40, y+15, textPaintEvent)
        }
    }
}