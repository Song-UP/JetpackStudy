package com.song.songup.room.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/16 14:58
 * 修改备注：
 */
public class WordViewModle extends AndroidViewModel {
    private LiveData<List<Word>> mAllWord;
    private WordRepository wordRepository;

    public WordViewModle(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        mAllWord = wordRepository.getmAllWords();
    }



    public LiveData<List<Word>> getmAllWord(){
        return mAllWord;
    }

    public WordRepository getWordRepository() {
        return wordRepository;
    }

    public void insert(Word word){
        wordRepository.insert(word);
    }


}
