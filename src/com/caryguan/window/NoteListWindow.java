package com.caryguan.window;

import com.caryguan.markbook.data.DataCenter;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.util.messages.Topic;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @Author GuanCary
 * @Date 2020/7/8 16:58
 * @Version 1.0
 **/
public class NoteListWindow {
    private JTextField tfTopic;
    private JTable tbContent;
    private JButton btnCreate;
    private JButton btnClear;
    private JButton btnClose;
    private JPanel contentPanel;

    private void init() {
        tbContent.setModel(DataCenter.TABLE_MODEL);
        tbContent.setEnabled(true);
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //选择目录,生成文档
                //直接获取标题
                String topic = tfTopic.getText();
                String fileName = topic + ".md";
                if (tfTopic == null || "".equals(topic)) {
                    //信息对话框
                    MessageDialogBuilder.yesNo("操作结果", "文档标题没有输入");
                    return;
                }
                VirtualFile virtualFile =
                        FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project,
                                project.getBaseDir());
                if (virtualFile != null) {
                    //得到文件路径
                    String path = virtualFile.getPath();
                    //设置window下文件路径
                    String fileFullPath = path + "/" + fileName;
                }

            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}