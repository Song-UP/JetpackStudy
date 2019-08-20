package com.song.songup.databinding_study.view_data;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/7/18 12:27
 * 修改备注：
 */
public class User {

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
