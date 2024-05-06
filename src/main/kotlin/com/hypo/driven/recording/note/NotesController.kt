package com.hypo.driven.recording.note

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class NotesController(
  private val noteRepository: NoteRepository
) {

  @GetMapping("/api/notes")
  fun fetchNotes(): List<Note> {
    return noteRepository.findAll()
  }

  @PostMapping("/api/note")
  fun postNote(@RequestBody form: NoteForm) : Int {
    val note = Note(
      title = form.title,
      body = form.body,
    )
    noteRepository.save(note)
    return note.id!!
  }
}
