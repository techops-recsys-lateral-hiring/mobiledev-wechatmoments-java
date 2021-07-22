package com.example.wechatmoments.data.entity;

import com.google.gson.annotations.SerializedName;


public class User {
    @SerializedName("profile-image")
    private String profileImage;
    private String avatar;
    private String nick;
    private String username;

    public User() {
    }

    public User(String profileImage, String avatar, String nick, String userName) {
        this.profileImage = profileImage;
        this.avatar = avatar;
        this.nick = nick;
        this.username = userName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public User setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    public String getAvator() {
        return avatar;
    }

    public User setAvator(String avator) {
        this.avatar = avator;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public User setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public String getUserName() {
        return username;
    }

    public User setUserName(String userName) {
        this.username = userName;
        return this;
    }

    @Override
    public String toString() {
        return "User.userName " + username + "User.profileImage" + profileImage + "avator" + avatar + "nick" + nick;
    }
}
