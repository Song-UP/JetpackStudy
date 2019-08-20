package com.song.songup.room.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/16 14:04
 * 修改备注：Repository是用于管理多个数据资源，例如数据库，网络等。在这里进行异步操作
 */
public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;


    public WordRepository(Application application){
        WorkRoomDatabase workRoomDatabase = WorkRoomDatabase.getDatabase(application);
        mWordDao = workRoomDatabase.wordDao();
        mAllWords = mWordDao.queryAll();
    }

    public LiveData<List<Word>> getmAllWords(){
        return  mAllWords;
    }

    public void insert(Word word){
        new InserAsyncTask(mWordDao).execute(word);
    }

    public static class InserAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;

        public InserAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insert(words[0]);
            return null;
        }
    }

}
