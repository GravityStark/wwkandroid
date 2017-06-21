package com.werwolfkill;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.werwolfkill.net.NetManager;
import com.werwolfkill.service.NetService;
import com.werwolfkill.service.NetServiceConnection;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.werwolfkill.R.id.sender;

public class MainActivity extends AppCompatActivity {

    private NetServiceConnection netServiceConnection = new NetServiceConnection();
    private ListView listView;
    private List<Map<String, String>> dataList = new ArrayList<>();
    private final MyHandler mHandler = new MyHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //启动net服务
        Intent intent = new Intent(this, NetService.class);
        startService(intent);
        bindService(intent, netServiceConnection, BIND_AUTO_CREATE);
        //去掉actionBar
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initListView();

        NetManager.getinstance().setmHandler(mHandler);

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
     * 接收游戏信息
     * @param sender
     * @param content
     */
    public void receiveGameMsg(String sender,String content){
        Map<String,String> lineData = new HashMap<>();
        lineData.put("sender",sender);
        lineData.put("content",content);
        dataList.add(lineData);
        SimpleAdapter sAdapter = (SimpleAdapter)  listView.getAdapter();
        sAdapter.notifyDataSetChanged();
        listView.setSelection(dataList.size());
    }


    public static class MyHandler extends Handler {

        //对Activity的弱引用
        private final WeakReference<MainActivity> mActivity;

        public MyHandler(MainActivity activity){
            mActivity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mActivity.get();
            if(activity==null){
                super.handleMessage(msg);
                return;
            }
            switch (msg.what) {
                case 1: //更新listView
                    activity.receiveGameMsg(msg.getData().getString("sender"),msg.getData().getString("content"));
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }

}
