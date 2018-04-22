package zy.com.githubuse.bean;

import java.io.Serializable;

/**
 * ================================================
 * 作    者：Luffy（张阳）
 * 版    本：1.0
 * 创建日期：2018/4/20
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class FootballResultBean implements Serializable {
    private static final long serialVersionUID = -8995875828189927495L;

    public String gid;
    public String vscore;
    public String hscore;
    public boolean isChecked;

    public FootballResultBean(String gid, String vscore, String hscore, boolean isChecked) {
        this.gid = gid;
        this.vscore = vscore;
        this.hscore = hscore;
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "FootballResultBean{" +
                "gid='" + gid + '\'' +
                ", vscore='" + vscore + '\'' +
                ", hscore='" + hscore + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}
