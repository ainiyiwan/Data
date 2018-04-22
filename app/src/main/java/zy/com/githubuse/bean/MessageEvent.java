package zy.com.githubuse.bean;

/**
 * Created by PC on 2018/4/22.
 */

public class MessageEvent<T> {
    public String type;
    public T data;

    public MessageEvent(String type, T data) {
        this.type = type;
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
