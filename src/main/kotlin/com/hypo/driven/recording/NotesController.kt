package com.hypo.driven.recording

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class NotesController(
  private val noteRepository: NoteRepository
) {

  @GetMapping("/api/notes")
  fun fetchNotes(): List<Note> {
    return noteRepository.findAll()
  }

  @PostMapping("/api/note")
  fun postNote(form: NoteForm) {
    noteRepository.save(
      Note(
        title = form.title,
        body = form.body,
      ),
    )
  }
}
