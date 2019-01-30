package com.tugasbesar.jadwalsholatku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import at.markushi.ui.CircleButton;

public class Tasbih extends AppCompatActivity {

    //pendeklarasian
    CircleButton btn;
    TextView showValue;
    int counter = 0;

    //agar tombol bisa di klik
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);

        btn =(CircleButton) findViewById(R.id.circleButton); //tombol button
        showValue = (TextView) findViewById(R.id.counterValue); //untuk menampilkan hasil hitungan ketika kita membaca sholawat dan sebagainya

    }

    //agar ketikaa diklik perhitungannya akan bertambah
    public void countIn(View view) {
        counter++;
        showValue.setText(Integer.toString(counter));
    }

    //tombol untuk mereset hitungan menjadi awal
    public void resetCount(View view) {
        counter = 0;
        showValue.setText(String.valueOf(counter));
    }
}
