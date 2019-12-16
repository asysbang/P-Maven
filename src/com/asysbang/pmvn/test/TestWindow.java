package com.asysbang.pmvn.test;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class TestWindow implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentManager contentManager = toolWindow.getContentManager();
        Content content = contentManager.getFactory().createContent(new MyPanel(), "1111", true);
        Content content1 = contentManager.getFactory().createContent(new MyPanel1(), "2222", true);
        contentManager.addContent(content);
        contentManager.addContent(content1);
    }

    private class MyPanel extends JPanel {
        public MyPanel() {
            this.setBackground(Color.BLUE);
        }
    }

    private class MyPanel1 extends JPanel {
        public MyPanel1() {
            this.setBackground(Color.GRAY);
        }
    }


}
