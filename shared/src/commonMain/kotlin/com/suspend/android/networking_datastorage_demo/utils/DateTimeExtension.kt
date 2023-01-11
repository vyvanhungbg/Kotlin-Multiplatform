package com.suspend.android.networking_datastorage_demo.utils

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


fun LocalDateTime.formatNoteDate(): String {
    this.apply {
        val _month = month.name.lowercase().take(3).replaceFirstChar { it.uppercase() }
        val _day = if (dayOfMonth < 10) "0${dayOfMonth}" else dayOfMonth
        val _hour = if (hour < 10) "0${hour}" else hour
        val _minute = if (minute < 10) "0${minute}" else minute
        val _seconds = if (second < 10) "0${second}" else second
        return "$_day-$_month-$year at $_hour:$_minute:$_seconds"
    }
}

fun String.toDateForHuman(): String {
    return try {
        val instant = Instant.parse(this)
        instant.toLocalDateTime(TimeZone.currentSystemDefault()).formatNoteDate()
    } catch (ex: Exception) {
        ""
    }
}