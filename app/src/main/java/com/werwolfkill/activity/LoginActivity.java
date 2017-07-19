package com.werwolfkill.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.protobuf.InvalidProtocolBufferException;
import com.werwolfkill.R;
import com.werwolfkill.activity.handler.ActMsgHandler;
import com.werwolfkill.data.DataManager;
import com.werwolfkill.net.NetManager;
import com.werwolfkill.service.NetService;
import com.werwolfkill.service.NetServiceConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import message.AccountProto;

import static message.AccountProto.LOGIN_TYPE;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tv_an)
    TextView tvAn;
    @BindView(R.id.et_an)
    EditText etAn;
    @BindView(R.id.tv_pwd)
    TextView tvPwd;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_pwda)
    TextView tvPwda;
    @BindView(R.id.et_pwda)
    EditText etPwda;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    Button register;
    private NetServiceConnection netServiceConnection = new NetServiceConnection();
    private final ActMsgHandler mHandler = new ActMsgHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        //绑定启动net服务
        Intent intent = new Intent(this, NetService.class);
        bindService(intent, netServiceConnection, BIND_AUTO_CREATE);

        NetManager.getInstance().setmHandler(mHandler);
    }

    @OnClick({R.id.login, R.id.register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                NetManager.getInstance().loginReq(LOGIN_TYPE.LOGIN_VALUE, etAn.getText().toString(), etPwd.getText().toString());
                break;
            case R.id.register:
                if (tvPwda.getVisibility() == View.INVISIBLE) {
                    tvPwda.setVisibility(View.VISIBLE);
                    etPwda.setVisibility(View.VISIBLE);
                    login.setVisibility(View.INVISIBLE);
                } else {
                    if (!etPwda.getText().toString().equals(etPwd.getText().toString())) {
                        Toast.makeText(this, "密码不一致", Toast.LENGTH_LONG).show();
                    } else if (etAn.getText().length() < 5) {
                        Toast.makeText(this, "账号不合法", Toast.LENGTH_LONG).show();
                    } else {
                        NetManager.getInstance().loginReq(LOGIN_TYPE.CREATE_VALUE, etAn.getText().toString(), etPwd.getText().toString());
                    }
                }
                break;
        }
    }

    @Override
    public void handleMessage(Message msg) throws InvalidProtocolBufferException {
        AccountProto.LoginRsp rsp = AccountProto.LoginRsp.parseFrom(msg.getData().getByteArray("data"));
        switch (rsp.getResult()) {
            case AccountProto.LOGIN_RESULT_TYPE.CREATE_NAME_EXIST_VALUE:
                Toast.makeText(this, "账号名已存在", Toast.LENGTH_LONG).show();
                break;
            case AccountProto.LOGIN_RESULT_TYPE.NO_ACCOUNT_VALUE:
                Toast.makeText(this, "账号不存在", Toast.LENGTH_LONG).show();
                break;
            case AccountProto.LOGIN_RESULT_TYPE.PWD_ERROR_VALUE:
                Toast.makeText(this, "密码错误", Toast.LENGTH_LONG).show();
                break;
            case AccountProto.LOGIN_RESULT_TYPE.SUCCESS_VALUE:
                DataManager.getInstance().setPlayer(rsp.getPlayer());
                Intent intent = new Intent(this, GameHallActivity.class);
                startActivity(intent);
                break;
        }
    }
}
