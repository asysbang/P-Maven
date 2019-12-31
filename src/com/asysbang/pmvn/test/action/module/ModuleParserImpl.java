package com.asysbang.pmvn.test.action.module;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class ModuleParserImpl implements ModuleParserInterface{

    @Override
    public List<ModuleInfo> parserModules(String jsonStr) {
        List<ModuleInfo> infos = new ArrayList<ModuleInfo>();
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObj = jsonParser.parse(jsonStr).getAsJsonObject();
        JsonArray modules = jsonObj.getAsJsonArray("modules");
        for (int i = 0;i< modules.size();i++) {
            ModuleInfo info = parserModuleElement(modules.get(i));
            infos.add(info);
        }
        return infos;
    }

    private ModuleInfo parserModuleElement(JsonElement moduleElement) {
        JsonObject obj = moduleElement.getAsJsonObject();
        ModuleInfo info = new ModuleInfo();
        info.setName(obj.get("name").getAsString());
        info.setApi(obj.get("api").getAsString());
        info.setVersion(obj.get("version").getAsInt());
        info.setUrl(obj.get("url").getAsString());
        return info;
    }
}
