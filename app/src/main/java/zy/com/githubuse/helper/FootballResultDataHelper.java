package zy.com.githubuse.helper;

import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zy.com.githubuse.bean.FootballResultBean;

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
    private List<FootballResultBean> list;
    //key为gid
//    private Map<String, FootballResultBean> map = new HashMap<>();
    private Map<String, Integer> mapPosition = new HashMap<>();

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
     * @param list 数据
     */
    public void setData(List<FootballResultBean> list) {
        long startTime=System.currentTimeMillis();   //获取开始时间
        this.list = list;

        //初始化map
        for (int i = 0; i < list.size(); i++) {
//            map.put(list.get(i).gid, list.get(i));
            mapPosition.put(list.get(i).gid, i);
        }

        long endTime=System.currentTimeMillis(); //获取结束时间
        getTime(startTime, endTime);
    }


    /**
     * 获取筛选数据
     */
    public List<FootballResultBean> getData() {
        return list;
    }

    /**
     * 更新数据
     */
    public int updateData(FootballResultBean bean) {
        //获取开始时间
        long startTime=System.nanoTime();

        String gid = bean.gid;
        if (mapPosition.containsKey(gid)) {
            long endTime1=System.nanoTime();
            getTime(startTime, endTime1);
            return mapPosition.get(gid);
        }
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        getTime(startTime, endTime);
        return -1;
    }

    private void getTime(long startTime, long endTime) {
        long times = endTime - startTime;
//        System.out.println("程序运行时间： "+String.valueOf(times)+"ms");
        Log.i("TAG", "程序运行时间： "+String.valueOf(times)+"ns");
    }
}