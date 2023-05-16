package com.example.animalhospital;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 이벤트
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show();
                //아이디(5)와 패스워드(9~12) 자릿수 체크
                //아이디 : 30312, 패스워드 : 0508113322
                EditText userid, passwd;
                userid = findViewById(R.id.userid);
                passwd = findViewById(R.id.passwd);
                String str_userid = userid.getText().toString();
                String str_passwd = passwd.getText().toString();
                Log.d("MSG", str_userid);
                Log.d("MSG", str_passwd);

                //길이 체크
                if (str_userid.length() != 5){
                    Toast.makeText(MainActivity.this, "id는 5자리 입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }else if (9 > str_passwd.length() || str_passwd.length() > 12 ){
                    Toast.makeText(MainActivity.this, "password는 9~12자리 입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }else if (str_userid.equals("30312") && str_passwd.equals("0508113322") ){
                    Toast.makeText(MainActivity.this, str_userid+"님 환영합니다.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "아이디 또는 패스워드를 입력하세요", Toast.LENGTH_SHORT).show();
                }



            }
        });

        //간략하게 쓰기
        findViewById(R.id.btn_info).setOnClickListener(this);
        findViewById(R.id.btn_guide).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_shop).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_info:
                intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("title", "안전하고 깨끗한 의료시설");
                startActivity(intent);

                break;
            case R.id.btn_guide:
                intent = new Intent(MainActivity.this, GuideActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_call:
                intent = new Intent(MainActivity.this, CallActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_shop:
                intent = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(intent);
                break;
        }
    }
}