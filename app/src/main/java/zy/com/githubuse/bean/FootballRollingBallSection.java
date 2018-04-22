package zy.com.githubuse.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * ================================================
 * 作    者：Luffy（张阳）
 * 版    本：1.0
 * 创建日期：2018/4/21
 * 描    述：滚球Section
 * 修订历史：
 * ================================================
 */
public class FootballRollingBallSection extends SectionEntity<FootballRollingBallBean> {
    public FootballRollingBallSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public FootballRollingBallSection(FootballRollingBallBean t) {
        super(t);
    }
}
