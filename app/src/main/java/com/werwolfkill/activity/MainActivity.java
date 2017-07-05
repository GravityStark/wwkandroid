package com.werwolfkill.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.werwolfkill.R;
import com.werwolfkill.activity.handler.ActMsgHandler;
import com.werwolfkill.data.DataManager;
import com.werwolfkill.net.NetManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import message.RoomMsgProto;
import message.core.ClientActionProto;

import static com.werwolfkill.R.id.sender;

public class MainActivity extends BaseActivity {


    @BindView(R.id.selfimg)
    ImageView selfimg;
    @BindView(R.id.selfname)
    TextView selfname;
    @BindView(R.id.p1)
    ImageView p1;
    @BindView(R.id.p2)
    ImageView p2;
    @BindView(R.id.p3)
    ImageView p3;
    @BindView(R.id.p4)
    ImageView p4;
    @BindView(R.id.p5)
    ImageView p5;
    @BindView(R.id.gmsg)
    ListView gmsg;
    @BindView(R.id.p6)
    ImageView p6;
    @BindView(R.id.p7)
    ImageView p7;
    @BindView(R.id.p8)
    ImageView p8;
    @BindView(R.id.p9)
    ImageView p9;
    @BindView(R.id.p10)
    ImageView p10;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.tv7)
    TextView tv7;
    @BindView(R.id.tv8)
    TextView tv8;
    @BindView(R.id.tv9)
    TextView tv9;
    @BindView(R.id.tv10)
    TextView tv10;
    private ListView listView;
    private List<Map<String, String>> dataList = new ArrayList<>();
    private final ActMsgHandler mHandler = new ActMsgHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉actionBar
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        initListView();

        NetManager.getInstance().setmHandler(mHandler);
        NetManager.getInstance().creatRoomReq();
    }

    @Override
    public void onBackPressed() {
        //不作处理,防止返回登录界面

        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    /**
     * 初始化对话listView
     */
    private void initListView() {
        listView = (ListView) findViewById(R.id.gmsg);
        SimpleAdapter adapter = new SimpleAdapter(this, dataList, R.layout.glv, new String[]{"sender", "content"}, new int[]{sender, R.id.content});
        listView.setAdapter(adapter);
    }

    /**
     * 更新游戏信息区（ListView）
     *
     * @param sender
     * @param content
     */
    public void updateGameMsg(String sender, String content) {
        Map<String, String> lineData = new HashMap<>();
        lineData.put("sender", sender);
        lineData.put("content", content);
        dataList.add(lineData);
        SimpleAdapter sAdapter = (SimpleAdapter) listView.getAdapter();
        sAdapter.notifyDataSetChanged();
        listView.setSelection(dataList.size());
    }

    @Override
    public void handleMessage(Message msg) throws Exception {
        if (msg.what == ClientActionProto.ClientAction.ACTION_CREAT_ROOM_VALUE) {
            RoomMsgProto.CreatRoomRsp rsp = RoomMsgProto.CreatRoomRsp.parseFrom(msg.getData().getByteArray("rsp"));
            DataManager.getInstance().setRoom(rsp.getRoom());

            updateGameMsg("系统消息:", DataManager.getInstance().getPlayer().getName() + "  加入游戏。");

            selfimg.setImageResource(DataManager.getInstance().getRimgId(DataManager.getInstance().getPlayer().getImgId()));
            selfname.setText(DataManager.getInstance().getPlayer().getName());
            p1.setImageResource(DataManager.getInstance().getRimgId(DataManager.getInstance().getPlayer().getImgId()));
            tv1.setText(DataManager.getInstance().getPlayer().getName());
        }
    }

}
