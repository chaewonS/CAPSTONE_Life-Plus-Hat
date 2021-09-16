package com.example.tripple_s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //User 이름 값 받기
        Intent intent = getIntent();
        TextView View1 = (TextView)findViewById(R.id.TextView);
        String sendData = intent.getExtras().getString("sendData");
        View1.setText("사용자 이름: " + sendData);
        //User 버튼
        Button button1 = findViewById(R.id.patient);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //화면 전환 + User 이름 값 넘기기(User 화면)
                Intent intent1 = new Intent(getApplicationContext(), User_main.class);
                intent1.putExtra("sendData", sendData);
                startActivity(intent1);
                finish();
            }
        });
    }
}