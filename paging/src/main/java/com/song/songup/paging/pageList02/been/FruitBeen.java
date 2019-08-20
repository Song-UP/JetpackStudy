package com.song.songup.paging.pageList02.been;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/14 19:25
 * 修改备注：
 */
public class FruitBeen {
    private String name;
    private int image;
    private int id;

    public FruitBeen() {
    }

    public FruitBeen(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "name="+name+",number="+image+",id="+id;
    }

    public boolean equals(FruitBeen obj) {
        if (obj != null && obj.toString().equals(this.toString()))
            return true;

        return false;
    }
}
