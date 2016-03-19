package com.example.andy.pizzamenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int number;
    private int number2;
    private int price = 120;

    private String productname1 = "愛心披薩";
    private String productname2 = "皇冠披薩";
    private StringBuilder sb = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();
    private StringBuilder sb3 = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button(View view) {
        cleanmessage();
        setTotalmessage();
        showTotalmessage();
    }

    public void up(View view) {
        cleanmessage();
        up();
        setMenumessage();
        showMenumessage();
    }

    public void down(View view) {
        cleanmessage();
        down();
        setMenumessage();
        showMenumessage();
    }

    public void up2(View view) {
        cleanmessage();
        up2();
        setMenumessage2();
        showMenumessage2();
    }

    public void down2(View view) {
        cleanmessage();
        down2();
        setMenumessage2();
        showMenumessage2();
    }

    private void setMenumessage2() {
        sb2.delete(0, sb2.length());
        if (number2 > 0) {
            sb2.append(productname2 + "x" + number2 + "份，小計=" + number2 * price + "元");
        }
    }

    private void showMenumessage2() {
        TextView a = (TextView) findViewById(R.id.text_product2);
        a.setText(sb2);
    }

    private void up2() {
        number2++;
        String numberstr2 = String.valueOf(number2);
        TextView a = (TextView) findViewById(R.id.text_0_2);
        a.setText(numberstr2);
    }

    private void down2() {
        number2--;
        String numberstr2 = String.valueOf(number2);
        TextView a = (TextView) findViewById(R.id.text_0_2);

        if (number2 < 0) {
            number2=0;
            a.setText("0");
        } else {
            a.setText(numberstr2);
        }
    }

    private void up() {
        number++;
        String numberstr = String.valueOf(number);
        TextView a = (TextView) findViewById(R.id.text_0);
        a.setText(numberstr);
    }

    private void down() {
        number--;
        String numberstr = String.valueOf(number);
        TextView a = (TextView) findViewById(R.id.text_0);

        if (number < 0) {
            number=0;
            a.setText("0");
        } else {
            a.setText(numberstr);
        }
    }


    private void cleanmessage() {
        sb3.delete(0, sb3.length());
        TextView a = (TextView) findViewById(R.id.text_product3);
        a.setText(sb3);

    }

    private void setMenumessage() {
        sb.delete(0, sb.length());
        if (number > 0) {
            sb.append(productname1 + "x" + number + "份，小計=" + number * price + "元");
        }
    }

    private void showMenumessage() {
        TextView a = (TextView) findViewById(R.id.text_product1);
        a.setText(sb);
    }

    private void setTotalmessage() {

        int numbertotal = number + number2;
        if (number <= 0 && number2 <=0) {
            sb3.append("尚未輸入任何餐點");
        }

        else

        {
            sb3.append("總共= " + numbertotal * price + "元");
        }
    }
    private void showTotalmessage() {
        TextView a = (TextView) findViewById(R.id.text_product3);
        a.setText(sb3);
    }


}
