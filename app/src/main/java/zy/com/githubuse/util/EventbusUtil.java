package zy.com.githubuse.util;

import org.greenrobot.eventbus.EventBus;

import zy.com.githubuse.bean.EventType;
import zy.com.githubuse.bean.MessageEvent;

/**
 * ================================================
 * 作    者：Luffy（张阳）
 * 版    本：1.0
 * 创建日期：2018/4/24
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class EventbusUtil {
    public static void sendMessage() {
        MessageEvent event = new MessageEvent(EventType.UTIL);
        EventBus.getDefault().post(event);
    }
}
