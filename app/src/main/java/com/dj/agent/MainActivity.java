package com.dj.agent;

import android.app.TabActivity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TabHost;

import com.android.agent.R;


@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity{ // 상속이 TabActivity이다. 주의할 것!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //첫번째 탭 만들기
        final TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        tabHost.getTabWidget().setDividerDrawable(null);

        ImageView tabwidget01 = new ImageView(this);
        tabwidget01.setImageResource(R.drawable.tab_01);

        ImageView tabwidget02 = new ImageView(this);
        tabwidget02.setImageResource(R.drawable.tab_02);


        ImageView tabwidget03 = new ImageView(this);
        tabwidget03.setImageResource(R.drawable.tab_03);

        Intent intent = new Intent().setClass(this, main.class);
        spec = tabHost.newTabSpec("main").setIndicator(tabwidget01).setContent(intent);
        tabHost.addTab(spec);

        //세번째 탭 만들기
        intent = new Intent().setClass(this, money.class);

        spec = tabHost.newTabSpec("money").setIndicator(tabwidget02).setContent(intent);
        tabHost.addTab(spec);

        //두번째 탭 만들기
        intent = new Intent().setClass(this, setting.class);

        spec = tabHost.newTabSpec("setting").setIndicator(tabwidget03).setContent(intent);
        tabHost.addTab(spec);


        //처음 앱 실행시 탭 활성화 지정하기
        tabHost.setCurrentTab(0);

   /*     tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
           public void onTabChanged(String tabId) {
                for(int i = 0; i < tabHost.getTabWidget().getChildCount(); i++ ){
                    tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#5eab5e"));
                }
                tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#5eab5e"));
            }
        });*/

    }

}