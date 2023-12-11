package com.example.test_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.navigation.NavigationBarView;

public class View extends AppCompatActivity implements TextWatcher {

    TextView main_title;
    Button Change_mode;
    Button Change_lang;
    Button Start_trans;
    Button Record;
    EditText Input_Text;
    TextView OutPut_Text;
    public static Context conText_main;
    private FragmentManager fm = getSupportFragmentManager();

    Spinner types;

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

        //各UIのIDを取得
        main_title = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.main_title);
        Change_lang = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Change_language);
        Change_mode = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Change_mode);
        Start_trans = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Translate_Start);
        Input_Text = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Input_Text);
        Input_Text.addTextChangedListener(this);
        OutPut_Text = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.Output_Text);
        types = (Spinner) ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.people);

        //タイトルにタイトルをセット
        main_title.setText("Santa Claus Japanese Translate");

        //ボタンにイベントを設定
        ButtonClickListener listener = new ButtonClickListener(conText_main);
        Start_trans.setOnClickListener(listener);
        Change_mode.setOnClickListener(listener);
        Change_lang.setOnClickListener(listener);

        //品詞選択spinnerの文字列を取得
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(conText_main,
                R.array.people_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        types.setAdapter(adapter);

        //spinnerの選択要素変更の取得
        onItemSelectListener onItemSelectListener = new onItemSelectListener(conText_main);
        types.setOnItemSelectedListener(onItemSelectListener);


    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        OutPut_Text.setText(s.toString());
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

//buttonSetting.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        String item = spinner.getSelectedItem().toString();
//        textSelected.setText("選択された目的地： " + item);
//        }
//        });

