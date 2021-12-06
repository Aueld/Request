package com.example.requestdemo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    TextView tv = findViewById(R.id.result);
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();

                        tv.setText(result.getData().getStringExtra("DATA"));
//
//                        int CallType = intent.getIntExtra("CallType", 0);
//                        if(CallType == 0){
//                        }else if(CallType == 1){
//
//                        }else if(CallType == 2){
//                        }
                    } else {
                        tv.setText("취소");
                    }
                }
            });;

    private static final int REQUEST_CODE = 0;

    public void requestInt(View view) {
        Intent intent = new Intent(this, AnswerActivity.class);

        //자료요청
        intent.putExtra("TYPE", "Int");

        resultLauncher.launch(intent);

        //startActivityForResult(intent, REQUEST_CODE);
//        registerForActivityResult();
    }
    public void requestStr(View view){
        Intent intent = new Intent(this, AnswerActivity.class);

        intent.putExtra("TYPE", "Str");


        Intent intent1 = getIntent();
        Toast.makeText(this, intent1.getAction() + "", Toast.LENGTH_SHORT).show();

        resultLauncher.launch(intent);

        //startActivityForResult(intent, REQUEST_CODE);
    }
}