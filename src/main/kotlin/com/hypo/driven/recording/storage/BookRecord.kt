package com.hypo.driven.recording.storage

import com.hypo.driven.recording.NoArg
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.time.LocalDate
import java.util.Date

@NoArg
@Entity
@Table(name = "book_records")
class BookRecord(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int? = null,
  @Column(name = "title", nullable = false)
  var bookId: Long,
  @Column(name = "body", nullable = false)
  var readDate: LocalDate,
  @Column(name = "created_at")
  var createdAt: Instant = Instant.now(),
  @Column(name = "updated_at")
  var updatedAt: Instant = Instant.now(),
) {
  constructor() : this(null, 0L, LocalDate.now())
}

