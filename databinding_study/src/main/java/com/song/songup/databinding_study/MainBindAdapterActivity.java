package com.song.songup.databinding_study;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.song.songup.databinding_study.databinding.ActivityMainBindAdapterBinding;
import com.song.songup.databinding_study.model.Image;

import java.util.Random;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/3 14:22
 * 修改备注：
 */
public class MainBindAdapterActivity extends AppCompatActivity {
    private static final String TAG = "Main9Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBindAdapterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_bind_adapter);
        binding.setImage(new Image("xxxxxxx"));
        binding.setHandler(new Handler());
    }

    public class Handler {

        public void onClick(Image image) {
            image.getUrl().set("xxxxx" + new Random().nextInt(1000));
        }

    }

    @BindingAdapter({"url"})
    public static void loadImage(ImageView view, String url) {
        Log.e(TAG, "loadImage url : " + url);
    }

//    @BindingAdapter("android:text")
//    public static void setText(Button view, String text) {
//        view.setText(text + "-Button");
//    }
//
//    @BindingConversion
//    public static String conversionString(String text) {
//        return text + "-conversionString";
//    }

    @BindingConversion
    public static Drawable convertStringToDrawable(String str) {
        if (str.equals("红色")) {
            return new ColorDrawable(Color.parseColor("#FF4081"));
        }
        if (str.equals("蓝色")) {
            return new ColorDrawable(Color.parseColor("#3F51B5"));
        }
        return new ColorDrawable(Color.parseColor("#344567"));
    }

    @BindingConversion
    public static int convertStringToColor(String str) {
        if (str.equals("红色")) {
            return Color.parseColor("#FF4081");
        }
        if (str.equals("蓝色")) {
            return Color.parseColor("#3F51B5");
        }
        return Color.parseColor("#344567");
    }

}