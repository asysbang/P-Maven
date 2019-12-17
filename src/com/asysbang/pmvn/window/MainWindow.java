package com.asysbang.pmvn.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import org.jetbrains.annotations.NotNull;

public class MainWindow implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        Content remote = toolWindow.getContentManager().getFactory().createContent(new RemoteModulePanel(), "", true);
        toolWindow.getContentManager().addContent(remote);
    }
}
