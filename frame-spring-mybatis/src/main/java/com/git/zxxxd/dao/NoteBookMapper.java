package com.git.zxxxd.dao;

import com.git.zxxxd.entity.NoteBook;

import java.util.List;

public interface NoteBookMapper {
    List<NoteBook> selectAll();
    void insertAll(NoteBook noteBook);
    void deleteById(String id);
}
