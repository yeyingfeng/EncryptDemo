package com.example.yg191.encryptdemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yg191.encryptdemo.utils.Encryption;

public class MainActivity extends AppCompatActivity {

    private EditText inputEt;
    private Button md5Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        inputEt = findViewById(R.id.input_et);
        md5Btn = findViewById(R.id.md5_btn);

        md5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = inputEt.getText().toString();
                String md5Str = Encryption.md5(str);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("MD5值")
                        .setMessage(md5Str)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });
    }
}
