package com.caryguan.markbook.Processor;

import com.caryguan.markbook.data.NoteData;

import java.util.List;

/**
 * @Author GuanCary
 * @Date 2020/7/8 20:48
 * @Version 1.0
 **/
public class DefaultSourceNoteData implements SourceNoteData {
    private String fileName;
    private String topic;
    private List<NoteData> noteList;

    public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteList = noteList;
    }

    @Override
    public String fileName() {
        return fileName;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<NoteData> getNoteList() {
        return noteList;
    }
}