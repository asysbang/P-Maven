package com.asysbang.pmvn.test.action;

import com.asysbang.pmvn.util.Log;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.Charset;

public class TestGradleAction extends AnAction {
    Project mProject;
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Log.d("TestGradleAction");
        mProject = anActionEvent.getProject();
        exeGradleVersion();
    }

    //export PATH=/usr/lib/jvm/java-8-oracle/bin:$PATH
    //export PATH=/home/karl/.gradle/wrapper/dists/gradle-4.6-all/bcst21l2brirad8k2ben1letg/gradle-4.6/bin:$PATH
    //assembleDebug

    private void exeGradleVersion() {
        GeneralCommandLine cmd = new GeneralCommandLine("sh", "-c","touch a.txt");
        cmd.setWorkDirectory(mProject.getBasePath());
        try {
            ProcessHandler processHandler  = new OSProcessHandler(cmd);
            processHandler.startNotify();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
