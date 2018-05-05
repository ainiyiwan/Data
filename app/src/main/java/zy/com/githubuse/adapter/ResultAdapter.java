package zy.com.githubuse.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zy.com.githubuse.R;
import zy.com.githubuse.bean.FootballResultBean;
import zy.com.githubuse.widget.CountDownTextView;

/**
 * Created by PC on 2018/4/22.
 */

public class ResultAdapter extends BaseQuickAdapter<FootballResultBean, BaseViewHolder> {
    public ResultAdapter(int layoutResId, @Nullable List<FootballResultBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, final FootballResultBean item) {
        helper.setText(R.id.gid, "GID:"+item.gid);
        CountDownTextView homeTextView = helper.getView(R.id.home_score);
        int text = 0;
        if (!TextUtils.isEmpty(homeTextView.getText())) {
            text = Integer.parseInt(homeTextView.getText().toString());
        }
        int position = helper.getAdapterPosition();

        int text1 = Integer.parseInt(item.hscore);
        if (text < text1) {
//            homeTextView.setText(Html.fromHtml("<font color='#ff0000'>"+ item.hscore + "</font>"));
            homeTextView.setText(item.hscore);
            homeTextView.setTextColor(Color.parseColor("#ff0000"));
        } else {
//            homeTextView.setText(Html.fromHtml("<font color='#00ff00'>"+ item.hscore + "</font>"));
            homeTextView.setText(item.hscore);
            homeTextView.setTextColor(Color.parseColor("#00ff00"));
        }


        CountDownTextView awayTextView = helper.getView(R.id.away_score);
        int atext = 0;
        if (!TextUtils.isEmpty(awayTextView.getText())) {
            atext = Integer.parseInt(awayTextView.getText().toString());
        }
        int atext1 = Integer.parseInt(item.hscore);
        if (atext < atext1) {
//            awayTextView.setText(Html.fromHtml("<font color='#ff0000'>"+ item.vscore + "</font>"));
            awayTextView.setText(item.vscore);
            awayTextView.setTextColor(Color.parseColor("#ff0000"));
        } else {
//            awayTextView.setText(Html.fromHtml("<font color='#00ff00'>"+ item.vscore + "</font>"));
            awayTextView.setText(item.vscore);
            awayTextView.setTextColor(Color.parseColor("#00ff00"));
        }

        CheckBox checkBox = helper.getView(R.id.checkbox);
        if (item.isChecked) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        helper.addOnClickListener(R.id.checkbox);

    }
}
