package com.suspend.android.noteappkmm.domain.note.time

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun LocalDateTime.now(): LocalDateTime{
    return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
}

fun LocalDateTime.toEpochMillis(dateTime: LocalDateTime):Long{
    return dateTime.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()
}

fun LocalDateTime.formatNoteDate(dateTime: LocalDateTime):String{
    val month = dateTime.month.name.lowercase().take(3).replaceFirstChar { it.uppercase() }
    val day = if(dateTime.dayOfMonth < 10) "0${dateTime.dayOfMonth}" else dateTime.dayOfMonth
    val year = dateTime.year
    val hour = if(dateTime.hour < 10) "0${dateTime.minute}" else dateTime.minute

    return buildString {
        append(month)
        append(" ")
        append(day)
        append(" ")
        append(year)
        append(", ")
        append(hour)
        append(":")
    }
}