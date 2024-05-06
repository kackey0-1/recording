package com.hypo.driven.recording.book

import java.time.Instant
import java.time.LocalDate

data class BookRecord(
  var bookId: Long,
  var readDate: LocalDate,
  var createdAt: Instant = Instant.now(),
  var updatedAt: Instant = Instant.now(),
)

