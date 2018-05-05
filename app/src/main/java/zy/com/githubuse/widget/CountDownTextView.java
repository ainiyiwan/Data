package zy.com.githubuse.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * ================================================
 * 作    者：Luffy（张阳）
 * 版    本：1.0
 * 创建日期：2018/5/5
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CountDownTextView extends TextView {

    private CountDownTimer timer = new CountDownTimer(5000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            setTextColor(Color.parseColor("#333333"));
        }
    };

    public CountDownTextView(Context context) {
        super(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setTextColor(int color) {
        super.setTextColor(color);
        if (timer != null) {
            timer.cancel();
        }
        if (timer != null){
            timer.start();
        }
    }
}
