package com.werwolfkill.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.werwolfkill.R;
import com.werwolfkill.activity.handler.ActMsgHandler;
import com.werwolfkill.data.DataManager;
import com.werwolfkill.net.NetManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import message.RoomMsgProto;
import message.core.ClientActionProto;

public class GameHallActivity extends BaseActivity {
    private final ActMsgHandler mHandler = new ActMsgHandler(this);
    @BindView(R.id.bt_create)
    Button btCreate;
    @BindView(R.id.bt_join)
    Button btJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hall);
        ButterKnife.bind(this);

        NetManager.getInstance().setmHandler(mHandler);
    }

    @Override
    public void handleMessage(Message msg) throws Exception {
        if (msg.arg1 == 0) {

        } else if (msg.arg1 == 1) {
            handleRsp(msg);
        }
    }

    @OnClick({R.id.bt_create, R.id.bt_join})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_create:
                NetManager.getInstance().creatRoomReq();
                break;
            case R.id.bt_join:
                NetManager.getInstance().joinRoomReq();
                break;
        }
    }

    @Override
    public void onBackPressed() {
    }

    /**
     * 处理响应
     *
     * @param msg
     * @throws Exception
     */
    private void handleRsp(Message msg) throws Exception {
        Bundle bundle = new Bundle();
        bundle.putByteArray("data", msg.getData().getByteArray("data"));
        if (msg.what == ClientActionProto.ClientAction.ACTION_CREAT_ROOM_VALUE) {//创建房间
            RoomMsgProto.CreatRoomRsp rsp = RoomMsgProto.CreatRoomRsp.parseFrom(msg.getData().getByteArray("data"));
            DataManager.getInstance().setRoom(rsp.getRoom());
            bundle.putInt("code", ClientActionProto.ClientAction.ACTION_CREAT_ROOM_VALUE);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("data",bundle);
            startActivity(intent);
        } else if (msg.what == ClientActionProto.ClientAction.ACTION_JOIN_ROOM_VALUE) {//加入房间
            RoomMsgProto.JoinRoomRsp rsp = RoomMsgProto.JoinRoomRsp.parseFrom(msg.getData().getByteArray("data"));
            if(rsp.getSuccess()){
                DataManager.getInstance().setRoom(rsp.getRoom());
                bundle.putInt("code", ClientActionProto.ClientAction.ACTION_JOIN_ROOM_VALUE);
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("data",bundle);
                startActivity(intent);
            }else{
                Toast.makeText(this, "没有可加入房间", Toast.LENGTH_LONG).show();
            }
        }else{
            return;
        }
    }
}
