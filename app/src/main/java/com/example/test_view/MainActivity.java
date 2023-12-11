package com.example.test_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


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

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.title_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            R.id.action_home ->
//            R.id.action_user ->
//            R.id.action_map ->
//        }

        view.menuMethod(item);
//        String message = "「" + item.getTitle() + "」が押されました。";
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        return true;
    }


    protected void Init(){
        //viewの初期化
        view.init();
    }

}