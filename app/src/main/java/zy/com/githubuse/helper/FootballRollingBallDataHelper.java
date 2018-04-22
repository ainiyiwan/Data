package zy.com.githubuse.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zy.com.githubuse.bean.FootballRollingBallBean;
import zy.com.githubuse.bean.FootballRollingBallSection;

/**
 * ================================================
 * 作    者：Luffy（张阳）
 * 版    本：1.0
 * 创建日期：2018/4/20
 * 描    述：足球滚球数据处理
 * 修订历史：
 * ================================================
 */

public class FootballRollingBallDataHelper {

    private static volatile FootballRollingBallDataHelper singleton;
    private HashMap<String, List<FootballRollingBallBean>> map;
    private Map<String, Integer> mapPosition = new HashMap<>();

    private String score = "score";
    private String schedule = "schedule";
    private String matchend = "matchend";


    private List<FootballRollingBallSection> list = new ArrayList<>();

    private FootballRollingBallDataHelper() {
    }

    public static FootballRollingBallDataHelper getInstance() {
        if (singleton == null) {
            synchronized (FootballRollingBallDataHelper.class) {
                if (singleton == null) {
                    singleton = new FootballRollingBallDataHelper();
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
//        String json = Convert.toJson(data);
//        map = Convert.fromJson(json, new TypeToken<HashMap<String,List<FootballRollingBallBean>>>(){}.getType());
    }


    /**
     * 获取筛选数据
     */
    public List<FootballRollingBallSection> getData() {
        List<FootballRollingBallBean> scoreList = map.get(score);
        List<FootballRollingBallBean> scheduleList = map.get(schedule);
        List<FootballRollingBallBean> matchendList = map.get(matchend);
        for (int i = 0; i < scoreList.size(); i++) {
            list.add(new FootballRollingBallSection(scoreList.get(i)));
        }

        for (int i = 0; i < scheduleList.size(); i++) {
            list.add(new FootballRollingBallSection(scheduleList.get(i)));
        }

        if (matchendList.size() > 0){
            list.add(new FootballRollingBallSection(true, "已完场"));
        }

        for (int i = 0; i < matchendList.size(); i++) {
            list.add(new FootballRollingBallSection(matchendList.get(i)));
        }

        //初始化map
        for (int i = 0; i < list.size(); i++) {
            boolean isHeader = list.get(i).isHeader;
            if (!isHeader) {
                FootballRollingBallBean ballBean = list.get(i).t;
                mapPosition.put(ballBean.gid, i);
            } else {
                mapPosition.put("header", i);
            }
        }

        return list;
    }
}