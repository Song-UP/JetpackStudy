package com.song.songup.room.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/16 9:33
 * 修改备注：创建Entry,一个entry对应一个表
 * 表示该表User对象则包含以下名称的列：word，和post_code。
 */
@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "word")
    public String word;

    @Embedded
    public SubWord subWord;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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


    public class SubWord{
        public String street;
        @ColumnInfo(name = "post_code") public int postCode;
    }

}
