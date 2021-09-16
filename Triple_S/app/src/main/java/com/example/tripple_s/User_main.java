package com.example.tripple_s;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class User_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        //환자 이름 값 받기 + 출력
        TextView View1 = (TextView)findViewById(R.id.username);
        Intent intent = getIntent();
        String sendData = intent.getExtras().getString("sendData");
        View1.setText(sendData);

        Button btneme = findViewById(R.id.emergancy); //긴급신고 버튼 객체
        Button btnmystate = findViewById(R.id.my_state); //나의건강수치

        btneme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:서버로 환자 긴급상태 보내기
                Toast.makeText(getApplicationContext(),"긴급신호 전송 완료",Toast.LENGTH_LONG).show();
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:119"));
                startActivity(mIntent);
            }
        });

        btnmystate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:메인페이지에서 나의 건강수치 페이지로 화면전환
                Intent intent = new Intent(getApplicationContext(), User_state.class);
                startActivity(intent);
            }
        });

    }
}