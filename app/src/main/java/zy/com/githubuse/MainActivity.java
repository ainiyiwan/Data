package zy.com.githubuse;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zy.com.githubuse.adapter.ResultAdapter;
import zy.com.githubuse.bean.EventType;
import zy.com.githubuse.bean.FootballResultBean;
import zy.com.githubuse.bean.MessageEvent;
import zy.com.githubuse.helper.FootballResultDataHelper;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.jump)
    Button jump;
    @BindView(R.id.send)
    Button send;
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    private List<FootballResultBean> list = new ArrayList<>();
    private ResultAdapter adapter;
    private String TAG = MainActivity.class.getSimpleName();
    private int gid = 10000;


    private static final long HEART_BEAT_RATE = 10;

    @SuppressLint("HandlerLeak")
    private Handler uiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            gid = gid + 1;
            FootballResultBean bean = new FootballResultBean(String.valueOf(gid), "2", "3", true);
            MessageEvent<FootballResultBean> event = new MessageEvent<FootballResultBean>
                    (EventType.MQTT, bean);
            EventBus.getDefault().post(event);
            uiHandler.sendEmptyMessageDelayed(0x01, HEART_BEAT_RATE);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        adapter = new ResultAdapter(R.layout.item_recycler, null);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);

        adapter.setNewData(FootballResultDataHelper.getInstance().getData());

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        uiHandler.sendEmptyMessageDelayed(0x01, HEART_BEAT_RATE);

    }

    private void initData() {
        for (int i = 0; i < 5000; i++) {
            Random random = new Random();

            String gid = String.valueOf(10000 + i);
            String hScore = String.valueOf(random.nextInt(10));
            String aScore = String.valueOf(random.nextInt(10));
            FootballResultBean bean = new FootballResultBean(gid, hScore, aScore, false);
            list.add(bean);
        }
        FootballResultDataHelper.getInstance().setData(list);
    }

    @OnClick(R.id.jump)
    public void onJumpClicked() {
    }

    @OnClick(R.id.send)
    public void onSendClicked() {
//        gid = gid + 1;
        gid = 10001;
        Random random = new Random();
        String vScore = random.nextInt(10) + "";
        String hScore = random.nextInt(10) + "";
        FootballResultBean bean = new FootballResultBean(String.valueOf(gid),vScore,hScore,true);
        MessageEvent<FootballResultBean> event = new MessageEvent<FootballResultBean>(EventType.MQTT, bean);
        EventBus.getDefault().post(event);
//        EventbusUtil.sendMessage();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        switch (event.type) {
            case EventType.MQTT:
                FootballResultBean bean = (FootballResultBean) event.getData();
//                Log.e(TAG, bean.toString());
                int position = FootballResultDataHelper.getInstance().updateData(bean);
                if (position != -1) {
                    adapter.setData(position, bean);
                }
//                adapter.notifyItemChanged(position, "aaaa");
                break;
            case EventType.UTIL:
                Toast.makeText(this, "收到工具类发的消息", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uiHandler.removeCallbacksAndMessages(null);
    }
}
