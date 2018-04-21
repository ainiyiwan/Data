package zy.com.githubuse;

import com.google.gson.reflect.TypeToken;
import com.qncb.sportApp.bean.socker.FootballResultBean;
import com.qncb.sportApp.http.callback.Convert;

import java.util.HashMap;
import java.util.List;

/**
 * ================================================
 * 作    者：Luffy（张阳）
 * 版    本：1.0
 * 创建日期：2018/4/20
 * 描    述：足球赛果数据处理
 * 修订历史：
 * ================================================
 */

public class FootballResultDataHelper {

    private static volatile FootballResultDataHelper singleton;
    private HashMap<String, List<FootballResultBean>> map;

    private FootballResultDataHelper() {
    }

    public static FootballResultDataHelper getInstance() {
        if (singleton == null) {
            synchronized (FootballResultDataHelper.class) {
                if (singleton == null) {
                    singleton = new FootballResultDataHelper();
                }
            }
        }
        return singleton;
    }

    /**
     * 设置数据
     * @param data 数据
     */
    public void setData(Object data) {
        String json = Convert.toJson(data);
        map = Convert.fromJson(json, new TypeToken<HashMap<String,List<FootballResultBean>>>(){}.getType());
    }


    /**
     * 获取筛选数据
     * @param selectDate 日期
     */
    public List<FootballResultBean> getData(String selectDate) {
        return map.get(selectDate);
    }
}