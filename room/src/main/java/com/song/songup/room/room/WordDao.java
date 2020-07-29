package com.song.songup.room.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/16 9:43
 * 修改备注：即数据访问接口。可以将SQL查询语句与方法相关联。
 *
 * DAO必须是接口或抽象类。
 * 默认情况下，所有查询必须在独立的线程。
 */
@Dao
public interface WordDao  {
    @Insert
    void insert(Word word);

    @Insert
    void insertAll(List<Word> word);

    @Delete
    void delete(Word word);

//    LiveData 用于实时更新数据，类似观察者
    @Query("select * from word_table order by word asc")
    LiveData<List<Word>> queryAll();

    @Query("select * from word_table where word == :myWord order by word asc")
    LiveData<List<Word>> queryPart(String myWord);

    @Query("select * from word_table where word == :myWord order by word asc")
    LiveData<List<Word>> queryPart(Word myWord);


//    LiveData是可以被观察到的数据持有类。它里面缓存或持有了最新的数据。
//    当数据改变时会通知它的观察者。LiveData是可以感知生命周期的。UI组件只是观察相关数据，不会停止或恢复观察。
//    LiveData自动管理所有这些，因为它在观察时意识到相关的生命周期状态变化。
//    liveData当数据发生变化时，立刻通知

    @Query("delete from word_table")
    void deleteAll();

}
