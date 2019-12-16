package com.asysbang.pmvn;

import com.asysbang.pmvn.util.Log;
import com.intellij.openapi.components.ProjectComponent;

import java.io.File;

public class MainApp implements ProjectComponent {

    @Override
    public void initComponent() {
        verifyRootDir();
    }

    //不确定触发条件
    @Override
    public void projectOpened() {

    }

    @Override
    public void projectClosed() {

    }


    /**
     * verify plugin root dir
     */
    private void verifyRootDir() {
        String root = System.getProperty("user.home");
        Log.d("verifyRootDir");
        File rootDir = new File(root + "/.asysbang/.");
        if (!rootDir.exists()) {
            rootDir.mkdirs();
        }
    }
}
