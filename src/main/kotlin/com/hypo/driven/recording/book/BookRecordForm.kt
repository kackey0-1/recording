package com.hypo.driven.recording.book

import java.time.LocalDate

data class BookRecordForm(
  val title: String,
  val readDate: LocalDate?,
)

