package com.song.songup.room.room;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/16 10:13
 * SQLite数据库之上的数据库层，负责处理以前使用SQLiteOpenHelper处理的普通任务。Room数据库使用DAO查询SQLite数据库。
 */

/** 告诉数据库要创建的表以及表名 **/
@Database(entities = {Word.class}, version=1/*, exportSchema = false*/)
public abstract class WorkRoomDatabase extends RoomDatabase {
    private static volatile WorkRoomDatabase INSTANCE;

    public static WorkRoomDatabase getDatabase(Context context){
        if (INSTANCE == null){
            synchronized (WorkRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    WorkRoomDatabase.class,"work_database").
                                build();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

//    @Override
//    public void clearAllTables() {
//
//    }



    public abstract WordDao wordDao();
}
