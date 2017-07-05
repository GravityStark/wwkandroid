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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import message.PlayerProto;
import message.RoomMsgProto;
import message.core.ClientActionProto;
import message.core.PushMsgProto;

import static com.werwolfkill.R.id.sender;

public class MainActivity extends BaseActivity {


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

        handleHallActivity(getIntent().getBundleExtra("data"));

    }

    /**
     * 处理游戏大厅数据
     * @param savedInstanceState
     */
    private void handleHallActivity(Bundle savedInstanceState) {
        try {
            if(savedInstanceState.getInt("code") == ClientActionProto.ClientAction.ACTION_CREAT_ROOM_VALUE){
                updateGameMsg("系统消息:", DataManager.getInstance().getPlayer().getName() + "  加入游戏。");
                p1.setImageResource(DataManager.getInstance().getRimgId(DataManager.getInstance().getPlayer().getImgId()));
                tv1.setText(DataManager.getInstance().getPlayer().getName());
            }else if(savedInstanceState.getInt("code") == ClientActionProto.ClientAction.ACTION_JOIN_ROOM_VALUE){
                updateGameMsg("系统消息:", DataManager.getInstance().getPlayer().getName() + "  加入游戏。");
                List<RoomMsgProto.JoinerInfoMsg> joiners = DataManager.getInstance().getRoom().getJoinerInfoMsgList();
                for (int i = 0;i < joiners.size();i++){
                    RoomMsgProto.JoinerInfoMsg joiner  = joiners.get(i);

                    Field imField = this.getClass().getDeclaredField("p"+(i+1));
                    ImageView imageView = (ImageView)imField.get(this);
                    imageView.setImageResource(DataManager.getInstance().getRimgId(joiner.getJoiner().getPlayerMsg().getImgId()));

                    Field tvField = this.getClass().getDeclaredField("tv"+(i+1));
                    TextView textView = (TextView)tvField.get(this);
                    textView.setText(joiner.getJoiner().getPlayerMsg().getName());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {

        NetManager.getInstance().quitRoomReq(DataManager.getInstance().getRoom().getId());

        //返回游戏大厅界面
        Intent intent = new Intent(this,GameHallActivity.class);
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
        if(msg.arg1 == 0){
            handlePush(msg);
        }else if(msg.arg1 == 1){
            handleRsp(msg);
        }
    }

    /**
     * 处理响应
     * @param msg
     * @throws Exception
     */
    private void handleRsp(Message msg) throws Exception {
        if (msg.what == ClientActionProto.ClientAction.ACTION_CREAT_ROOM_VALUE) {//创建房间
        }else if(msg.what == ClientActionProto.ClientAction.ACTION_JOIN_ROOM_VALUE){//加入房间
        }else if(msg.what == ClientActionProto.ClientAction.ACTION_QUIT_ROOM_VALUE){//离开房间
        }else if(msg.what == ClientActionProto.ClientAction.ACTION_SEND_TXT_MSG_VALUE){//发送文本消息
        }
    }

    /**
     * 处理推送
     * @param msg
     * @throws Exception
     */
    private void handlePush(Message msg) throws Exception {
        if(msg.what == PushMsgProto.PushType.PUSH_PLAYER_VALUE){//玩家信息
            PlayerProto.PlayerMsg playerMsg = PlayerProto.PlayerMsg.parseFrom(msg.getData().getByteArray("data"));
            DataManager.getInstance().setPlayer(playerMsg);
        }else if(msg.what == PushMsgProto.PushType.PUSH_JOIN_GAME_VALUE){//加入游戏

            RoomMsgProto.JoinerInfoMsg joiner = RoomMsgProto.JoinerInfoMsg.parseFrom(msg.getData().getByteArray("data"));

            Field imField = this.getClass().getDeclaredField("p"+joiner.getLocation());
            ImageView imageView = (ImageView)imField.get(this);
            imageView.setImageResource(DataManager.getInstance().getRimgId(joiner.getJoiner().getPlayerMsg().getImgId()));

            Field tvField = this.getClass().getDeclaredField("tv"+joiner.getLocation());
            TextView textView = (TextView)tvField.get(this);
            textView.setText(joiner.getJoiner().getPlayerMsg().getName());

            updateGameMsg("系统消息:", joiner.getJoiner().getPlayerMsg().getName() + "  加入游戏。");
        }else if(msg.what == PushMsgProto.PushType.PUSH_QUIT_GAME_VALUE){//离开游戏
            RoomMsgProto.JoinerInfoMsg joiner = RoomMsgProto.JoinerInfoMsg.parseFrom(msg.getData().getByteArray("data"));

            //清空位置
            Field imField = this.getClass().getDeclaredField("p"+joiner.getLocation());
            ImageView imageView = (ImageView)imField.get(this);
            imageView.setImageResource(R.drawable.plder);
            Field tvField = this.getClass().getDeclaredField("tv"+joiner.getLocation());
            TextView textView = (TextView)tvField.get(this);
            textView.setText("");

            updateGameMsg("系统消息:", joiner.getJoiner().getPlayerMsg().getName() + "  离开游戏。");
        }else if(msg.what == PushMsgProto.PushType.PUSH_SEND_TXT_MSG_VALUE){//文本信息推送
            RoomMsgProto.GameMsgPro gameMsgPro = RoomMsgProto.GameMsgPro.parseFrom(msg.getData().getByteArray("data"));

            if(gameMsgPro.getType() == RoomMsgProto.GameMsgType.SYSTEM_VALUE){

                updateGameMsg("系统消息", "");
            }else if(gameMsgPro.getType() == RoomMsgProto.GameMsgType.PLAYER_VALUE){
                updateGameMsg(Integer.toString(gameMsgPro.getSenderId())+"号玩家", gameMsgPro.getPMsg());
            }

        }else if(msg.what == PushMsgProto.PushType.PUSH_SEND_VOICE_MSG_VALUE){//语音信息推送

        }else if(msg.what == PushMsgProto.PushType.PUSH_ROOM_MSG_VALUE){//房间信息推送
            RoomMsgProto.RoomMsg roomMsg = RoomMsgProto.RoomMsg.parseFrom(msg.getData().getByteArray("data"));
            DataManager.getInstance().setRoom(roomMsg);
        }
    }

}
