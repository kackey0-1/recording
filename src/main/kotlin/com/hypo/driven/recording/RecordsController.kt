package com.hypo.driven.recording

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate


@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class RecordsController {

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
  fun postRecord(): Int {
    return 1001
  }
}
