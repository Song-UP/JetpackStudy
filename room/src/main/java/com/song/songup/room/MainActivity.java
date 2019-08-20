package com.song.songup.room;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.song.songup.room.room.Word;
import com.song.songup.room.room.WordViewModle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRoomDatabase();
    }
    private void initView() {
        mTextview = (TextView) findViewById(R.id.textview);
        findViewById(R.id.button).setOnClickListener(this);
    }
    WordViewModle viewModel;
    public void initRoomDatabase() {
//        viewModel = new WordViewModle(getApplication());
        viewModel = ViewModelProviders.of(this).get(WordViewModle.class);
        viewModel.getmAllWord().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < words.size(); i++) {
                    stringBuffer.append(words.get(i));
                }
                mTextview.setText(stringBuffer.toString());
            }
        });
    }

    long ch = 1;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                viewModel.insert(new Word(String.valueOf(ch++)));
                break;
            default:
                break;
        }
    }
}
