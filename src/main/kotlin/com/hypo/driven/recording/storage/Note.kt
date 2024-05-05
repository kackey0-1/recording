package com.hypo.driven.recording.storage

import com.hypo.driven.recording.NoArg
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@NoArg
@Entity
@Table(name = "notes")
class Note(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int? = null,
  @Column(name = "title", nullable = false)
  var title: String?,
  @Column(name = "body", nullable = false)
  var body: String?,
  @Column(name = "created_at")
  var createdAt: Instant = Instant.now(),
  @Column(name = "updated_at")
  var updatedAt: Instant = Instant.now(),
) {
  constructor() : this(null, null, null)
}

