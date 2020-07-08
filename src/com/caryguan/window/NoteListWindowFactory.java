package com.caryguan.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @Author GuanCary
 * @Date 2020/7/8 17:11
 * @Version 1.0
 **/
public class NoteListWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        //首先传入参数构建一个noteListWindow的对象
        NoteListWindow noteListWindow = new NoteListWindow(project, toolWindow);
        //获取内容工厂的实例
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        //根据工厂实例初始化一个内容对象
        Content content = contentFactory.createContent(noteListWindow.getContentPanel(), "", false);
        //将该对象加入toolWindow
        toolWindow.getContentManager().addContent(content);
    }
}