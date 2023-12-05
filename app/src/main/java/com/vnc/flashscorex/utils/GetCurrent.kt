package com.vnc.flashscorex.utils

import java.util.Calendar
object GetCurrent {
    fun getCurrentYear(): Int {
        val calendar = Calendar.getInstance()
        return if (calendar.get(Calendar.MONTH) > 7){
            calendar.get(Calendar.YEAR)
        }else{
            calendar.get(Calendar.YEAR) - 1
        }
    }
}