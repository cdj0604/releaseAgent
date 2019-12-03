package com.dj.agent;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.android.agent.R;

import java.util.Calendar;

public class startday extends Activity {

    TextView textDday1;
    TextView textResult1;
    Button nextbtn;
    Button btnDate1;

    int tYear;
    int tMonth;
    int tDay;



    int ddDay = 0;
    int ddMonth =0;
    int ddYear = 0;

    long ddday;
    long ttoday;
    long result1;


    int resultValue1=0;
    Calendar calendar;  //Today
    Calendar calendar3;

    public final String key01 = "key01";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startday);


        textDday1=(TextView) findViewById(R.id.textDday1);
        nextbtn = (Button) findViewById(R.id.nextbtn);
        btnDate1=(Button) findViewById(R.id.btnDate1);

        /* 오늘 날짜 구하기 */
        calendar=Calendar.getInstance();
        tYear=calendar.get(Calendar.YEAR);
        tMonth=calendar.get(Calendar.MONTH);
        tDay=calendar.get(Calendar.DAY_OF_MONTH);

        /*입소날 선택 날짜구하기  */
        calendar3=Calendar.getInstance();
        ddYear=calendar3.get(Calendar.YEAR);
        ddMonth=calendar3.get(Calendar.MONTH);
        ddDay=calendar3.get(Calendar.DAY_OF_MONTH);

        /* 입소날 선택 날짜 구하기 */
        btnDate1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(startday.this, mDateSetListener1, ddYear, ddMonth, ddDay).show();
            }
        });
        /*다음버튼*/
        nextbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),finishday.class);
                startActivity(intent);
            }
        });


    }
    DatePickerDialog.OnDateSetListener mDateSetListener1=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            ddYear=year;
            ddMonth=monthOfYear;
            ddDay=dayOfMonth;
            calendar3.set(Calendar.YEAR, ddYear);
            calendar3.set(Calendar.MONTH, ddMonth);
            calendar3.set(Calendar.DATE, ddDay);
            ttoday=calendar.getTimeInMillis()/(24*60*60*1000);
            ddday=calendar3.getTimeInMillis()/(24*60*60*1000);
            result1=ttoday-ddday; //현재까지 복무일
            resultValue1=(int)result1; //소집해재Dday
            UpdateDday();

        }
    };
    void UpdateDday(){
        textDday1.setText(String.format("%d.%d.%d", ddYear, ddMonth+1, ddDay));  //선택 날짜 출력
        /*  textResult1.setText(String.format("%d 일",result1)); //복무일수*/
        setPreference(key01, String.valueOf(ddday));

    }

    public void setPreference(String key, String value) {
        SharedPreferences pref = getSharedPreferences("PREFERENCE", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("key01", value);
        editor.commit();
    }
}