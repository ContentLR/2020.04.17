package com.example.register;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class MainActivity extends AppCompatActivity {

    private Button bdsjh,tijiao;

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)this.findViewById(R.id.tvsms);
        //事件
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCode(MainActivity.this);
            }
        });
        bdsjh=(Button)this.findViewById(R.id.bdsjh);
        tijiao=(Button)this.findViewById(R.id.tijiao);
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bdsjh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"功能暂时没有开通....",Toast.LENGTH_LONG).show();

            }
        });
    }
    public void sendCode(Context context) {
        RegisterPage page = new RegisterPage();
        //如果使用我们的ui，没有申请模板编号的情况下需传null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {

                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功  添加动作 
                        Intent intent=new Intent(MainActivity.this,ok_long_Activate.class);
                        startActivity(intent);
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }

                } else{
                    // TODO 处理错误的结果
                }
            }
        });
        page.show(context);
    }

}