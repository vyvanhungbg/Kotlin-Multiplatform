package com.suspend.android.noteappkmm.domain.note

import com.suspend.android.noteappkmm.domain.note.time.DateTimeUtil
import com.suspend.android.noteappkmm.presentation.BabyBlueHex
import com.suspend.android.noteappkmm.presentation.LightGreenHex
import com.suspend.android.noteappkmm.presentation.RedOrangeHex
import com.suspend.android.noteappkmm.presentation.RedPinkHex
import databases.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {
    companion object {
        private val colors = listOf<Long>(
            RedOrangeHex,
            RedPinkHex,
            BabyBlueHex,
            LightGreenHex,
        )
        fun getColor() = colors.random()

    }
}

fun NoteEntity.toNote(): Note = Note(id, title, content, colorHex, Instant.fromEpochMilliseconds(created).toLocalDateTime(
    TimeZone.currentSystemDefault()))
