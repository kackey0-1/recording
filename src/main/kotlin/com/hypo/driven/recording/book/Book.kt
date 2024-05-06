package com.hypo.driven.recording.book

import java.time.Instant

class Book(
  var id: Long? = null,
  var title: String,
  var createdAt: Instant = Instant.now(),
  var updatedAt: Instant = Instant.now(),
)
