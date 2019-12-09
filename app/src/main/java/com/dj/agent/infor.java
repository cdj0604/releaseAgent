package com.dj.agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.agent.R;

public class infor extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infor);

        findViewById(R.id.btn1).setOnClickListener(onClickListener);
        findViewById(R.id.btn2).setOnClickListener(onClickListener);
        findViewById(R.id.btn3).setOnClickListener(onClickListener);
        findViewById(R.id.btn4).setOnClickListener(onClickListener);
        findViewById(R.id.btn5).setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1 :
                    Intent intent1 = new Intent(infor.this, infor_1.class);
                    startActivity(intent1);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    break;

                case R.id.btn2 :
                    Intent intent2 = new Intent(infor.this, infor_2.class);
                    startActivity(intent2);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    break;

                case R.id.btn3 :
                    Intent intent3 = new Intent(infor.this, infor_3.class);
                    startActivity(intent3);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    break;

                case R.id.btn4 :
                    Intent intent4 = new Intent(infor.this, infor_4.class);
                    startActivity(intent4);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    break;

                case R.id.btn5 :
                    Intent intent5 = new Intent(infor.this, infor_5.class);
                    startActivity(intent5);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    break;
            }
        }
    };
}