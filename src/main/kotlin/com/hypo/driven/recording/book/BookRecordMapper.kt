package com.hypo.driven.recording.book

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface BookRecordMapper {

  @Select("""
    INSERT INTO books SET
    title = #{title},
  """)
  fun insert(book: Book)

  @Select("""
    INSERT INTO book_records SET
    title = #{title},
    read_date = #{readDate}
  """)
  fun createRecord(record: BookRecord)
}
