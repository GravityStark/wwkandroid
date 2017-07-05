package com.werwolfkill.data;

import com.werwolfkill.R;

import java.lang.reflect.Field;

import message.PlayerProto;
import message.RoomMsgProto;

/**
 *
 * 数据管理
 * Created by liuwei on 2017/7/5.
 */

public class DataManager {
    private PlayerProto.PlayerMsg player;
    private RoomMsgProto.RoomMsg room;


    private DataManager() {
    }
    /**
     * 枚举单例
     */
    enum Singleton {
        INSTANCE;

        DataManager instance;

        Singleton() {
            instance = new DataManager();
        }
        DataManager getInstance() {
            return instance;
        }
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static DataManager getInstance() {
        return DataManager.Singleton.INSTANCE.getInstance();
    }

    public PlayerProto.PlayerMsg getPlayer() {
        return player;
    }

    public void setPlayer(PlayerProto.PlayerMsg player) {
        this.player = player;
    }

    public RoomMsgProto.RoomMsg getRoom() {
        return room;
    }

    public void setRoom(RoomMsgProto.RoomMsg room) {
        this.room = room;
    }

    public int getRimgId(int imgid) throws Exception {
        Field field = R.drawable.class.getDeclaredField("hd_"+DataManager.getInstance().getPlayer().getImgId());
        if(field == null){
            return 1;
        }else{
            return field.getInt(null);
        }
    }
}
