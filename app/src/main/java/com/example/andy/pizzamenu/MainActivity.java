package com.example.andy.pizzamenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int number;
    private int number2;
    private int numberFut;
    private int numberPackage;
    //    int numbertotal = number + number2;
    private int price1 = 190;
    private int price2 = 170;
    private int priceFut = 30;
    private int pricePackage = 2;
//    private int pricetotal=number*price1+number2*price2+number3*price3;

    private String productname1 = "愛心披薩";
    private String productname2 = "皇冠披薩";
    private StringBuilder sb = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();
    private StringBuilder sbFut = new StringBuilder();
    private StringBuilder sb3Package = new StringBuilder();
    private StringBuilder sbTotal = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //協調者（中介者模式）Ｍｅｄｉａｔｏｒ　Ｐａｔｔｏｎ
    public void mediator(View view) {
        switch (view.getId()) {
            case R.id.button_up1:
                up1(view);
                break;
            case R.id.button_down1:
                down1(view);
                break;
            case R.id.button_up2:
                up2(view);
                break;
            case R.id.button_down2:
                down2(view);
                break;
            case R.id.check_fut:
                fut(view);
                break;
            case R.id.check_out:
                checkout(view);
                break;
            case R.id.button_checkout:
                totalend(view);
                break;
        }
    }

    //這邊 按鈕的設定 "up1" . "up2" . "down1" . "down2" . totalend 的按鈕
    public void up1(View view) {
        clean_message_space4();
        up();
        set_Menumessage_space1();
        show_Menumessage_space1();
    }

    public void down1(View view) {
        clean_message_space4();
        down();
        set_Menumessage_space1();
        show_Menumessage_space1();
    }

    public void up2(View view) {
        clean_message_space4();
        up2();
        set_Menumessage_space2();
        show_Menumessage_space2();
    }

    public void down2(View view) {
        clean_message_space4();
        down2();
        set_Menumessage_space2();
        show_Menumessage_space2();
    }

    public void totalend(View view) {
        clean_message_space4();
        set_Total_message();
        show_Total_message();
    }

    public void fut(View view) {
        clean_message_space4();
        TextView a = (TextView) findViewById(R.id.text_space3_1);
        sbFut.delete(0, sbFut.length());
        CheckBox fut = (CheckBox) findViewById(R.id.check_fut);
        if (fut.isChecked()) {
            sbFut.append("加選了 玉米濃湯，小計" + priceFut + "元\n");
        }
        a.setText(sbFut);
    }

    public void checkout(View view) {
        clean_message_space4();
        TextView a = (TextView) findViewById(R.id.text_space3_2);
        sb3Package.delete(0, sb3Package.length());
        CheckBox fut = (CheckBox) findViewById(R.id.check_out);
        if (fut.isChecked()) {
            sb3Package.append("加購了 愛心袋子，小計" + pricePackage + "元\n");
        }
        a.setText(sb3Package);
    }

    ;
//按鈕 按下去 所發生的事情： 設定訊息、顯示訊息、清除訊息
// (分別有3個空白位置 space1  space2  space3)

    private void set_Menumessage_space1() {
        sb.delete(0, sb.length());
        if (number > 0) {
            sb.append(productname1 + "x" + number + "份，小計=" + number * price1 + "元");
        }
    }

    private void show_Menumessage_space1() {
        TextView a = (TextView) findViewById(R.id.text_space1);
        a.setText(sb);
    }
//    private void set_Menumessage_space3() { }
//
//    private void show_Menumessage_space3() { }

    private void set_Menumessage_space2() {
        sb2.delete(0, sb2.length());
        if (number2 > 0) {
            sb2.append(productname2 + "x" + number2 + "份，小計=" + number2 * price2 + "元");
        }
    }

    private void show_Menumessage_space2() {
        TextView a = (TextView) findViewById(R.id.text_space2);
        a.setText(sb2);
    }

    private void set_Total_message() {
        CheckBox c1 = (CheckBox) findViewById(R.id.check_out);
        CheckBox c2 = (CheckBox) findViewById(R.id.check_fut);
        int pricetotal = number * price1 + number2 * price2;
        if (number <= 0 && number2 <= 0) {
            sbTotal.append("尚未輸入任何餐點");
            return;
        }
        if (c1.isChecked()) {
            pricetotal += pricePackage;
        }
        if (c2.isChecked()) {
            pricetotal += priceFut;
        }

        sbTotal.append("總共= " + pricetotal + "元");
    }

    private void show_Total_message() {
        TextView a = (TextView) findViewById(R.id.text_space4);
        a.setText(sbTotal);
    }

    private void clean_message_space4() {
        sbTotal.delete(0, sbTotal.length());
        TextView a = (TextView) findViewById(R.id.text_space4);
        a.setText(sbTotal);
    }

    private void up2() {
        number2++;
        String numberstr2 = String.valueOf(number2);
        TextView a = (TextView) findViewById(R.id.text_Quantity2);
        a.setText(numberstr2);
    }

    private void down2() {
        number2--;
        String numberstr2 = String.valueOf(number2);
        TextView a = (TextView) findViewById(R.id.text_Quantity2);

        if (number2 < 0) {
            number2 = 0;
            a.setText("0");
        } else {
            a.setText(numberstr2);
        }
    }

    private void up() {
        number++;
        String numberstr = String.valueOf(number);
        TextView a = (TextView) findViewById(R.id.text_Quantity1);
        a.setText(numberstr);
    }

    private void down() {
        number--;
        String numberstr = String.valueOf(number);
        TextView a = (TextView) findViewById(R.id.text_Quantity1);

        if (number < 0) {
            number = 0;
            a.setText("0");
        } else {
            a.setText(numberstr);
        }
    }

}
