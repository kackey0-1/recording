package com.hypo.driven.recording

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class BookRecordsResponse(
  val bookId: Long,
  val title: String,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  val readDate: LocalDate,
  val amount: Int,
)
