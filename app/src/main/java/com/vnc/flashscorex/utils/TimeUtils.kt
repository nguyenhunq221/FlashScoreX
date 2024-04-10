package com.vnc.flashscorex.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TimeUtils {
     object TimeUtil {
         const val DATE_FORMAT_10 = "HH:mm"
    }

    companion object{
        fun convertDateToString(date: Date, formatDate: String): String {
            val sdf = SimpleDateFormat(formatDate, Locale.getDefault())
            return sdf.format(date)
        }
    }

}