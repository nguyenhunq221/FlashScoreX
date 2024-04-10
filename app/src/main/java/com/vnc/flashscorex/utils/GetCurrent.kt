package com.vnc.flashscorex.utils

import java.util.Calendar
import java.util.Date

object GetCurrent {

     val NUMBER_DAY = arrayOf("Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy")

    fun getCurrentYear(): Int {
        val calendar = Calendar.getInstance()
        return if (calendar.get(Calendar.MONTH) > 7){
            calendar.get(Calendar.YEAR)
        }else{
            calendar.get(Calendar.YEAR) - 1
        }
    }

    fun getTimeHours(): String {
       return TimeUtils.convertDateToString(Date(),TimeUtils.TimeUtil.DATE_FORMAT_10)
    }

    fun getDate(): String {
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar[Calendar.DAY_OF_WEEK]
        val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
        val monthOfYear = calendar[Calendar.MONTH] + 1
        val year = calendar[Calendar.YEAR]
        return NUMBER_DAY[dayOfWeek - 1] + ", " + dayOfMonth + " tháng " + monthOfYear + ", " + year
    }
}