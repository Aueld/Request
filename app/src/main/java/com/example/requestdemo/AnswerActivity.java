package com.example.requestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AnswerActivity extends AppCompatActivity {
    EditText answer;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        intent = getIntent();
        answer = findViewById(R.id.answer);

        if(intent.getStringExtra("TYPE").equals("Int"))
            answer.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
    }

    public void onClickSend(View view) {
        String data = answer.getText().toString();

        intent.putExtra("DATA", data);

        //요청을수락하고자료를넘겨준다
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onClickCancel(View view) {
//요청을거절한다.
        setResult(RESULT_CANCELED, null);
        finish();
    }
}