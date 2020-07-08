package com.caryguan.markbook.data;

/**
 * @Author GuanCary
 * @Date 2020/7/8 17:43
 * @Version 1.0
 **/
public class DataConvert {
    public static String[] convert(NoteData noteData) {
        String[] raw = new String[4];
        //标题
        raw[0] = noteData.getTitle();
        //备注
        raw[1] = noteData.getMark();
        //文件名
        raw[2] = noteData.getFileName();
        //代码段
        raw[3] = noteData.getContent();
        return raw;
    }
}