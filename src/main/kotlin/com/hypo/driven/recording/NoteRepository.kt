package com.hypo.driven.recording

import com.hypo.driven.recording.storage.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : JpaRepository<Note, Int> {}
