package com.caryguan.markbook.action;

import com.caryguan.markbook.data.DataCenter;
import com.caryguan.markbook.dialog.AddNoteDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        //根据传入事件获取内容
        Editor requiredData = e.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = requiredData.getSelectionModel();
        //选中的内容
        String selectedText = selectionModel.getSelectedText();
        //把选中内容赋值
        DataCenter.SELECT_TEXT = selectedText;
        System.out.println(selectedText);
        //得到虚拟文件名
        String name = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.FILE_NAME = name;
        AddNoteDialog addNotDialog = new AddNoteDialog();
        //展示对话框
        addNotDialog.show();
    }
}
