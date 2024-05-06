package com.hypo.driven.recording.book

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate


@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class BookRecordsController(
  private val bookRecordMapper: BookRecordMapper,
) {

  @GetMapping("/api/records")
  fun getRecords(): List<BookRecordsResponse> {
    return listOf(
      BookRecordsResponse(1L, "aaa", LocalDate.of(2024, 4, 1), 1),
      BookRecordsResponse(2L, "bbb", LocalDate.of(2024, 4, 2), 2),
      BookRecordsResponse(3L, "ccc", LocalDate.of(2024, 4, 3), 3),
      BookRecordsResponse(4L, "ddd", LocalDate.of(2024, 4, 4), 4),
      BookRecordsResponse(5L, "eee", LocalDate.of(2024, 4, 5), 5),
    )
  }

  @PostMapping("/api/record")
  fun postRecord(@RequestBody form: BookRecordForm): ResponseEntity<Unit> {
    val book = Book(title = form.title)
    bookRecordMapper.insert(book)
    form.readDate?.let {
      bookRecordMapper.createRecord(BookRecord(bookId = book.id!!, readDate = it))
    }
    return ResponseEntity(HttpStatus.CREATED)
  }
}
