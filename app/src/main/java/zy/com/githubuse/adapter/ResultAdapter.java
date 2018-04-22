package zy.com.githubuse.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;

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
        helper.setText(R.id.home_score, item.hscore);
        helper.setText(R.id.away_score, item.vscore);
        CheckBox checkBox = helper.getView(R.id.checkbox);
        if (item.isChecked) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        helper.addOnClickListener(R.id.checkbox);

    }
}
