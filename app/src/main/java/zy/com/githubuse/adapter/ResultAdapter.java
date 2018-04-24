package zy.com.githubuse.adapter;

import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zy.com.githubuse.R;
import zy.com.githubuse.bean.FootballResultBean;

/**
 * Created by PC on 2018/4/22.
 */

public class ResultAdapter extends BaseQuickAdapter<FootballResultBean, BaseViewHolder> {
    public ResultAdapter(int layoutResId, @Nullable List<FootballResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FootballResultBean item) {
        helper.setText(R.id.gid, "GID:"+item.gid);
        TextView homeTextView = helper.getView(R.id.home_score);
        int text = 0;
        if (!TextUtils.isEmpty(homeTextView.getText())) {
            text = Integer.parseInt(homeTextView.getText().toString());
        }
        int text1 = Integer.parseInt(item.hscore);
        if (text < text1) {
            homeTextView.setText(Html.fromHtml("<font color='#ff0000'>"+ item.hscore + "</font>"));
        } else {
            homeTextView.setText(Html.fromHtml("<font color='#00ff00'>"+ item.hscore + "</font>"));
        }


        TextView awayTextView = helper.getView(R.id.away_score);
        int atext = 0;
        if (!TextUtils.isEmpty(awayTextView.getText())) {
            atext = Integer.parseInt(awayTextView.getText().toString());
        }
        int atext1 = Integer.parseInt(item.hscore);
        if (atext < atext1) {
            awayTextView.setText(Html.fromHtml("<font color='#ff0000'>"+ item.vscore + "</font>"));
        } else {
            awayTextView.setText(Html.fromHtml("<font color='#00ff00'>"+ item.vscore + "</font>"));
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
