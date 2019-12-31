package com.asysbang.pmvn.test.action;

import com.asysbang.pmvn.util.Log;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;


//  https://raw.githubusercontent.com/asysbang/P-Maven-Modules/master/deploy/media.zip
//  https://raw.githubusercontent.com/asysbang/P-Maven-Modules/master/deploy/ui.zip
//  https://raw.githubusercontent.com/asysbang/P-Maven-Modules/master/deploy/wifi.zip
//  https://raw.githubusercontent.com/asysbang/P-Maven-Modules/master/deploy/modules.json

public class TestDownloadAction extends AnAction {

    private final String CONFIG_FILE = "https://raw.githubusercontent.com/asysbang/P-Maven-Modules/master/deploy/modules.json";
    private final String MEDIA_FILE = "https://raw.githubusercontent.com/asysbang/P-Maven-Modules/master/deploy/media.zip";

    private VirtualFile mRemoteFile;

    private VirtualFile mZipFile;

    private Runnable configRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                InputStream is = mRemoteFile.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line =null;
                while ((line = br.readLine())!=null) {
                    Log.d(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable zipRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                String root = System.getProperty("user.home");
                //注意不支持 ~/.asysbang这种写法
                File outFile = new File(root+"/.asysbang/media.zip");
                if (outFile.exists()) {
                    outFile.delete();
                }
                outFile.createNewFile();
                OutputStream os = new FileOutputStream(outFile);
                InputStream is = mZipFile.getInputStream();
                byte[] buf = new byte[1024*4];
                int length = -1;
                while ((length = is.read(buf))!=-1) {
                    os.write(buf,0,length);

                }
                os.flush();
                os.close();
                is.close();
                Log.d("zip over");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * 测试读取配置文件
     */
    private void readConfigFile() {
        mRemoteFile = VirtualFileManager.getInstance().findFileByUrl(CONFIG_FILE);
        mRemoteFile.refresh(true,false, configRunnable);
    }


    private void readZipFile() {
        mZipFile = VirtualFileManager.getInstance().findFileByUrl(MEDIA_FILE);
        mZipFile.refresh(true,true, zipRunnable);
    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        readConfigFile();
//          readZipFile();
    }
}
