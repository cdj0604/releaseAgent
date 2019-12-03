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

public class finishday extends Activity {

    TextView textDday;
    TextView textResult;
    TextView test;
    Button nextbtn1;
    Button btnDate;

    int tYear;
    int tMonth;
    int tDay;

    int ddDay = 0;
    int ddMonth =0;
    int ddYear = 0;

    int dDay = 0;
    int dMonth =0;
    int dYear = 0;

    long dday;
    long today;
    long result;
    long start;
    long result1;

    int resultValue=0;
    int resultValue1=0;
    Calendar calendar;  //Today
    Calendar calendar2;
    Calendar calendar3;

    public final String key02 = "key02";
    public final String key03 = "key03";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finishday);


        textDday=(TextView) findViewById(R.id.textDday);
        nextbtn1 = (Button) findViewById(R.id.nextbtn1);
        btnDate=(Button) findViewById(R.id.btnDate);

        /* 오늘 날짜 구하기 */
        calendar=Calendar.getInstance();
        tYear=calendar.get(Calendar.YEAR);
        tMonth=calendar.get(Calendar.MONTH);
        tDay=calendar.get(Calendar.DAY_OF_MONTH);

        /*소집해제 선택 날짜구하기  */
        calendar2=Calendar.getInstance();
        dYear=calendar2.get(Calendar.YEAR);
        dMonth=calendar2.get(Calendar.MONTH);
        dDay=calendar2.get(Calendar.DAY_OF_MONTH);

        /*입소날 선택 날짜구하기  */
        calendar3=Calendar.getInstance();
        ddYear=calendar3.get(Calendar.YEAR);
        ddMonth=calendar3.get(Calendar.MONTH);
        ddDay=calendar3.get(Calendar.DAY_OF_MONTH);

        /* 소집해제 선택 날짜 구하기 */
        btnDate.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(finishday.this, mDateSetListener, dYear, dMonth, dDay).show();
            }
        });
        /*다음버튼*/
        nextbtn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),insert.class);
                startActivity(intent);
            }
        });



    }
    DatePickerDialog.OnDateSetListener mDateSetListener=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dYear=year;
            dMonth=monthOfYear;
            dDay=dayOfMonth;
            calendar2.set(Calendar.YEAR, dYear);
            calendar2.set(Calendar.MONTH, dMonth);
            calendar2.set(Calendar.DATE, dDay);

            start=calendar.getTimeInMillis()/(24*60*60*1000);//입소날변환
            today=calendar.getTimeInMillis()/(24*60*60*1000);//오늘날짜를 상수로 변환
            dday=calendar2.getTimeInMillis()/(24*60*60*1000);//소집해제 선택날짜를 상수로 변환
            result=dday-today; //현재까지 복무일
            result1=dday-today;
            resultValue1=(int)result; //소집해재Dday
            UpdateDday();
        }

    };

    void UpdateDday(){
        textDday.setText(String.format("%d.%d.%d", dYear,dMonth+1,dDay));  //선택 날짜 출력*/
        /* textResult.setText(String.format("%d 일",result)); //복무일수*/
        dday=calendar2.getTimeInMillis()/(24*60*60*1000);//소집해제 선택날짜를 상수로 변환
        setPreference(key02, String.valueOf(dday));
        String date = String.format("%d.%d.%d", dYear,dMonth+1,dDay);
        SharedPreferences pref = getSharedPreferences("date", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("date", date);
        // TODO : 필수 없으면 저장안됨
        editor.commit();

        /*    test.setText(String.format("D%d", result));*/
    }

    public void setPreference(String key, String value) {
        SharedPreferences preff = getSharedPreferences("PREFERENCE2", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preff.edit();
        editor.putString("key02", value);
        editor.commit();
    }

}