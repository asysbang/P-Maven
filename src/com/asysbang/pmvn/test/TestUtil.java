package com.asysbang.pmvn.test;

import com.asysbang.pmvn.test.action.module.ModuleInfo;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<ModuleInfo> mockMoInfoList() {

        ModuleInfo[] infos  = new ModuleInfo[10];
        infos[0] = new ModuleInfo("gson","28",13,3,"");
        infos[1] = new ModuleInfo("grpc","28",1,3,"");
        infos[2] = new ModuleInfo("lint","28",3,3,"");
        infos[3] = new ModuleInfo("wifi","28",11,3,"");
        infos[4] = new ModuleInfo("bluetooth","28",5,3,"");
        infos[5] = new ModuleInfo("event_bus","28",7,3,"");
        infos[6] = new ModuleInfo("xml","28",9,3,"");
        infos[7] = new ModuleInfo("media","28",10,3,"");
        infos[8] = new ModuleInfo("hidl","28",3,3,"");
        infos[9] = new ModuleInfo("jni","28",2,3,"");

        List<ModuleInfo> mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(infos[i]);
        }
        return mList;
    }
}
