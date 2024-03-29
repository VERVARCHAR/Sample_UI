package com.example.test_view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

// TODO
/*
 * ボタンの動的生成 -> できた/しかしspinnerのイベントが呼び出されるたびにボタンが増殖
 * Spinnerで選択した品詞を受け取ってボタンの変化 -> OK
 * 動的に生成したボタンを押したときにどうやって送る文字列を特定するか
 * 登録する文字列の管理　DB?strings.xmlに直接書き込む?
 * 色々な解釈をする単語への対応
 * 画面遷移
 */
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

    Spinner category;
    Spinner detail;

    android.view.View layout;

    ScrollView scrollView;

    LinearLayout linearLayout;

    public String select_category;

    public Button button1;

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
    protected View() {
        Log.d("View", "View");
    }

    //contextをセットするメソッド　static忘れない
    public static void setConText(Context ct) {
        conText_main = ct;
        Log.d("View", "set_Contest");
    }

    // Viewの初期化 main_titleの初期化を行っている
    public void init() {
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
        category = (Spinner) ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.category);
        detail  = (Spinner) ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.detail);
        scrollView = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.scrollView);
        linearLayout = ((com.example.test_view.MainActivity) conText_main).findViewById(R.id.linear);

        //タイトルにタイトルをセット
        main_title.setText("Santa Claus Japanese Translate");

        //ボタンにイベントを設定
        ButtonClickListener listener = new ButtonClickListener(conText_main);
        Start_trans.setOnClickListener(listener);
        Change_mode.setOnClickListener(listener);
        Change_lang.setOnClickListener(listener);

        //品詞選択spinnerの文字列を取得
        ArrayAdapter<CharSequence> adapter_category = ArrayAdapter.createFromResource(conText_main, R.array.category_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        category.setAdapter(adapter_category);

        //spinnerの選択要素変更の取得
        onItemSelectListener onItemSelectListener = new onItemSelectListener(conText_main);
        category.setOnItemSelectedListener(onItemSelectListener);

        //詳細選択spinnerの文字列を取得
        ArrayAdapter<CharSequence> adapter_detail = ArrayAdapter.createFromResource(conText_main, R.array.detail_noun_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter_detail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        detail.setAdapter(adapter_detail);

        //spinnerの選択要素変更の取得
//        onItemSelectListener onItemSelectListener = new onItemSelectListener(conText_main);
        detail.setOnItemSelectedListener(onItemSelectListener);



    }


    public void menuMethod(@NonNull MenuItem item){

        String message = "「" + item.getTitle() + "」が押されました。";
        Toast.makeText(conText_main, message, Toast.LENGTH_SHORT).show();
    }


    //これ以降は一応使わない
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

