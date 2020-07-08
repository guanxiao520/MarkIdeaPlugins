package com.caryguan.markbook.dialog;

import com.caryguan.markbook.data.DataCenter;
import com.caryguan.markbook.data.DataConvert;
import com.caryguan.markbook.data.NoteData;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import javafx.scene.control.Button;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.crypto.Data;
import java.awt.*;

/**
 * @Author GuanCary
 * @Date 2020/7/8 10:24
 * @Version 1.0
 **/
public class AddNoteDialog extends DialogWrapper {
    public AddNoteDialog() {
        super(true);
        setTitle("添加笔记注释");
        init();
    }

    private EditorTextField tfTitle = null;
    private EditorTextField tfMark = null;

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        //idea有不推荐swing包
        tfTitle = new EditorTextField("笔记标题");
        tfMark = new EditorTextField("笔记内容");
        tfMark.setPreferredSize(new Dimension(200, 100));
        //将标题放在最上边
        jPanel.add(tfTitle, BorderLayout.NORTH);
        //将内容放入中间
        jPanel.add(tfMark, BorderLayout.CENTER);
        return jPanel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("添加笔记到列表");
        jButton.addActionListener(e -> {
            //得到用户输出的文本作为笔记的标题
            String title = tfTitle.getText();
            String mark = tfMark.getText();
            String filetype
                    = DataCenter.FILE_NAME.substring(DataCenter.FILE_NAME.lastIndexOf(".") + 1);
            NoteData noteData = new NoteData(title, mark, DataCenter.SELECT_TEXT, DataCenter.FILE_NAME, filetype);
            //添加笔记所有数据
            DataCenter.NOTE_LIST.add(noteData);
            System.out.println(DataCenter.NOTE_LIST);
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
        });
        jPanel.add(jButton);
        return jPanel;
    }
}