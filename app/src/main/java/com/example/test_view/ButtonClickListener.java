package com.example.test_view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonClickListener implements android.view.View.OnClickListener {
    private Context context;

    ButtonClickListener(Context c) {
        context = c;
    }

    @Override
    public void onClick(android.view.View v) {
        EditText Input_Text;
        TextView OutPut_Text;
        Input_Text = ((com.example.test_view.MainActivity) context).findViewById(R.id.Input_Text);
        OutPut_Text = ((com.example.test_view.MainActivity) context).findViewById(R.id.Output_Text);
        Log.d("ButtonListener", "come");
        int id = v.getId();

        if(id == R.id.Translate_Start) {
            SpannableStringBuilder sb = (SpannableStringBuilder) Input_Text.getText();
            String str = sb.toString();

            //翻訳処理を記述 or 翻訳処理を行うメソッドへ繊維遷移

            OutPut_Text.setText(str);
        }
        else if(id == R.id.Change_mode) {


        }
        else if(id == R.id.Change_language){

        }
    }
}
