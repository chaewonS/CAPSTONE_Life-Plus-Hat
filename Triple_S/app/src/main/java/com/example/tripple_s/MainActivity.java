package com.example.tripple_s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //User 이름 값 입력
        EditText sendData = (EditText)findViewById(R.id.patient);
        //확인 버튼 누르면 Main2 페이지로 넘어가기
        Button button = (Button)findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //화면 전환 + 환자 이름 값 넘기기
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("sendData", sendData.getText().toString());
                startActivity(intent);
            }
        });
    }
}