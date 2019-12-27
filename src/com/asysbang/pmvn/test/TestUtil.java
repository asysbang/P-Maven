package com.asysbang.pmvn.test;

import com.asysbang.pmvn.bean.MoInfo;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<MoInfo> mockMoInfoList() {

        MoInfo[] infos  = new MoInfo[10];
        infos[0] = new MoInfo("gson","28",13,3,"");
        infos[1] = new MoInfo("grpc","28",1,3,"");
        infos[2] = new MoInfo("lint","28",3,3,"");
        infos[3] = new MoInfo("wifi","28",11,3,"");
        infos[4] = new MoInfo("bluetooth","28",5,3,"");
        infos[5] = new MoInfo("event_bus","28",7,3,"");
        infos[6] = new MoInfo("xml","28",9,3,"");
        infos[7] = new MoInfo("media","28",10,3,"");
        infos[8] = new MoInfo("hidl","28",3,3,"");
        infos[9] = new MoInfo("jni","28",2,3,"");

        List<MoInfo> mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(infos[i]);
        }
        return mList;
    }
}
