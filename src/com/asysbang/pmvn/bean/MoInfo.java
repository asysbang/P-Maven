package com.asysbang.pmvn.bean;


/**
 * model 信息 实体类
 */
public class MoInfo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String api;
    private int version;
    private int state;
    private String url;


    public MoInfo(String name, String api, int version, int state, String url) {
        this.name = name;
        this.api = api;
        this.version = version;
        this.state = state;
        this.url = url;
    }
}
