package com.asysbang.pmvn.test.action.module;

import com.asysbang.pmvn.util.Log;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private ModuleParserInterface mParser;

    private VirtualFile mRemoteModules;

    private Runnable remoteLoadingRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                InputStream is = mRemoteModules.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb =new StringBuilder();
                String line = null;
                while ((line = br.readLine())!=null) {
                    sb.append(line);
                    //Log.d(line);
                }
                mModuleCache =  mParser.parserModules(sb.toString());
                isLoaded = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    private  List<ModuleInfo> mModuleCache;
    private boolean isLoaded;

    private ModuleManager() {
        mParser = new ModuleParserImpl();
        mModuleCache = new ArrayList<ModuleInfo>();
        isLoaded = false;
    }

    public static ModuleManager getInstance() {
        return Holder.sInt;
    }

    public boolean loadModules() {
        Log.d("loadModules");
        mRemoteModules = VirtualFileManager.getInstance().findFileByUrl(ModuleConfig.REMOTE_MODULES);
        mRemoteModules.refresh(true,false, remoteLoadingRunnable);
        return false;
    }

    private void checkLocalState() {

    }

    public boolean isLoaded() {
        return isLoaded;
    }
    public List<ModuleInfo> getModules() {
        return mModuleCache;
    }

    private static class Holder {
        private static ModuleManager sInt = new ModuleManager();
    }


}
