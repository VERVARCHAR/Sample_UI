package com.example.test_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class View extends AppCompatActivity{

    TextView main_title;
    Button Change_mode;
    Button Change_lang;
    Button Start_trans;
    Button Record;
    EditText Input_Text;
    TextView OutPut_Text;
    public static Context conText_main;
    private FragmentManager fm = getSupportFragmentManager();


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Log.d("View", "onCreate");
//
//
//
//    }


    // Viewのコンストラクタ
    protected View(){
        Log.d("View", "View");
    }

    //contextをセットするメソッド　static忘れない
    public static void setConText(Context ct){
        conText_main = ct;
        Log.d("View", "set_Contest");
    }

    // Viewの初期化 main_titleの初期化を行っている
    public void init(){
        Log.d("View", "init");
//        fm.beginTransaction().replace(R.id.text_text_UI, new Text_Text()).commit();
        main_title = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.main_title);
        Change_lang = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Change_language);
        Change_mode = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Change_mode);
        Start_trans = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Translate_Start);
        Input_Text = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Input_Text);
        OutPut_Text = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Output_Text);

        main_title.setText("Santa Claus Japanese Translate");
        ButtonClickListener listener = new ButtonClickListener(conText_main);
        Start_trans.setOnClickListener(listener);
        Change_mode.setOnClickListener(listener);
        Change_lang.setOnClickListener(listener);
    }


//    Start_trans.setOnClickListener(this);
//    @Override
//    public void onClick(android.view.View v) {
//        if(v.getId() == R.id.Translate_Start){
//            SpannableStringBuilder sb = (SpannableStringBuilder)Input_Text.getText();
//            String str = sb.toString();
//            OutPut_Text.setText(str);
//            Log.d("View", "onClick Trans_Start");
//        }
//    }
}

