package com.example.ankiit.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class SlotBook extends AppCompatActivity {

    private Button btn;
    private TextView tv;
    private TextView tv1;
    private Spinner sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slotbooking);
        btn = (Button) findViewById(R.id.button2);
        //tv = (TextView) findViewById(R.id.tview);
        sp = (Spinner) findViewById(R.id.spin);
        tv1 = (TextView) findViewById(R.id.tvprofile);
        String [] slots = {"9 am - 12 pm", "12 pm - 3 pm", "3 pm - 6 pm", "6 pm - 9 pm"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, slots);
        sp.setAdapter(adapter);



       // Random random = new Random();
        //int number = random.nextInt(4);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(SlotBook.this,Profile.class);
                startActivity(inte);
            }
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int ran = (int) (Math.random()*4);

            }
        });
    }
}
