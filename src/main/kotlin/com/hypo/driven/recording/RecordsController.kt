package com.hypo.driven.recording

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class RecordsController {

  @PostMapping("/api/record")
  fun postRecord(): Int {
    return 1001
  }
}
