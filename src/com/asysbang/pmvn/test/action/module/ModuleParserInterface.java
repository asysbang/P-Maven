package com.asysbang.pmvn.test.action.module;

import java.util.List;

public interface ModuleParserInterface {

    List<ModuleInfo> parserModules(String jsonStr);
}
