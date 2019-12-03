package com.dj.agent;

import android.app.Activity;
import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.agent.R;

public class money extends Activity {
    private BackPressCloseHandler backPressCloseHandler;
    public int d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money);
        Button Button1 = (Button)findViewById(R.id.button);
        Button Button2 = (Button)findViewById(R.id.button2);
        Button Button3 = (Button)findViewById(R.id.button3);
        Button Button4 = (Button)findViewById(R.id.button4);


        backPressCloseHandler = new BackPressCloseHandler(this);


    }

    public void button1(View v){
        d=306130;
    }
    public void button2(View v){
        d=331296;
    }
    public void button3(View v){
        d=366229;
    }
    public void button4(View v){
        d=412832;
    }


    public void onClick(View v) { //계산하기버튼
        EditText input1 = (EditText) findViewById(R.id.edit01);//출근일수입력
        TextView result = (TextView) findViewById(R.id.textView3);//월급보여주기

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        String eat = pref.getString("insert_eat", "");
        String bus = pref.getString("insert_bus", "");
        String getinput1 = input1.getText().toString();//출근일수입력
        input1.setSelection(input1.length()); //뒤부터입력
        if (getinput1.getBytes().length <= 0 || d==0) {
            Toast.makeText(getApplicationContext(), "계급과 출근일수를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show();

        } else {
            int intbus = Integer.parseInt(bus);
            int inteat = Integer.parseInt(eat);
            int a = Integer.parseInt(input1.getText().toString()); //출근일수
            int sum = (a * intbus) + (a * inteat) + d;

            String stringsum = Integer.toString(sum);

            result.setVisibility(View.VISIBLE); //버튼클릭시 월급보여주기
            result.setText("  이번달월급 "+stringsum + " 원");


        }
    }
    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

}