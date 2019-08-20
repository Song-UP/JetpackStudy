package com.song.songup.room.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/16 9:33
 * 修改备注：创建Entry,一个entry对应一个表
 */
@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "word")
    private String word;

    public Word(@NonNull String word) {
        this.word = word;
    }

    @NonNull
    public String getWord() {
        return word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }


    @Override
    public String toString() {
        return word;
    }
}
