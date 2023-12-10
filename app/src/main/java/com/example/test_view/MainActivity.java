package com.example.test_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Context context_main;
    View view = new View();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // MainActivity.javaのコンテキストを保存
        // これをviewクラスに渡すことでViewのIDをView.javaで行うことができる
        context_main = this;

        // viewにMainActivityのコンテキストをメソッドによって渡している
        view.setConText(context_main);
        Init();
    }

    protected void Init(){
        //viewの初期化
        view.init();
    }

}