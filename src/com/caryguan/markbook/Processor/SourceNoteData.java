package com.caryguan.markbook.Processor;

import com.caryguan.markbook.data.NoteData;

import java.util.List;

public interface SourceNoteData {
    public String fileName();

    public String getTopic();

    public List<NoteData> getNoteList();
}
