package com.example.wechatmoments.data.entity;

public class Sender {
    private String userName;
    private String nick;
    private String avatar;

    public Sender() {
    }

    public Sender(String userName, String nick, String avatar) {
        this.userName = userName;
        this.nick = nick;
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public Sender setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public Sender setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public Sender setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }
}
