package com.asysbang.pmvn.test.action;

import com.asysbang.pmvn.util.Log;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class TestRightKeyAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Log.d("TestRightKeyAction");
    }



    @Override
    public void beforeActionPerformedUpdate(@NotNull AnActionEvent e) {
        super.beforeActionPerformedUpdate(e);
        VirtualFile file = DataKeys.VIRTUAL_FILE.getData(e.getDataContext());
        VirtualFile[] children = file.getChildren();
        for (VirtualFile child : children) {
            Log.d(child.getName());
            if ("build.gradle".equals(child.getName())) {
                Log.d("find gradle");
                return;
            }
        }
        Log.d("setEnabled false");
        this.getTemplatePresentation().setEnabledAndVisible(false);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        Log.d("update");
        VirtualFile file = DataKeys.VIRTUAL_FILE.getData(e.getDataContext());
        VirtualFile[] children = file.getChildren();
        for (VirtualFile child : children) {
            Log.d(child.getName());
            if ("build.gradle".equals(child.getName())) {
                Log.d("find gradle");
                e.getPresentation().setVisible(true);
                return;
            }
        }
        Log.d("setEnabled false");
        e.getPresentation().setVisible(false);
    }
}
