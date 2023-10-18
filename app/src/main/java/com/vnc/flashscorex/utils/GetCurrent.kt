package com.vnc.flashscorex.utils

import java.util.Calendar
object GetCurrent {
    fun getCurrentYear(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.YEAR)
    }
}