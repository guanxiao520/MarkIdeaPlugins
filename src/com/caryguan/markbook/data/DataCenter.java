package com.caryguan.markbook.data;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author GuanCary
 * @Date 2020/7/8 11:09
 * @Version 1.0
 **/
public class DataCenter {
    public static String SELECT_TEXT;
    public static String FILE_NAME;
    //如果用ArrayList调整顺序很难,查询简单,会影响性能
    public static List<NoteData> NOTE_LIST = new LinkedList<>();
    public static String[] HEAD = {"标题", "备注", "文件名称", "代码段"};
    //创建一个数据模型
    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null, HEAD);

    //实现插件文档清空button功能的方法
    public static void reset() {
        NOTE_LIST.clear();
        TABLE_MODEL.setDataVector(null, HEAD);
    }
}