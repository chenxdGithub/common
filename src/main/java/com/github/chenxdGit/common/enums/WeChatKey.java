package com.github.chenxdGit.common.enums;

public enum WeChatKey {

    sendTemplateMsgUrl("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={access_token}","发送模板消息url"),
    getOATokenUrl("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}","获取公众号tokenurl");

    private  String remake;
    private  String value;
    WeChatKey(String value, String remake) {
        this.remake = remake;
        this.value = value;
    }
    public String value() {
        return this.value;
    }
    public String remake() {
        return this.remake;
    }
}
