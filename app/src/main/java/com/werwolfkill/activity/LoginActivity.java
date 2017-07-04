package com.werwolfkill.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.werwolfkill.MainActivity;
import com.werwolfkill.R;
import com.werwolfkill.net.NetManager;
import com.werwolfkill.service.NetService;
import com.werwolfkill.service.NetServiceConnection;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import message.AccountProto;

import static message.AccountProto.LOGIN_TYPE;

public class LoginActivity extends AppCompatActivity {
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
    private final MyHandler mHandler = new MyHandler(this);

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

    public static class MyHandler extends Handler {

        //对Activity的弱引用
        private final WeakReference<LoginActivity> mActivity;

        public MyHandler(LoginActivity activity) {
            mActivity = new WeakReference<LoginActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            LoginActivity activity = mActivity.get();
            if (activity == null) {
                super.handleMessage(msg);
                return;
            }

            switch (msg.what) {
                case AccountProto.LOGIN_RESULT_TYPE.CREATE_NAME_EXIST_VALUE:
                    Toast.makeText(mActivity.get(), "账号名已存在", Toast.LENGTH_LONG).show();
                    break;
                case AccountProto.LOGIN_RESULT_TYPE.NO_ACCOUNT_VALUE:
                    Toast.makeText(mActivity.get(), "账号不存在", Toast.LENGTH_LONG).show();
                    break;
                case AccountProto.LOGIN_RESULT_TYPE.PWD_ERROR_VALUE:
                    Toast.makeText(mActivity.get(), "密码错误", Toast.LENGTH_LONG).show();
                    break;
                case AccountProto.LOGIN_RESULT_TYPE.SUCCESS_VALUE:
                    Intent intent = new Intent(mActivity.get(), MainActivity.class);
                    mActivity.get().startActivity(intent);
                    break;
            }

        }
    }
}
